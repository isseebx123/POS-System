package DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import DB.DBConnection;

public class SalesCondition {
	private int totalSalesMoney;
	
	public SalesCondition(){
		
	}

	public static void daySalesCheck(){
		Connection c = null;
		Statement stmt = null;

		try {
			c = DBConnection.getConnection();
			stmt = c.createStatement();

			String query = String.format("select * from order");
			ResultSet rs = stmt.executeQuery(query);
			
			stmt.close();
			System.out.println("��ȸ�� �����߽��ϴ�.");
		} catch (Exception e) {
			System.out.println("��ȸ�� �����߽��ϴ�.");
			e.printStackTrace();
		}
	}

	public static void monthSalesCheck(){
		
	}
	
	
	public int getTotalSalesMoney() {
		return totalSalesMoney;
	}

	public void setTotalSalesMoney(int totalSalesMoney) {
		this.totalSalesMoney = totalSalesMoney;
	}
}
