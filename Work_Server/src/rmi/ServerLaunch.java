package rmi;

import java.io.File;

/**
 * 
 * @author ԭ����
 * �����������
 *
 */
public class ServerLaunch {
	public static void main(String[] args) throws Exception {
		
		//��Ҫ�������ͻ��˵��ֽ������
		File srcFile = new File("bin/rmi/DisPlayImpl.class");
		File encFile = new File("test/DisPlayImpl.hhh");	
		File_EAD ead = new File_Enc();
		ead.EncFile(srcFile, encFile);
		System.out.println();
		
		//�����ܺ�����ֽ��뷢�����ͻ���
		FileTrans trans = new FileTransSend();
		trans.sendFile();
		
	}
}
