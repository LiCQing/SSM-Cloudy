package com.jsu.vo;

/**
 * 统一返回结果
 * {
 * 	 status : 响应状态
 * 	 data: 存放内容
 * }
 * @author !N
 *
 */

public class YunResult {
	//200 请求成功  500 产生异常
	private int status;
	//存放数据
	private Object data;
	
	/**
	 * 返回请求成功的数据
	 * @param data
	 * @return
	 */
	public static YunResult success(Object data){
		YunResult yun = new YunResult();
		yun.setStatus(200);
		yun.setData(data);
		return yun;
	}
	
	/**
	 * 返回请求发生异常的数据
	 * @param data
	 * @return
	 */
	public static YunResult error(Object data){
		YunResult yun = new YunResult();
		yun.setStatus(500);
		yun.setData(data);
		return yun;
	}
	
	public int getStatus() {
		return status;
	}
	private void setStatus(int status) {
		this.status = status;
	}
	public Object getData() {
		return data;
	}
	private void setData(Object data) {
		this.data = data;
	}
	
	
}
