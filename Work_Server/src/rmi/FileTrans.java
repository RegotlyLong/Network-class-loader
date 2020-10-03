package rmi;

import java.rmi.RemoteException;

/**
 * 
 * @author 原毅哲
 *	文件传输接口（服务端）
 */
public interface FileTrans {
	//发送文件方法
	void sendFile() throws RemoteException, Exception;
}
