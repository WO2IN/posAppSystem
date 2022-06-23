package posApp;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class POS_pos extends JPanel implements ActionListener{
	ItemDAO item = ItemDAO.getInstance();

	private DefaultComboBoxModel product_list = new DefaultComboBoxModel();
	private JButton callBtn, addBtn ,payBtn ,cancelBtn;
	private JLabel productJL, stockJL, total_priceJL;
	private JTextField total_priceTF, stock_TF;
	private JTable viewTable;
	private JScrollPane jscroll;
	private DefaultTableModel view;
	private JComboBox<String> productBox;

	private int stock_number,unit_price, total_price;
	private static int count = 0;

	public POS_pos() throws SQLException {
		setLayout(null);

		view = new DefaultTableModel();
		view.addColumn("상품명");
		view.addColumn("구매수량");
		view.addColumn("구매가격");
		view.addColumn("누적총액");

		// 1
		callBtn = new JButton("제품 불러오기");
		callBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				productBox.removeAllItems();
				try {
					product_list.addAll((item.getItem()));
				} catch (SQLException e1) {
					System.out.println("제품 불러오기 오류");
				}
			}
		});
		callBtn.setBounds(20, 20, 140, 40);

		// 2
		productJL = new JLabel("상품");
		productJL.setBounds(20, 90, 100, 30);

		// 3
		productBox = new JComboBox<String>(product_list);
		productBox.setBounds(70, 90, 200, 30);

		// 4
		stockJL = new JLabel("수량");
		stockJL.setBounds(20, 140, 100, 30);

		// 5
		stock_TF = new JTextField();
		stock_TF.setBounds(70, 140, 200, 30);

		// 6
		total_priceJL = new JLabel("총가격");
		total_priceJL.setBounds(20, 250, 100, 40);

		// 7 
		total_priceTF = new JTextField();
		total_priceTF.setBounds(70, 250, 200, 40);
		total_priceTF.setEnabled(false);

		// 8
		addBtn = new JButton("추가");
		addBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (stock_TF.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "수량을 입력하세요.", "경고!", JOptionPane.WARNING_MESSAGE);
				}else {
					stock_number = Integer.parseInt(stock_TF.getText());
					unit_price = Integer.parseInt(item.getprice((String) productBox.getSelectedItem()));
					total_price += stock_number * unit_price;
					total_priceTF.setText(String.valueOf(total_price));
					
					Vector<String> in = new Vector<String>();
					in.add((String) productBox.getSelectedItem());
					in.add(String.valueOf(stock_number));
					in.add(String.valueOf(unit_price));
					in.add(String.valueOf(total_price));
					view.addRow(in);
					count++;
				}
			}
		});
		addBtn.setBounds(170, 190, 100, 40);

		// 9 
		payBtn = new JButton("결제");
		payBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int res = JOptionPane.showConfirmDialog(null, "결제하시겠습니까?");
				String cash = null;

				// 결제 수락
				if (res == 0) {
					cash = JOptionPane.showInputDialog(null, "총 금액은 " + total_price + "입니다.");
					
					// 결제 취소
					if (cash == null){
						JOptionPane.showMessageDialog(null, "결제를 취소했습니다.");
					}
					
					// 상품 가격보다 지불한 금액이 적을 경우  
					else if (total_price > Integer.parseInt(cash)) {
						JOptionPane.showMessageDialog(null, "지불하신 금액이 부족합니다.");
					}
					
					// 결제 성공
					else if (cash != null) { 
						try {
							stockUpdate();
							clean();
						} catch (SQLException e1) {
							System.out.println("DB 적용 오류");
						}
						JOptionPane.showMessageDialog(null, "지불하신 금액은 " + cash + "원 이고 상품의 합계는 " + total_price + " 이며, 거스름돈은 " + String.valueOf(Integer.parseInt(cash) - total_price) + "원 입니다.");
					} 
				}
			}
		});
		payBtn.setBounds(300, 250, 100, 40);

		// A
		cancelBtn = new JButton("취소");
		cancelBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int res = JOptionPane.showConfirmDialog(null, "주문을 취소하시겠습니까?");

				// 결제 취소 수락
				if (res == 0) {
					clean();  
				}
			}
		});
		cancelBtn.setBounds(410, 250, 100, 40);

		// B
		viewTable = new JTable(view);
		jscroll = new JScrollPane(viewTable);
		jscroll.setBounds(300, 20, 210, 210);

		add(total_priceTF);
		add(jscroll);
		add(cancelBtn);
		add(payBtn);
		add(total_priceJL);
		add(addBtn);
		add(stock_TF);
		add(stockJL);
		add(productBox);
		add(productJL);
		add(callBtn);
	}

	public void clean() {
		// 테이블 값 삭제
		for (int i = 0; i < count; i++) {
			view.removeRow(0);
		}
		
		// 총 가격 삭제
		total_price = 0;
		total_priceTF.setText(null);

		// 수량 삭제
		stock_TF.setText(null);
		count = 0;
		
	}

	public void stockUpdate() throws SQLException {
		for (int i = 0; i < count; i++) {
			item.updateStock(item.getStock((String)view.getValueAt(i, 0)), (String)view.getValueAt(i, 1), (String)view.getValueAt(i, 0));
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {

	}
}
