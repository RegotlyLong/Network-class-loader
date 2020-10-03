package rmi;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/**
 * 
 * @author 原毅哲
 *	自定义类加载器
 * （客户端）
 */
 
public class Myclassloader extends ClassLoader {
	//被加载类当前目录
	private String directory;
    
    public Myclassloader(String directory) {
    	this.directory = directory;
    }
    
    public Myclassloader(String directory ,ClassLoader Parent) {
    	super(Parent);
    	this.directory = directory;
    }
    
    //覆写ClassLoader中的findClass方法
    @Override
    protected Class<?> findClass(String name){
    	
    		byte[] data = null;
			try {
				//获取字节码文件
				File file1 = new File("bin/rmi/DisPlayImpl.class");
				if(!file1.exists()) {
					System.out.println("未找到"+file1.getName()+"\n正在尝试通过解密获取字节码文件\n");
					File file2 = new File("test/DisPlayImpl.hhh");
					if(!file2.exists()) {
						System.out.println("\n未找到"+file2.getName()+"\n正在尝试从服务端获取加密文件\n");
						FileTrans trans = new FileTransGet();
						trans.getFile();
					}
					if(!file2.exists()) {
						System.out.println("获取失败");
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
				//构建输入流
				InputStream in = new FileInputStream(file);
				//构建字节输出流
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