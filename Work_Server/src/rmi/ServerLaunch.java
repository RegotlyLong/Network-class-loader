package rmi;

import java.io.File;

/**
 * 
 * @author 原毅哲
 * 服务端主程序
 *
 */
public class ServerLaunch {
	public static void main(String[] args) throws Exception {
		
		//将要发送至客户端的字节码加密
		File srcFile = new File("bin/rmi/DisPlayImpl.class");
		File encFile = new File("test/DisPlayImpl.hhh");	
		File_EAD ead = new File_Enc();
		ead.EncFile(srcFile, encFile);
		System.out.println();
		
		//将加密后的字字节码发送至客户端
		FileTrans trans = new FileTransSend();
		trans.sendFile();
		
	}
}
