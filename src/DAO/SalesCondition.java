package DAO;

import java.text.SimpleDateFormat;
import java.util.Date;

public class SalesCondition {
	private int totalSalesMoney;
	
	public SalesCondition(){
		
	}

	public void daySalesCheck(){
		
	}

	public void monthSalesCheck(){
		
	}
	
	// ������Ȳ�� �߰��Ǵ� ���� �������̽��� �ƴ�.
	// TODO: ������ �Ϸ�Ǿ��� �� GUI���� ȣ���Ͽ� �����߰�
	// ex) GUI���� ShoppingBasket s; �϶�
	// s.getAmount().entrySet();
	// for(each entry) {
	// 	SalesCondition.addSales(goodsName, amount);
	// }
	public static void addSales(String goodsName, int amount){
		long t = System.currentTimeMillis(); 
		SimpleDateFormat dayTime = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
		String time = dayTime.format(new Date(t));
		
	}
	
	public int getTotalSalesMoney() {
		return totalSalesMoney;
	}

	public void setTotalSalesMoney(int totalSalesMoney) {
		this.totalSalesMoney = totalSalesMoney;
	}
}
