package DAO;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Payment {
	public Payment(){
		
	}
	
	// TODO: ������ �Ϸ�Ǿ��� �� GUI���� ȣ���Ͽ� �����߰�
	// ex) GUI���� ShoppingBasket s; �϶�
	// s.getPayment().doCashPay();
	public int doCashPay(final int totalPrice, final int receiveMoney){
		long t = System.currentTimeMillis(); 
		SimpleDateFormat dayTime = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
		String time = dayTime.format(new Date(t));

		return 0;
	}
	
	public boolean doCreditPay(final int totalPrice){

		
		return false;
	}
}
