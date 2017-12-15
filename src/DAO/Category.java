package DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import DB.DBConnection;

public class Category {
	private String CategoryName;

	public Category(String CategoryName) {
		this.CategoryName = CategoryName;
	}

	public static boolean addCategory(final String CATEGORY_NAME) {
		Connection c = null;
		Statement stmt = null;
		boolean result = false;

		// ���� �帧 E1
		if(CATEGORY_NAME.equals("")){
			return false;
		}
		
		try {
			c = DBConnection.getConnection();
			stmt = c.createStatement();

			String query = String.format("insert into category values('%s')", CATEGORY_NAME);
			stmt.executeUpdate(query);

			System.out.println("ī�װ� �߰��� �����߽��ϴ�.");
			result = true;
			stmt.close();
		} catch (Exception e) {
			System.out.println("ī�װ� �߰��� �����߽��ϴ�.");
			e.printStackTrace();
		}

		return result;
	}

	public static boolean removeCategory(final String CATEGORY_NAME) {
		Connection c = null;
		Statement stmt = null;
		boolean result = false;

		// ���� �帧 E1
		if(CATEGORY_NAME.equals("")){
			return false;
		}
		
		try {
			c = DBConnection.getConnection();
			stmt = c.createStatement();

			String query = String.format("delete from category where CategoryName='%s'", CATEGORY_NAME);
			stmt.executeUpdate(query);

			System.out.println("ī�װ� ������ �����߽��ϴ�.");
			result = true;
			stmt.close();
		} catch (Exception e) {
			System.out.println("ī�װ� ������ �����߽��ϴ�.");
			e.printStackTrace();
		}

		return result;
	}

	public static boolean modifyCategory(final String PREV_CATEGORY_NAME, final String CATEGORY_NAME) {
		Connection c = null;
		Statement stmt = null;
		boolean result = false;

		// ���� �帧 E1
		if(PREV_CATEGORY_NAME == null){
			return false;
		}
		
		try {
			c = DBConnection.getConnection();
			stmt = c.createStatement();

			String query = String.format("update category set categoryname = '%s' where categoryname = '%s'", CATEGORY_NAME, PREV_CATEGORY_NAME);
			stmt.executeUpdate(query);

			System.out.println("ī�װ� ������ �����߽��ϴ�.");
			result = true;
			stmt.close();
		} catch (Exception e) {
			System.out.println("ī�װ� ������ �����߽��ϴ�.");
			e.printStackTrace();
		}

		return result;
	}

	public static Category[] getCategoryList() {
		Connection c = null;
		Statement stmt = null;
		Category[] categoryList = null;
		
		try {
			c = DBConnection.getConnection();
			stmt = c.createStatement();

			String query = String.format("select * from category");

			List<Category> temp = new ArrayList<>();
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				temp.add(new Category(rs.getString("CategoryName")));
			}
			
			categoryList = temp.toArray(new Category[0]);
			System.out.println("ī�װ���ȸ�� �����߽��ϴ�.");
		} catch (SQLException e) {
			System.out.println("ī�װ���ȸ�� �����߽��ϴ�.");
			e.printStackTrace();
		}

		return categoryList;
	}

	public String getCategoryName() {
		return CategoryName;
	}

	public void setCategoryName(String categoryName) {
		CategoryName = categoryName;
	}
}
