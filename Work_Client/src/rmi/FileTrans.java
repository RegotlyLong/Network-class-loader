package rmi;

import java.rmi.RemoteException;

/**
 * 
 * @author 原毅哲
 * 文件传输接口（客户端）
 */
public interface FileTrans {
	//接收文件接口
	void getFile() throws RemoteException, Exception;
}
