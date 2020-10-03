package rmi;

import java.io.File;

/**
 * 
 * @author 原毅哲
 *	文件加密解密接口（服务端）
 */
public interface File_EAD {
	//定义加密方法
	void EncFile(File srcFile,File encFile) throws Exception;
}
