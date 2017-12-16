package GUI;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import DAO.Category;
import DAO.Goods;

import javax.swing.JTextField;
import javax.swing.ListSelectionModel;

public class ShoppingBasket {

	private JFrame frame;
	private JTextField totalPrice;
	private JTextField receivePrice;
	
	private static JTable table;
	private static Category[] categoryList;
	private static String[] ctgdata = {};
	private static DefaultListModel<String> dlm = null;
	private static JList<String> ctgList = new JList<String>();
	private static Goods[] goodsList;
	private static String[][] goods = {};
	private static String header[] = {"상품명", "가격", "재고수량", "할인율"};
	private static DefaultTableModel dtm =  new DefaultTableModel(goods, header);

	/**
	 * Create the application.
	 */
	public ShoppingBasket() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setVisible(true);
		frame.setBounds(100, 100, 819, 592);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		updateCategory();
		ctgList.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				updateGoods(ctgList.getSelectedValue());
			}
		});
		ctgList.setBounds(12, 51, 148, 492);
		frame.getContentPane().add(ctgList);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(172, 51, 271, 492);
		frame.getContentPane().add(scrollPane);
		table = new JTable();
		table.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		
		table.setModel(dtm);
		scrollPane.setViewportView(table);
		JTableHeader head = table.getTableHeader();
		head.setBackground(Color.yellow);
		
		table.setBounds(172, 48, 271, 492);
		
		JList basket = new JList();
		basket.setBounds(455, 48, 336, 249);
		frame.getContentPane().add(basket);
		
		JButton addGood = new JButton("\uC0C1\uD488\uCD94\uAC00");
		addGood.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		addGood.setBounds(506, 317, 97, 23);
		frame.getContentPane().add(addGood);
		
		JButton deleteGood = new JButton("\uC0C1\uD488\uC0AD\uC81C");
		deleteGood.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//System.out.println(goodsList.getSelectedIndex());
			}
		});
		deleteGood.setBounds(648, 317, 97, 23);
		frame.getContentPane().add(deleteGood);
		
		JLabel label = new JLabel("\uCD1D\uAE08\uC561 :");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBounds(455, 353, 76, 15);
		frame.getContentPane().add(label);
		
		totalPrice = new JTextField();
		totalPrice.setBounds(537, 350, 116, 21);
		frame.getContentPane().add(totalPrice);
		totalPrice.setColumns(10);
		
		JLabel label_1 = new JLabel("\uBC1B\uC740\uAE08\uC561 :");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setBounds(455, 378, 76, 15);
		frame.getContentPane().add(label_1);
		
		receivePrice = new JTextField();
		receivePrice.setColumns(10);
		receivePrice.setBounds(537, 375, 116, 21);
		frame.getContentPane().add(receivePrice);
		
		JButton PayforMoney = new JButton("\uD604\uAE08\uACB0\uC81C");
		PayforMoney.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				new payForMoney();
			}
		});
		PayforMoney.setBounds(506, 406, 97, 23);
		frame.getContentPane().add(PayforMoney);
		
		JButton PayForCard = new JButton("\uCE74\uB4DC\uACB0\uC81C");
		PayForCard.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				JOptionPane.showMessageDialog(null, "카드결제가 완료되었습니다.");
				frame.setVisible(false);
				new Home();
			}
		});
		PayForCard.setBounds(648, 406, 97, 23);
		frame.getContentPane().add(PayForCard);
		
		JButton ok = new JButton("\uD655\uC778");
		ok.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Home();
				frame.setVisible(false);
			}
		});
		ok.setBounds(578, 449, 97, 23);
		frame.getContentPane().add(ok);
	}
	
	public static void updateCategory(){
		categoryList = Category.getCategoryList();
		ctgdata = new String[categoryList.length];
		for(int i=0; i<categoryList.length; i++){
			ctgdata[i] = categoryList[i].getCategoryName();
		}
		dlm = new DefaultListModel<String>();
		for(String s:ctgdata){
			dlm.addElement(s);
		}
		ctgList.setModel(dlm);
		ctgList.updateUI();
	}

	public static void updateGoods(String ctgName){
		goods = new String[40][4];
		goodsList = Goods.getGoodsList(ctgName);
		for(int j=0; j<goodsList.length; j++){
			goods[j][0] = goodsList[j].getGoodsName();
			goods[j][1] = Integer.toString(goodsList[j].getPrice());
			goods[j][2] = Integer.toString(goodsList[j].getStockAmount());
			goods[j][3] = Float.toString(goodsList[j].getDiscount());
		}
		dtm = new DefaultTableModel(goods, header);
		table.setModel(dtm);
		table.updateUI();
	}
}
