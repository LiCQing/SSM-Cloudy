package com.jsu.service;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jsu.dao.TbFileMapper;
import com.jsu.pojo.TbFile;
import com.jsu.pojo.TbFileExample;
import com.jsu.pojo.TbFileExample.Criteria;

@Service
public class TbFileMapperService {
	@Autowired
	private TbFileMapper fileMapper;

	private final static int ISDELETE = -1;
	private final static int NOMOR = 0;
	private final static int CDELETE = -2;

	/**
	 * 查询数据总记录条数
	 * 
	 * @param example
	 * @return
	 */
	public int countByExample(TbFileExample example) {
		return fileMapper.countByExample(example);
	}

	/**
	 * 删除记录
	 * 
	 * @param example
	 * @return
	 */
	public int deleteByExample(TbFileExample example) {

		return fileMapper.deleteByExample(example);

	}

	/**
	 * 根据主键fid删除一条记录
	 * 
	 * @param fId
	 * @return
	 */
	public int deleteByPrimaryKey(Integer fId) {
		return fileMapper.deleteByPrimaryKey(fId);
	}

	/**
	 * 插入一条记录
	 * 
	 * @param record
	 * @return
	 */
	public int insert(TbFile record) {
		return fileMapper.insert(record);
	}

	/**
	 * 插入一条记录方法二
	 * 
	 * @param record
	 * @return
	 */
	public int insertSelective(TbFile record) {
		return fileMapper.insertSelective(record);
	}

	/**
	 * 根据TbFileExample example查询记录返回数组
	 * 
	 * @param example
	 * @return
	 */
	public List<TbFile> selectByExample(TbFileExample example) {
		return fileMapper.selectByExample(example);

	}

	/**
	 * 根据fid查找到一条记录
	 * 
	 * @param fId
	 * @return
	 */
	public TbFile selectByPrimaryKey(Integer fId) {
		System.out.println("----" + fileMapper);
		return fileMapper.selectByPrimaryKey(fId);
	}

	/**
	 * 根据 TbFile TbFileExample修改记录方法二
	 * 
	 * @param record
	 * @param example
	 * @return
	 */

	public int updateByExampleSelective(@Param("record") TbFile record, @Param("example") TbFileExample example) {

		return fileMapper.updateByExampleSelective(record, example);
	}

	/**
	 * 根据 TbFile TbFileExample修改记录方法一
	 * 
	 * @param record
	 * @param example
	 * @return
	 */

	public int updateByExample(@Param("record") TbFile record, @Param("example") TbFileExample example) {

		return fileMapper.updateByExample(record, example);
	}

	/**
	 * 根据TbFile修改记录方法二
	 * 
	 * @param record
	 * @return
	 */
	public int updateByPrimaryKeySelective(TbFile record) {
		return fileMapper.updateByPrimaryKeySelective(record);
	}

	/**
	 * 根据TbFile修改记录方法一
	 * 
	 * @param record
	 * @return
	 */
	public int updateByPrimaryKey(TbFile record) {
		return fileMapper.updateByPrimaryKey(record);
	}

	/**
	 * 根据uid查询顶级目录
	 * 
	 * @param uId
	 * @param pId
	 * @return
	 */
	public List<TbFile> selectByUserId(Integer uId, Integer pId) {
		return fileMapper.selectByUserId(uId, pId);

	}

	/**
	 * 根据fid查询pid返回TbFile
	 * 
	 * @param fId
	 * @return
	 */
	public List<TbFile> selectByFid(Integer fId) {
		return fileMapper.selectByFid(fId);
	}

	public List<TbFile> selectByPid(Integer pId) {
		return fileMapper.selectByPid(pId);
	}

	// 模糊查找
	public List<TbFile> searchByfileName(String filename) {
		TbFileExample example = new TbFileExample();
		Criteria criteria = example.createCriteria();
		criteria.andFNameLike("%" + filename + "%");
		return fileMapper.selectByExample(example);
		// return fileMapper.searchFile(filename);
	}

