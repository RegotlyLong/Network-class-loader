package rmi;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * 
 * @author 原毅哲
 *	实现File_EAD接口（客户端）
 *	采用异或加密的方式
 */
public class File_Dec implements File_EAD {
	private static final int numToEncAndDec = 0x99;//加密解密密钥
	private static int dataFile = 0;//文件字节内容
	
	//解密算法
	public void DecFile(File encFile,File decFile) throws IOException {
		if(encFile.exists() == false) {
			System.out.println("加密文件不存在");
			return;
		}
		
		if(decFile.exists() == false) {
			System.out.println("解密文件以生成");
			decFile.createNewFile();
		}
		else {
			System.out.println("解密文件已存在");
			return;
		}
		
		InputStream fis = new FileInputStream(encFile);
		OutputStream fos = new FileOutputStream(decFile);
		
		//将解密后的数据写入文件
		while((dataFile = fis.read()) > -1) {
			fos.write(dataFile^numToEncAndDec);
		}
		
		fis.close();
		fos.flush();
		fos.close();
	}
}
