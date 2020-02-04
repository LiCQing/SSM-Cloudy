package com.jsu.util;

import java.io.File;

import com.artofsolving.jodconverter.DocumentConverter;
import com.artofsolving.jodconverter.openoffice.connection.OpenOfficeConnection;
import com.artofsolving.jodconverter.openoffice.connection.SocketOpenOfficeConnection;
import com.artofsolving.jodconverter.openoffice.converter.OpenOfficeDocumentConverter;

public class ToPDFConverter {
	
	public static String doc2pdf(String filePath) {
		File docFile = new File(filePath);
		filePath = filePath.substring(0, filePath.lastIndexOf("."));
		File pdfFile = new File(filePath+ ".pdf");
		
		String pdfPath = null;
		if(pdfFile.exists()){
			return pdfFile.getAbsolutePath();
		}
		if (docFile.exists()) {
				 OpenOfficeConnection connection = new SocketOpenOfficeConnection("127.0.0.1",8100);
				try {
					connection.connect();
					DocumentConverter converter = new OpenOfficeDocumentConverter(
							connection);
					converter.convert(docFile, pdfFile);
					connection.disconnect();
					pdfPath = pdfFile.getAbsolutePath();
					System.out.println("****pdf转换成功，PDF输出： "+ pdfFile.getPath() + "****");
				} catch (java.net.ConnectException e) {
					e.printStackTrace();
					System.out.println("****swf转换器异常，openoffice 服务未启动！****");
				} catch (com.artofsolving.jodconverter.openoffice.connection.OpenOfficeException e) {
					e.printStackTrace();
					System.out.println("****swf转换器异常，读取转换文件 失败****");
				} catch (Exception e) {
					e.printStackTrace();
				}
		}
		return pdfPath;
	}
	
	public static void main(String[] args) {
		
	}
	
}
