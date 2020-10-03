package rmi;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/**
 * 
 * @author ԭ����
 *	�Զ����������
 * ���ͻ��ˣ�
 */
 
public class Myclassloader extends ClassLoader {
	//�������൱ǰĿ¼
	private String directory;
    
    public Myclassloader(String directory) {
    	this.directory = directory;
    }
    
    public Myclassloader(String directory ,ClassLoader Parent) {
    	super(Parent);
    	this.directory = directory;
    }
    
    //��дClassLoader�е�findClass����
    @Override
    protected Class<?> findClass(String name){
    	
    		byte[] data = null;
			try {
				//��ȡ�ֽ����ļ�
				File file1 = new File("bin/rmi/DisPlayImpl.class");
				if(!file1.exists()) {
					System.out.println("δ�ҵ�"+file1.getName()+"\n���ڳ���ͨ�����ܻ�ȡ�ֽ����ļ�\n");
					File file2 = new File("test/DisPlayImpl.hhh");
					if(!file2.exists()) {
						System.out.println("\nδ�ҵ�"+file2.getName()+"\n���ڳ��Դӷ���˻�ȡ�����ļ�\n");
						FileTrans trans = new FileTransGet();
						trans.getFile();
					}
					if(!file2.exists()) {
						System.out.println("��ȡʧ��");
						System.exit(-1);
					}
					else {
						File encFile = new File("test/DisPlayImpl.hhh");
						File decFile = new File("bin/rmi/DisPlayImpl.class");
				
						File_EAD ead = new File_Dec();
						ead.DecFile(encFile, decFile);
					}
				}
				
				
				String file = directory + File.separator + name.replace(".", File.separator)+".class";
				//����������
				InputStream in = new FileInputStream(file);
				//�����ֽ������
				ByteArrayOutputStream baos = new ByteArrayOutputStream();
				byte[] buf = new byte[1024];
				int len = -1;
				
				while((len = in.read(buf))!=-1)
				{
					baos.write(buf,0,len);
				}
				
				data = baos.toByteArray();
				in.close();
				baos.close();
			} catch (FileNotFoundException e) {
				System.out.println(e);
			} catch (IOException e) {
				System.out.println(e);
			} catch (Exception e) {
				System.out.println(e);
			}
        	return defineClass(name, data, 0,data.length);
		
    }
}