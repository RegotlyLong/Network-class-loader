package rmi;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.net.Socket;
import java.rmi.RemoteException;

/**
 * 
 * @author 原毅哲
 * 从服务端获取文件
 * （客户端）
 */
public class FileTransGet implements FileTrans{
	public void getFile() throws RemoteException,Exception{
		
		Socket socket = null;//服务端套接字
		DataInputStream dis = null;//字节型输入流
		FileOutputStream fos = null;//文件型输出流
		
		try {
			//绑定socket
			socket = new Socket("127.0.0.1",10086);
			dis = new DataInputStream(socket.getInputStream());
			
			//获取文件名和长度
			String filename = dis.readUTF();
			@SuppressWarnings("unused")
			long filelength = dis.readLong();
			
			//创建文件保存目录
			File directory = new File("test");
			if(!directory.exists()) {
				directory.mkdir();
			}
			File file = new File(directory.getCanonicalPath() + File.separatorChar + filename);
			fos = new FileOutputStream(file);
			
			//开始接收文件
			byte[] bytes = new byte[1024];
			int length = 0;
			while((length = dis.read(bytes,0,bytes.length))!=-1) {
				fos.write(bytes, 0, length); 
		        fos.flush();
			}
			System.out.println("文件接收成功    " + filename);
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("与服务器连接失败");
		}		
	}	
}
