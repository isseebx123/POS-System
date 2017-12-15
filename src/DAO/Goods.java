package DAO;

import java.sql.Connection;
import java.sql.Statement;

import DB.DBConnection;

public class Goods {
	private String GoodsName;
	private int Price, StockAmount;
	private float Discount;
	private Category Category;
	
	public Goods(String GoodsName, int Price, int StockAmount, float Discount, Category Category){
		this.GoodsName = GoodsName;
		this.Price = Price;
		this.StockAmount = StockAmount;
		this.Discount = Discount;
		this.Category = Category;
	}

	public boolean addGoods(final String goodsName, final int price, final int stockAmount, final float discount, final String categoryName){
		Connection c = null;
		Statement stmt = null;
		boolean result = false;

		try {
			c = DBConnection.getConnection();
			stmt = c.createStatement();

			String query = String.format("insert into goods values('%s', '%d', '%d', '%f', '%s')", goodsName, price, stockAmount, discount, categoryName);
			stmt.executeUpdate(query);

			System.out.println("상품추가에 성공했습니다.");
			result = true;
			stmt.close();
		} catch (Exception e) {
			System.out.println("상품추가에 실패했습니다.");
			e.printStackTrace();
		}

		return result;
	}
	
	public boolean modifyGoods(final String goodsName, final int price, final float discount, final int stockAmount){
		
		return false;
	}
	
	public boolean removeGoods(final String goodsName){
		
		return false;
	}
	
	public void checkGoodsList(){
		// TODO: return type -> Goods's List or Array
		
	}
	
	public String getGoodsName() {
		return GoodsName;
	}

	public void setGoodsName(String goodsName) {
		GoodsName = goodsName;
	}

	public int getPrice() {
		return Price;
	}

	public void setPrice(int price) {
		Price = price;
	}

	public int getStockAmount() {
		return StockAmount;
	}

	public void setStockAmount(int stockAmount) {
		StockAmount = stockAmount;
	}

	public float getDiscount() {
		return Discount;
	}

	public void setDiscount(float discount) {
		Discount = discount;
	}
	
	public Category getCategory() {
		return Category;
	}

	public void setCategory(Category category) {
		this.Category = category;
	}
}