	// 分类查询
	public List<TbFile> searchByCate(int cate, int uid) {
		TbFileExample example = new TbFileExample();// 创建一个对象
		Criteria criteria = example.createCriteria();// 创建一个条件
		criteria.andFCateEqualTo(cate); // 查找的条件
		criteria.andUIdEqualTo(uid);
		criteria.andFStatusEqualTo(0);
		return fileMapper.selectByExample(example);
	}

	public TbFile selectByPidName(int pId, String fName) {
		return fileMapper.selectByPidName(pId, fName);
	}

	// 删除文件
	public boolean deleteFile(int[] fid, int state) {
		for (int i = 0; i < fid.length; i++) {
			TbFile tbfile = fileMapper.selectByPrimaryKey(fid[i]);
			tbfile.setfStatus(state);
			tbfile.setfDeleteTime(new Date());
			fileMapper.updateByPrimaryKey(tbfile);
			// 如果是目录文件，递归删除子文件
			if (tbfile.getIsDir() == 1) {
				List<TbFile> list = fileMapper.selectByPid(tbfile.getfId());
				int[] fids = new int[list.size()];
				for (int j = 0; j < list.size(); j++) {
					fids[j] = list.get(j).getfId();
				}
				if (fids.length > 0) {
					deleteFile(fids, CDELETE);
				}
			}
		}

		return true;

	}

	// 查看回收站文件
	public List<TbFile> rcycleFileList(int uid) {
		TbFileExample example = new TbFileExample();
		Criteria createCriteria = example.createCriteria();
		createCriteria.andUIdEqualTo(uid);
		createCriteria.andFStatusEqualTo(ISDELETE);
		createCriteria.andUIdEqualTo(uid);
		List<TbFile> filelist = fileMapper.selectByExample(example);
		return filelist;
	}

	// 多文件恢复
	public boolean filesList(int[] fids) {

		for (int i = 0; i < fids.length; i++) {
			TbFile tbfile = fileMapper.selectByPrimaryKey(fids[i]);
			tbfile.setfStatus(NOMOR);
			fileMapper.updateByPrimaryKey(tbfile);
			// 如果是目录文件，递归删除子文件
			if (tbfile.getIsDir() == 1) {
				List<TbFile> list = getChildren(tbfile.getfId(), CDELETE);
				int[] fid = new int[list.size()];
				for (int j = 0; j < list.size(); j++) {
					fid[j] = list.get(j).getfId();
				}
				if (fid.length > 0) {
					filesList(fid);
				}
			}
		}
		return true;
	}

	// 根据状态选择子文件
	public List<TbFile> getChildren(int pid, int status) {
		TbFileExample exaple = new TbFileExample();
		Criteria criteria = exaple.createCriteria();
		criteria.andPIdEqualTo(pid);
		criteria.andFStatusEqualTo(status);
		return fileMapper.selectByExample(exaple);
	}

	public boolean filesLists(List<Integer> fids) {

		fileMapper.updateAuditMember(fids);
		return true;
	}

	public boolean reduction(int fid) {
		TbFile tbfile = fileMapper.selectByPrimaryKey(fid);
		tbfile.setfStatus(0);
		fileMapper.updateByPrimaryKey(tbfile);
		return true;
	}

	/**
	 * 物理删除
	 * 
	 * @param fid
	 */
	public void delelteRecord(int[] fids) {
		for (int i : fids) {
			System.out.println(i);
		}
		for (int i = 0; i < fids.length; i++) {
			TbFile tbfile = fileMapper.selectByPrimaryKey(fids[i]);
			fileMapper.deleteByPrimaryKey(tbfile.getfId());
			// 如果是目录文件，递归删除子文件
			if (tbfile.getIsDir() == 1) {
				List<TbFile> list = getChildren(tbfile.getfId(),CDELETE);
				int[] fid = new int[list.size()];
				for (int j = 0; j < list.size(); j++) {
					fid[j] = list.get(j).getfId();
				}
				if (fid.length > 0) {
					delelteRecord(fid);
				}
			}
		}
	}

}
