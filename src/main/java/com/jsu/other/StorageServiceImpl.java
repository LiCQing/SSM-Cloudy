package com.jsu.other;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.FileSystemUtils;

import com.jsu.dao.TbFileMapperMapper;
import com.jsu.pojo.TbFile;
import com.jsu.pojo.TbFileMapper;
import com.jsu.pojo.TbFileMapperExample;
import com.jsu.pojo.TbFileMapperExample.Criteria;
import com.jsu.util.AESUtil;
import com.jsu.util.FileMD5Util;

/**
 * 
 */
@Service
public class StorageServiceImpl {

    private final Logger logger = LoggerFactory.getLogger(StorageServiceImpl.class);
    // 保存文件的根目录
    private Path rootPaht;

    @Autowired
    private TbFileMapperMapper  fileMapperMapper;
    @Autowired
    private com.jsu.dao.TbFileMapper fileMaper ;

    //这个必须与前端设定的值一致
// @Value("${breakpoint.upload.chunkSize}") 
    private long CHUNK_SIZE = 1024 * 1024;

  //  @Value("${breakpoint.upload.dir}")
    //private String finalDirPath = "D:\\test\\";

    @Autowired
    public StorageServiceImpl(@Value("${breakpoint.upload.dir}") String location) {
        this.rootPaht = Paths.get(location);
    }

    public void deleteAll() {
        logger.info("开发初始化清理数据，start");
        FileSystemUtils.deleteRecursively(rootPaht.toFile());
        logger.info("开发初始化清理数据，end");
    }

    public void init() {
        try {
            Files.createDirectory(rootPaht);
        } catch (FileAlreadyExistsException e) {
            logger.error("文件夹已经存在了，不用再创建。");
        } catch (IOException e) {
            logger.error("初始化root文件夹失败。", e);
        }
    }

    /**
     * 通过NIO上传
     * @param param
     * @throws IOException
     */
   public void uploadFileByMappedByteBuffer(MultipartFileParam param,String finalDirPath) throws IOException {
    	//获取文件名和上传路径
        String fileName = param.getIdentifier();
        String uploadDirPath = finalDirPath; // + param.getIdentifier();
        String tempFileName = fileName + "_tmp";
       
        //新建临时文件
        File tmpDir = new File(uploadDirPath);
        File tmpFile = new File(uploadDirPath, tempFileName);
        if (!tmpDir.exists()) {
            tmpDir.mkdirs();
        }
        
       // System.out.println(tempFileName);
        //使用随机读写文件
        RandomAccessFile tempRaf = new RandomAccessFile(tmpFile, "rw");
        FileChannel fileChannel = tempRaf.getChannel();

        //写入该分片数据
        long offset = CHUNK_SIZE * (param.getChunkNumber() -1);
        byte[] fileData = param.getFile().getBytes();
        System.out.println(offset  + " " +  fileData.length);
        MappedByteBuffer mappedByteBuffer = fileChannel.map(FileChannel.MapMode.READ_WRITE, offset, fileData.length);
        mappedByteBuffer.put(fileData);
        // 释放
        FileMD5Util.freedMappedByteBuffer(mappedByteBuffer);
        fileChannel.close();
        //查看上传状态
        boolean isOk = checkAndSetUploadProgress(param, uploadDirPath);
        if (isOk) {
     	   String filename = param.getFilename();
     	   filename =  param.getIdentifier() + filename.substring(filename.lastIndexOf('.'));
     	   
            boolean flag = renameFile(tmpFile, filename);
            System.out.println("upload complete !!" + flag + " name=" + param.getFilename());
          
           //修改文件上传状态 
            TbFileMapperExample example = new TbFileMapperExample();
            Criteria criteria = example.createCriteria();
            criteria.andMMd5EqualTo(param.getIdentifier());
            TbFileMapper fileMapper = fileMapperMapper.selectByExample(example).get(0);
            fileMapper.setmSatus(-1);
			fileMapperMapper.updateByPrimaryKey(fileMapper);
			
			//插入用户上传文件
			addNewFile(param,fileMapper);
        }
    }

    private static Integer getCate(String filename) {
    	String IMG = "img|jpeg|png|gif|jpg";
    	String VIDIO = "mp4|avi|wmv|mov";
    	String MUSIC = "mp3|wma";
    	String ZIP="zip|rar";
    	String TXT ="txt|docx|doc|pdf";
    	int pointIndex = filename.lastIndexOf('.') + 1;
    	filename = filename.substring(pointIndex).toLowerCase();
    	if(filename.indexOf('|')!=-1){
    		return 9; //其他
    	}
    	if(IMG.indexOf(filename) != -1){
    		return 1; //img
    	}
    	if(VIDIO.indexOf(filename)!=-1){
    		return 2;  //mp4
    	}
    	if(MUSIC.indexOf(filename)!=-1){
    		return 3;
    	}
    	if(ZIP.indexOf(filename)!=-1){
    		return 4;
    	}
    	if(TXT.indexOf(filename)!=-1){
    		return 5;
    	}
		return 9;
	}
    
