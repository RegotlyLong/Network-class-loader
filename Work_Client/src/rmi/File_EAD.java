package rmi;

import java.io.File;
import java.io.IOException;

/**
 * 
 * @author 原毅哲
 * 文件加密解密接口（客户端）
 */
public interface File_EAD {
	
	//定义解密方法
	void DecFile(File encFile,File decFile) throws IOException;
}
