package rmi;

/**
 * 
 * @author 原毅哲
 * 客户端主程序
 * 
 * 注意：下面的Myclassloader()中的内容应按照实际的绝对路径填写！！！！
 */
public class ClientLaunch {
	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws Exception {
		
		//使用类加载器将DisPlayImpl类的字节码文件加载至虚拟机中
		//此处使用的是绝对路径，应注意！！！
		Myclassloader classloader = new Myclassloader("F:\\main\\study\\java\\Work_Client\\bin");
		Class<?> clazz = classloader.loadClass("rmi.DisPlayImpl");
		try {
			displayable dpa = (displayable) clazz.newInstance();
			System.out.println("\n正在调用display方法");
			System.out.println();
			
		//使用接口回调的方式调用display方法
			dpa.display();
		}catch (Exception e) {
			System.out.println(e);
		}
	}
}
