package rmi;

/**
 * 
 * @author ԭ����
 * �ͻ���������
 * 
 * ע�⣺�����Myclassloader()�е�����Ӧ����ʵ�ʵľ���·����д��������
 */
public class ClientLaunch {
	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws Exception {
		
		//ʹ�����������DisPlayImpl����ֽ����ļ��������������
		//�˴�ʹ�õ��Ǿ���·����Ӧע�⣡����
		Myclassloader classloader = new Myclassloader("F:\\main\\study\\java\\Work_Client\\bin");
		Class<?> clazz = classloader.loadClass("rmi.DisPlayImpl");
		try {
			displayable dpa = (displayable) clazz.newInstance();
			System.out.println("\n���ڵ���display����");
			System.out.println();
			
		//ʹ�ýӿڻص��ķ�ʽ����display����
			dpa.display();
		}catch (Exception e) {
			System.out.println(e);
		}
	}
}
