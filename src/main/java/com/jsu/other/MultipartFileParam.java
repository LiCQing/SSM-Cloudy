package com.jsu.other;


import org.springframework.web.multipart.MultipartFile;

/**
 *  文件分片上传，不要动，后面在改
 * version 1.0
 */
public class MultipartFileParam {
	
	/**
	 * chunkNumber: 1
		chunkSize: 204800
		currentChunkSize: 80522
		totalSize: 80522
		identifier: 1b6180e11485291f208d0e28ad4618d5
		filename: zexmi5v5.jpeg
		relativePath: zexmi5v5.jpeg
		totalChunks: 1
		file: (binary)
	 */

    //任务ID
    private String id;
    //总分片数量
    private int totalChunks;
    //当前为第几块分片
    private int chunkNumber;
    //当前分片大小
    private long currentChunkSize = 0L;
    //文件名
    private String filename;
    //分片对象
    private MultipartFile file;
    // MD5
    private String identifier;
    //大小S
    private Long totalSize;
    //父对象id
    private Integer pId;
    
    private String token;
    
    
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getTotalChunks() {
		return totalChunks;
	}
	public void setTotalChunks(int totalChunks) {
		this.totalChunks = totalChunks;
	}
	public int getChunkNumber() {
		return chunkNumber;
	}
	public void setChunkNumber(int chunkNumber) {
		this.chunkNumber = chunkNumber;
	}
	public long getCurrentChunkSize() {
		return currentChunkSize;
	}
	public void setCurrentChunkSize(long currentChunkSize) {
		this.currentChunkSize = currentChunkSize;
	}
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	public MultipartFile getFile() {
		return file;
	}
	public void setFile(MultipartFile file) {
		this.file = file;
	}
	public String getIdentifier() {
		return identifier;
	}
	public void setIdentifier(String identifier) {
		this.identifier = identifier;
	}
	@Override
	public String toString() {
		return "MultipartFileParam [id=" + id + ", totalChunks=" + totalChunks + ", chunkNumber=" + chunkNumber
				+ ", currentChunkSize=" + currentChunkSize + ", filename=" + filename + ", file=" + file
				+ ", identifier=" + identifier + "]";
	}
	public Long getTotalSize() {
		return totalSize;
	}
	public void setTotalSize(Long totalSize) {
		this.totalSize = totalSize;
	}
	public Integer getpId() {
		return pId;
	}
	public void setpId(Integer pId) {
		this.pId = pId;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
    
    

}