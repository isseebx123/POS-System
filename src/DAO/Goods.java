package DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import DB.DBConnection;

public class Goods {
	private String GoodsName;
	private int Price, StockAmount;
	private float Discount;
	private Category Category;

	public Goods(String GoodsName, int Price, int StockAmount, float Discount, Category Category) {
		this.GoodsName = GoodsName;
		this.Price = Price;
		this.StockAmount = StockAmount;
		this.Discount = Discount;
		this.Category = Category;
	}

	public static boolean addGoods(final String goodsName, final String price, final String stockAmount, final String discount,
			final String categoryName) {
		Connection c = null;
		Statement stmt = null;
		boolean result = false;

		// ���� �帧 E1
		if(goodsName.equals("") || price.equals("") || stockAmount.equals("") || discount.equals("") || categoryName.equals("")){
			return false;
		}
		
		try {
			c = DBConnection.getConnection();
			stmt = c.createStatement();

			String query = String.format("insert into goods values('%s', '%s', '%s', '%s', '%s')", goodsName, price,
					stockAmount, discount, categoryName);
			stmt.executeUpdate(query);

			System.out.println("��ǰ �߰��� �����߽��ϴ�.");
			result = true;
			stmt.close();
		} catch (Exception e) {
			System.out.println("��ǰ �߰��� �����߽��ϴ�.");
			e.printStackTrace();
		}

		return result;
	}

	public static boolean modifyGoods(final String prev_goodsName, final String goodsName, final String price,
			final String stockAmount, final String discount, final String categoryName) {
		Connection c = null;
		Statement stmt = null;
		boolean result = false;

		// ���� �帧 E1
		if(prev_goodsName == null){
			return false;
		}
		// ���� �帧 E2
		if(goodsName.equals("") || price.equals("") || stockAmount.equals("") || discount.equals("") || categoryName.equals("")){
			return false;
		}
		
		try {
			c = DBConnection.getConnection();
			stmt = c.createStatement();

			String query = String.format(
					"update goods set goodsName = '%s', price = '%s', discount = '%s', stockAmount = '%s', categoryName = '%s' where goodsName = '%s'",
					goodsName, price, stockAmount, discount, categoryName, prev_goodsName);
			stmt.executeUpdate(query);

			System.out.println("��ǰ ������ �����߽��ϴ�.");
			result = true;
			stmt.close();
		} catch (Exception e) {
			System.out.println("��ǰ ������ �����߽��ϴ�.");
			e.printStackTrace();
		}

		return result;
	}

	public static boolean removeGoods(final String goodsName) {
		Connection c = null;
		Statement stmt = null;
		boolean result = false;

		// ���� �帧 E1
		if(goodsName == null){
			return false;
		}
		
		try {
			c = DBConnection.getConnection();
			stmt = c.createStatement();

			String query = String.format("delete from goods where goodsName='%s'", goodsName);
			stmt.executeUpdate(query);

			System.out.println("��ǰ ������ �����߽��ϴ�.");
			result = true;
			stmt.close();
		} catch (Exception e) {
			System.out.println("��ǰ ������ �����߽��ϴ�.");
			e.printStackTrace();
		}

		return result;
	}

	public static Goods[] getGoodsList(String categoryName) {
		Connection c = null;
		Statement stmt = null;
		Goods[] goodsList = null;

		try {
			c = DBConnection.getConnection();
			stmt = c.createStatement();

			String query = String.format("select * from goods where categoryName = '%s'", categoryName);

			List<Goods> temp = new ArrayList<>();
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				String gn = rs.getString("goodsName");
				int p = rs.getInt("price");
				int s = rs.getInt("stockamount");
				int d = rs.getInt("discount");
				String cn = rs.getString("categoryName");
				Category ct = new Category(cn);

				temp.add(new Goods(gn, p, s, d, ct));
			}

			goodsList = temp.toArray(new Goods[0]);
			System.out.println("��ǰ��ȸ�� �����߽��ϴ�.");
		} catch (SQLException e) {
			System.out.println("��ǰ��ȸ�� �����߽��ϴ�.");
			e.printStackTrace();
		}

		return goodsList;
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
