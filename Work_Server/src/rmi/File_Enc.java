package rmi;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * 
 * @author 原毅哲
 * 实现File_EAD接口（服务端）
 * 采用异或加密的方式
 */
public class File_Enc implements File_EAD {
	private static final int numToEncAndDec = 0x99;//加密解密密钥
	private static int dataFile = 0;//文件字节内容
	
	//加密算法
	public void EncFile(File srcFile,File encFile) throws Exception{
		if(srcFile.exists() == false) {
			System.out.println("目标文件不存在");
			return;
		}
		
		if(encFile.exists() == false) {
			System.out.println("加密文件已生成");
			encFile.createNewFile();
		}
		else {
			System.out.println("加密文件已存在");
			return;
		}
		
		InputStream fis = new FileInputStream(srcFile);
		OutputStream fos = new FileOutputStream(encFile);
		
		//将加密后的数据写入文件
		while((dataFile = fis.read()) > -1) {
			fos.write(dataFile^numToEncAndDec);
		}
		
		fis.close();
		fos.flush();
		fos.close();
	}
	
	
}
