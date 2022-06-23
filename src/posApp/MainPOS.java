package posApp;

import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;

public class MainPOS extends JFrame {
		public POS_pos pos = null;
		public POS_StockManagerment stockManagerment = null;
	
	public static void main(String[] args) throws SQLException {
		MainPOS mainPOS = new MainPOS();
		mainPOS.setTitle("POS 시스템");
		
		mainPOS.pos = new POS_pos();
		mainPOS.stockManagerment = new POS_StockManagerment();
		
		JTabbedPane jtap = new JTabbedPane();
		jtap.add("POS", mainPOS.pos);
		jtap.add("재고관리", mainPOS.stockManagerment);
		
		mainPOS.add(jtap);
		mainPOS.setSize(550, 400);
		mainPOS.setVisible(true); 
	}
}
