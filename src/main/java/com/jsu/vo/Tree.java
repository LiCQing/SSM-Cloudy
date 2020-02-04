package com.jsu.vo;

import java.util.List;

import com.jsu.pojo.TbFile;

public class Tree {
	//titile fid url children
	private String title;
	private int fid;
	private String url;
	private List<Tree> children = null;
	
	
	public int getFid() {
		return fid;
	}
	public void setFid(int fid) {
		this.fid = fid;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public List<Tree> getChildren() {
		return children;
	}
	public void setChildren(List<Tree> children) {
		this.children = children;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	/*public List<Tree> select(List<Tree> lists ){
		//List<Tree> lists=null ;
		for(Tree tree:lists)
		{
		for (TbFile tbfile: tree.getChildren) {
			
			if(tbfile.getisDir==1){
				select();
			}else {
				lists.add(tbfile)
				
			}
		}

	}*/
}