    public static void main(String[] args) {
    	getCate("adfasf.adfadsf.adsfasf.jpg");
	}

	/**
     * 检查并修改文件上传进度
     *
     * @param param
     * @param uploadDirPath
     * @return
     * @throws IOException
     */
    private boolean checkAndSetUploadProgress(MultipartFileParam param, String uploadDirPath) throws IOException {
    	String fileName = param.getIdentifier();
    	//写一个配置文件，记录上传块成功情况
        File confFile = new File(uploadDirPath, fileName + ".conf");
        RandomAccessFile accessConfFile = new RandomAccessFile(confFile, "rw");
        //把该分段标记为 true 表示完成
        System.out.println("set part " + (param.getChunkNumber() - 1) + " complete");
        //设置文件长度为块数
        accessConfFile.setLength(param.getTotalChunks());
        //移动光标到当前块数
        accessConfFile.seek(param.getChunkNumber()-1);
        //写入一个btye位
        accessConfFile.write(Byte.MAX_VALUE);

        //completeList 检查是否全部完成,如果数组里是否全部都是(全部分片都成功上传)
        byte[] completeList = FileUtils.readFileToByteArray(confFile);
        byte isComplete = Byte.MAX_VALUE;
        for (int i = 0; i < completeList.length && isComplete == Byte.MAX_VALUE; i++) {
            //与运算, 如果有部分没有完成则 isComplete 不是 Byte.MAX_VALUE
            isComplete = (byte) (isComplete & completeList[i]);
            System.out.println("check part " + i + " complete?:" + completeList[i]);
        }

        accessConfFile.close();
        if (isComplete == Byte.MAX_VALUE) {
        	
        	
        	System.out.println("上传完成");
            return true;
        } else {
        	
        	System.out.println("未完成");
            return false;
        }
    }

    /**
     * 文件重命名
     *
     * @param toBeRenamed   将要修改名字的文件
     * @param toFileNewName 新的名字
     * @return
     */
    public boolean renameFile(File toBeRenamed, String toFileNewName) {
        //检查要重命名的文件是否存在，是否是文件
        if (!toBeRenamed.exists() || toBeRenamed.isDirectory()) {
            logger.info("File does not exist: " + toBeRenamed.getName());
            return false;
        }
        String p = toBeRenamed.getParent();
        File newFile = new File(p + File.separatorChar + toFileNewName);
        //修改文件名
        return toBeRenamed.renameTo(newFile);
    }

    public TbFileMapper checkMd5(String md5){
 	   TbFileMapperExample example = new TbFileMapperExample();
 	   Criteria criteria = example.createCriteria();
 	   criteria.andMMd5EqualTo(md5);
	List<TbFileMapper> list = fileMapperMapper.selectByExample(example);
 	   return list.size()==0?null:list.get(0);
    }
    
    /**
     * 添加一个记录进度文件
     * @param param
     * @param path
     * @throws FileNotFoundException 
     */
	public void addNewFileRecod(MultipartFileParam param, String path) throws Exception {
		   File confFile = new File(path, param.getIdentifier() + ".conf");
	        RandomAccessFile accessConfFile = new RandomAccessFile(confFile, "rw");
	        //设置文件长度为块数
	        accessConfFile.setLength(param.getTotalChunks());
	        //completeList 检查是否全部完成,如果数组里是否全部都是(全部分片都成功上传)
	}

	public String getMissingChunks(MultipartFileParam param, String path) throws IOException {
		String fileName = param.getIdentifier();
    	//写一个配置文件，记录上传块成功情况
        File confFile = new File(path, fileName + ".conf");
        RandomAccessFile accessConfFile = new RandomAccessFile(confFile, "rw");
        //设置文件长度为块数
        accessConfFile.setLength(param.getTotalChunks());
        //移动光标到当前块数

        //completeList 检查是否全部完成,如果数组里是否全部都是(全部分片都成功上传)
        byte[] completeList = FileUtils.readFileToByteArray(confFile);
        byte isComplete = Byte.MAX_VALUE;
        String miss = "";
        for (int i = 0; i < completeList.length && isComplete == Byte.MAX_VALUE; i++) {
            //与运算, 如果有部分没有完成则 isComplete 不是 Byte.MAX_VALUE
        	miss += (i+1) +",";
        }

        accessConfFile.close();
		return miss.substring(0,miss.length()-2);
	}

	public void addNewFile(MultipartFileParam param,TbFileMapper fileMapper) {
		 TbFile userFile = new TbFile();
         userFile.setfName(param.getFilename());
         userFile.setfCate(getCate(param.getFilename()));
         userFile.setfCreateTime(new Date());
         userFile.setmId(fileMapper.getmId());
         userFile.setfSize(param.getTotalSize());
         userFile.setIsDir(0);
         userFile.setuId(Integer.parseInt(AESUtil.dcodes(param.getToken())));
         userFile.setpId(param.getpId());
         fileMaper.insertSelective(userFile);
	}


}
