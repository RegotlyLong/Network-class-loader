package rmi;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * 
 * @author ԭ����
 *	ʵ��File_EAD�ӿڣ��ͻ��ˣ�
 *	���������ܵķ�ʽ
 */
public class File_Dec implements File_EAD {
	private static final int numToEncAndDec = 0x99;//���ܽ�����Կ
	private static int dataFile = 0;//�ļ��ֽ�����
	
	//�����㷨
	public void DecFile(File encFile,File decFile) throws IOException {
		if(encFile.exists() == false) {
			System.out.println("�����ļ�������");
			return;
		}
		
		if(decFile.exists() == false) {
			System.out.println("�����ļ�������");
			decFile.createNewFile();
		}
		else {
			System.out.println("�����ļ��Ѵ���");
			return;
		}
		
		InputStream fis = new FileInputStream(encFile);
		OutputStream fos = new FileOutputStream(decFile);
		
		//�����ܺ������д���ļ�
		while((dataFile = fis.read()) > -1) {
			fos.write(dataFile^numToEncAndDec);
		}
		
		fis.close();
		fos.flush();
		fos.close();
	}
}
