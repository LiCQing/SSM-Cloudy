package com.jsu.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jsu.dao.TbFileMapper;
import com.jsu.dao.TbFileMapperMapper;
import com.jsu.pojo.TbFile;
import com.jsu.pojo.TbFileExample;
import com.jsu.pojo.TbFileExample.Criteria;
import com.jsu.vo.Tree;

@Service
public class TbFileService {
	@Autowired
	TbFileMapper  tbFileMapper;
	
	@Autowired
	TbFileMapperMapper fileMapperDao;
	
	//模糊搜索
	public List<TbFile>  searchFile(String filename){
		//return  tbFileMapper.searchFile(filename);
		return null;
	}
	
	//树形目录结构
		public List<Tree> getDirTree(int uId){
			List<Tree> list = new ArrayList<>();
			Tree  tree = new Tree();
			tree.setFid(0);
			//获取根路径
			TbFileExample example = new TbFileExample();
			Criteria criteria = example.createCriteria();
			criteria.andUIdEqualTo(uId);
			criteria.andPIdEqualTo(0);
			TbFile root = tbFileMapper.selectByExample(example ).get(0);
			Tree rootTree = new Tree();
			rootTree.setFid(root.getfId());
			rootTree.setUrl("我的网盘/");
			rootTree.setTitle("我的网盘");
			rootTree.setChildren(getChidren(0,uId,"我的网盘/"));
			list.add(rootTree);
			return list;
		}

		//递归获取子列表
		private List<Tree> getChidren(int pid,int uId ,String preUrl) {
			List<Tree> list = new ArrayList<>();
			TbFileExample example = new TbFileExample();
			Criteria criteria = example.createCriteria();
			criteria.andUIdEqualTo(uId);
			criteria.andPIdEqualTo(pid);
			criteria.andIsDirEqualTo(1);
			List<TbFile> fileList = tbFileMapper.selectByExample(example );
			for (TbFile tbFile : fileList) {
				Tree tree= new Tree();
				tree.setFid(tbFile.getfId());
				tree.setTitle(tbFile.getfName());
				tree.setUrl(preUrl + tbFile.getfName() + "/" );
				tree.setChildren(getChidren(tbFile.getfId(), uId, tree.getUrl()));
				list.add(tree);
			}
			return list;
		}
		
		//根据用户文件获取文件映射
		public com.jsu.pojo.TbFileMapper getFileById(int fId) {
			TbFile file = tbFileMapper.selectByPrimaryKey(fId);
			com.jsu.pojo.TbFileMapper fileMapper = fileMapperDao.selectByPrimaryKey(file.getmId());
			if(file.getfCate() == 5 ){  //如果是文档设置md5标记，方便后期转码
				fileMapper.setmMd5("1");
			}
			return fileMapper;
		}
		
		/**
		 * 根据文件id获取映射的真实地址
		 * @param fid
		 * @return
		 */
		public Map<String,String> getFileTruthName(Integer[] fid){
			Map<String,String> map = new HashMap<>();
			for(Integer id : fid){
				TbFile file = tbFileMapper.selectByPrimaryKey(id);
				com.jsu.pojo.TbFileMapper fileMapper = fileMapperDao.selectByPrimaryKey(file.getmId());
				/*if(file.getIsDir() == 1){
					list.add(mapper.getmPath());
				}else{
					
				}*/
				//list.add(fileMapper.getmPath());
				map.put(file.getfName(), fileMapper.getmPath());
			}
			return map;
		}


}
