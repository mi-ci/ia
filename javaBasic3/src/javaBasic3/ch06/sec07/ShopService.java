package javaBasic3.ch06.sec07;

public class ShopService {

	private static ShopService shopService = new ShopService();
	private ShopService () {
		
	}
	
	public static ShopService getIService() {
		return shopService;
}
//	private static ShopService shopService = new ShopService();
	
//	}
	
	


//	public static ShopService getInstance() {
//		// TODO Auto-generated method stub
//		return shopService;}
	}


// ��Ʈ ��Ŭ�� �������� ShopService Ŭ������ ����� �ش�.
//1. �����ڴ� private 2.�ʵ�� ��üȭ�ؼ� �������� �ּҸ� �����ϰ� private�մϴ�.
//�޼ҵ��� getInstance()���� ���ϰ��� �������� �ּ��Ԉ���. ���������ڴ� public