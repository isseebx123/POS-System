package DAO;

public class ShoppingBasket {
	private int TotalPrice, Amount, ReceiveMoney, Change; // Change = �Ž�����
	// TODO: Amount�� ��ǰ�� ������ �Ǿ�� �Ѵ�. key-value�� ����? 
	
	public ShoppingBasket(){
		
	}

	public boolean addGoods(final String GOODS_NAME){
		
		return false;
	}
	
	public boolean removeGoods(final String GOODS_NAME){
		
		return false;
	}
	
	public int getTotalPrice() {
		return TotalPrice;
	}

	public void setTotalPrice(int totalPrice) {
		TotalPrice = totalPrice;
	}

	public int getAmount() {
		return Amount;
	}

	public void setAmount(int amount) {
		Amount = amount;
	}

	public int getReceiveMoney() {
		return ReceiveMoney;
	}

	public void setReceiveMoney(int receiveMoney) {
		ReceiveMoney = receiveMoney;
	}

	public int getChange() {
		return Change;
	}

	public void setChange(int change) {
		Change = change;
	}
}
