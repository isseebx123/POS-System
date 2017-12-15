package DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import DB.DBConnection;

public class Member {
	private String ID, PWD, Name, Age, PhoneNumber;

	public Member() {

	}

	public boolean doLogin(final String ID, final String PWD) {
		// JOptionPane.showMessageDialog(null, "���̵� �������� �ʽ��ϴ�.");
		// JOptionPane.showMessageDialog(null, "��й�ȣ�� ��ġ���� �ʽ��ϴ�.");
		// JOptionPane.showMessageDialog(null, "���̵�� ��й�ȣ�� �Է����ּ���.");
		Connection c = null;
		Statement stmt = null;
		boolean result = false;
		try {
			c = DBConnection.getConnection();
			stmt = c.createStatement();

			String query = String.format("select * from member where ID='%s' and PWD='%s'", ID, PWD);

			ResultSet rs = stmt.executeQuery(query);
			if (!rs.next() || !rs.getString("ID").equals(ID)) {
				System.out.println("�α����� �ϴµ� �ش��ϴ� ȸ���� �����ϴ�.");
				result = false;
			}
			else {
				this.ID = ID;
				this.PWD = PWD;
				this.Name = rs.getString("NAME");
				this.Age = rs.getString("AGE");
				this.PhoneNumber = rs.getString("PHONENUMBER");
				result = true;
			}
			
		} catch (SQLException e) {
			System.out.println("�α��� ���ܹ߻�");
			e.printStackTrace();
		}

		return result;
	}

	public static boolean doMembership(final String ID, final String PWD, final String NAME, final String AGE,
			final String PHONENUMBER) {
		// JOptionPane.showMessageDialog(null, "�ߺ��� ID�Դϴ�. �ٽ� �Է��� �ּ���.��");
		// JOptionPane.showMessageDialog(null, "�Էµ��� ���� ������ �ֽ��ϴ�. �ٽ� �Է���
		// �ּ���.��");
		Connection c = null;
		Statement stmt = null;
		boolean result = false;

		try {
			c = DBConnection.getConnection();
			stmt = c.createStatement();
			result = false;
			
			String query = String.format("insert into Member values('%s','%s','%s','%d','%s')", ID, PWD, NAME, AGE,
					PHONENUMBER);
			stmt.executeUpdate(query);
			result = true;
			
			stmt.close();
		} catch (SQLException e) {
			/* �ߺ��� ID�� ��� */
			System.out.println("�ߺ��� ID�� ȸ�������� �Ϸ��� �մϴ�.");
		}

		return result;
	}

	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

	public String getPWD() {
		return PWD;
	}

	public void setPWD(String pWD) {
		PWD = pWD;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getAge() {
		return Age;
	}

	public void setAge(String age) {
		Age = age;
	}

	public String getPhoneNumber() {
		return PhoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		PhoneNumber = phoneNumber;
	}
}
