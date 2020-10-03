package rmi;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.net.Socket;
import java.rmi.RemoteException;

/**
 * 
 * @author ԭ����
 * �ӷ���˻�ȡ�ļ�
 * ���ͻ��ˣ�
 */
public class FileTransGet implements FileTrans{
	public void getFile() throws RemoteException,Exception{
		
		Socket socket = null;//������׽���
		DataInputStream dis = null;//�ֽ���������
		FileOutputStream fos = null;//�ļ��������
		
		try {
			//��socket
			socket = new Socket("127.0.0.1",10086);
			dis = new DataInputStream(socket.getInputStream());
			
			//��ȡ�ļ����ͳ���
			String filename = dis.readUTF();
			@SuppressWarnings("unused")
			long filelength = dis.readLong();
			
			//�����ļ�����Ŀ¼
			File directory = new File("test");
			if(!directory.exists()) {
				directory.mkdir();
			}
			File file = new File(directory.getCanonicalPath() + File.separatorChar + filename);
			fos = new FileOutputStream(file);
			
			//��ʼ�����ļ�
			byte[] bytes = new byte[1024];
			int length = 0;
			while((length = dis.read(bytes,0,bytes.length))!=-1) {
				fos.write(bytes, 0, length); 
		        fos.flush();
			}
			System.out.println("�ļ����ճɹ�    " + filename);
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("�����������ʧ��");
		}		
	}	
}
