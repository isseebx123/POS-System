package GUI;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import DAO.Category;
import DAO.Goods;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ManageGoods {

	private JFrame frame;
	private static JTable table;
	private static Category[] categoryList;
	private static String[] ctgdata = {};
	private static DefaultListModel<String> dlm = null;
	private static JList<String> ctgList = new JList<String>();
	private static Goods[] goodsList;
	private static String[][] goods = {};
	private static String header[] = { "��ǰ��", "����", "������", "������" };
	private static DefaultTableModel dtm = new DefaultTableModel(goods, header);

	/**
	 * Create the application.
	 */
	public ManageGoods() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setVisible(true);
		frame.setTitle("\uC0C1\uD488\uAD00\uB9AC");
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

		JButton ctg_Eroll = new JButton("<html>\uCE74\uD14C\uACE0\uB9AC<br>&nbsp&nbsp&nbsp&nbsp\uB4F1\uB85D</html>");
		ctg_Eroll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ErollCategory();
			}
		});
		ctg_Eroll.setBounds(455, 159, 97, 53);
		frame.getContentPane().add(ctg_Eroll);

		JButton ctg_Corret = new JButton("<html>\uCE74\uD14C\uACE0\uB9AC<br>&nbsp&nbsp&nbsp&nbsp\uC218\uC815</html>");
		ctg_Corret.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String selected = (String) ctgList.getSelectedValue();
				new CorrectCategory(selected);

			}
		});
		ctg_Corret.setBounds(577, 159, 97, 53);
		frame.getContentPane().add(ctg_Corret);

		JButton ctg_Delete = new JButton("<html>\uCE74\uD14C\uACE0\uB9AC<br>&nbsp&nbsp&nbsp&nbsp\uC0AD\uC81C</html>;");
		ctg_Delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				int index = ctgList.getSelectedIndex();
				if (index == -1) {
					JOptionPane.showMessageDialog(null, "ī�װ��� �������ּ���.");
				} else {
					String selected = (String) ctgList.getSelectedValue();
					boolean sucess = Category.removeCategory(selected);
					if (sucess == true) {
						updateCategory();
					}
				}

			}
		});
		ctg_Delete.setBounds(697, 159, 97, 53);
		frame.getContentPane().add(ctg_Delete);

		JButton good_Eroll = new JButton("\uC0C1\uD488\uB4F1\uB85D\r\n");
		good_Eroll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ErollGoods();
				// ��ǰ ����Ʈ ������Ʈ
			}
		});
		good_Eroll.setBounds(455, 250, 97, 53);
		frame.getContentPane().add(good_Eroll);

		JButton good_Correct = new JButton("\uC0C1\uD488\uC218\uC815");
		good_Correct.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int index = table.getSelectedRow();
				String value = null;
				if (index != -1) {
					value = (String) dtm.getValueAt(index, 0);
				}
				new CorrectGoods(value);

			}
		});
		good_Correct.setBounds(577, 250, 97, 53);
		frame.getContentPane().add(good_Correct);

		JButton good_Delete = new JButton("\uC0C1\uD488\uC0AD\uC81C");
		good_Delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int index = table.getSelectedRow();
				String value = null;
				if (index != -1) {
					value = (String) dtm.getValueAt(index, 0);
				}
				if (Goods.removeGoods(value)) {
					dtm.removeRow(index);
				}
			}
		});
		good_Delete.setBounds(697, 250, 97, 53);
		frame.getContentPane().add(good_Delete);

		JButton ok = new JButton("\uD655\uC778");
		ok.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Home();
				frame.setVisible(false);
			}
		});
		ok.setBounds(577, 342, 97, 37);
		frame.getContentPane().add(ok);
	}

	public static void updateCategory() {
		categoryList = Category.getCategoryList();
		ctgdata = new String[categoryList.length];
		for (int i = 0; i < categoryList.length; i++) {
			ctgdata[i] = categoryList[i].getCategoryName();
		}
		dlm = new DefaultListModel<String>();
		for (String s : ctgdata) {
			dlm.addElement(s);
		}
		ctgList.setModel(dlm);
		ctgList.updateUI();
	}

	public static void updateGoods(String ctgName) {
		goods = new String[40][4];
		goodsList = Goods.getGoodsList(ctgName);
		for (int j = 0; j < goodsList.length; j++) {
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
