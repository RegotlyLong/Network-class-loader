package rmi;

/**
 * 
 * @author 原毅哲
 * （服务端）
 */
public class DisPlayImpl implements displayable{

	//实现displayable接口中的display方法（在控制台中输出任何一句话）
	@Override
	public void display() throws Exception {
		System.out.println("Hello World !\nI like coding !");
		
	}

}
