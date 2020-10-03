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
 * @author ԭ����
 * ��ͻ��˷����ļ�
 * ������ˣ�
 */
public class FileTransSend implements FileTrans{
	public void sendFile() throws RemoteException, Exception {
		
		ServerSocket server = null;//�ͻ���ר���׽���
		Socket socket = null;//�ͻ����׽���
		FileInputStream fis = null;//�ļ�������
		DataOutputStream dos= null;//���������
		try {
			//��socket
			server = new ServerSocket(10086);
		}catch (IOException e) {
			System.out.println(e);
		}
		
		try {
			System.out.println("�ȴ��ͻ�����");
			socket = server.accept();
			if(socket!=null) {
				System.out.println("���ӳɹ�");
			}
			
			//�ж���Ҫ���͵��ļ��Ƿ����
			File file = new File("test/DisPlayImpl.hhh");
			if(file.exists()) {
				System.out.println("Ŀ���ļ�����");
				
				fis = new FileInputStream(file);
				dos = new DataOutputStream(socket.getOutputStream());
				
				//���������д���ļ����Լ��ļ�����
				dos.writeUTF(file.getName());
				dos.flush();
				dos.writeLong(file.length());
				dos.flush();
				
				//��ʼ�����ļ�
				System.out.println("��ʼ�����ļ�");
				byte[] bytes = new byte[1024];
				int length = 0;
				while((length=fis.read(bytes,0,bytes.length))!=-1) {
					dos.write(bytes,0,length);
					dos.flush();
				}
				System.out.println();
				System.out.println("�ļ�����ɹ�    "+file.getName());
				Thread.sleep(500);
				
			}
			
			}catch (Exception e) {
			System.out.println("�����ѶϿ� ");
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
