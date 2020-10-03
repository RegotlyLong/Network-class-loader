package rmi;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.rmi.RemoteException;

/**
 * 
 * @author 原毅哲
 * 向客户端发送文件
 * （服务端）
 */
public class FileTransSend implements FileTrans{
	public void sendFile() throws RemoteException, Exception {
		
		ServerSocket server = null;//客户端专用套接字
		Socket socket = null;//客户端套接字
		FileInputStream fis = null;//文件输入流
		DataOutputStream dos= null;//数据输出流
		try {
			//绑定socket
			server = new ServerSocket(10086);
		}catch (IOException e) {
			System.out.println(e);
		}
		
		try {
			System.out.println("等待客户呼叫");
			socket = server.accept();
			if(socket!=null) {
				System.out.println("连接成功");
			}
			
			//判断所要发送的文件是否存在
			File file = new File("test/DisPlayImpl.hhh");
			if(file.exists()) {
				System.out.println("目标文件存在");
				
				fis = new FileInputStream(file);
				dos = new DataOutputStream(socket.getOutputStream());
				
				//向输出流中写入文件名以及文件长度
				dos.writeUTF(file.getName());
				dos.flush();
				dos.writeLong(file.length());
				dos.flush();
				
				//开始传输文件
				System.out.println("开始传输文件");
				byte[] bytes = new byte[1024];
				int length = 0;
				while((length=fis.read(bytes,0,bytes.length))!=-1) {
					dos.write(bytes,0,length);
					dos.flush();
				}
				System.out.println();
				System.out.println("文件传输成功    "+file.getName());
				Thread.sleep(500);
				
			}
			
			}catch (Exception e) {
			System.out.println("连接已断开 ");
			}finally {
				if(fis!=null) {
					fis.close();
				}
				if(dos!=null) {
					dos.close();
				}
				socket.close();
			}
		
	}
	
}
