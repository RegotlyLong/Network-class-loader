package rmi;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * 
 * @author ԭ����
 * ʵ��File_EAD�ӿڣ�����ˣ�
 * ���������ܵķ�ʽ
 */
public class File_Enc implements File_EAD {
	private static final int numToEncAndDec = 0x99;//���ܽ�����Կ
	private static int dataFile = 0;//�ļ��ֽ�����
	
	//�����㷨
	public void EncFile(File srcFile,File encFile) throws Exception{
		if(srcFile.exists() == false) {
			System.out.println("Ŀ���ļ�������");
			return;
		}
		
		if(encFile.exists() == false) {
			System.out.println("�����ļ�������");
			encFile.createNewFile();
		}
		else {
			System.out.println("�����ļ��Ѵ���");
			return;
		}
		
		InputStream fis = new FileInputStream(srcFile);
		OutputStream fos = new FileOutputStream(encFile);
		
		//�����ܺ������д���ļ�
		while((dataFile = fis.read()) > -1) {
			fos.write(dataFile^numToEncAndDec);
		}
		
		fis.close();
		fos.flush();
		fos.close();
	}
	
	
}
