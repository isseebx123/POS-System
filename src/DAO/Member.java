package DAO;

public class Member {
	private String ID, PWD, Name, Age, PhoneNumber;
	
	public Member() {

	}
	
	public static boolean doLogin(final String ID, final String PWD){
		//JOptionPane.showMessageDialog(null, "���̵� �������� �ʽ��ϴ�.");
		//JOptionPane.showMessageDialog(null, "��й�ȣ�� ��ġ���� �ʽ��ϴ�.");
		//JOptionPane.showMessageDialog(null, "���̵�� ��й�ȣ�� �Է����ּ���.");
		return false;
	}
	
	public static boolean doMembership(final String ID, final String PWD, final String NAME, final String PHONENUMBER){
		//JOptionPane.showMessageDialog(null, "�ߺ��� ID�Դϴ�. �ٽ� �Է��� �ּ���.��");
		//JOptionPane.showMessageDialog(null, "�Էµ��� ���� ������ �ֽ��ϴ�. �ٽ� �Է��� �ּ���.��");
		return false;
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
