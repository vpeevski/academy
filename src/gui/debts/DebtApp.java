package gui.debts;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.io.IOException;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import debts.DebtReader;

public class DebtApp {

	public static void main(String[] args) {
		DebtReader reader = new DebtReader();
		try {
			Vector<Vector<String>> debts = reader.readDebts("test/resources/debts_test.txt");
			DefaultTableModel model = new DebtsTableModel(debts);
			JFrame frame =new JFrame("Debts");
			JTable table = new JTable(model);
			frame.add(new JScrollPane(table), BorderLayout.CENTER);
			frame.setVisible(true);
			frame.setSize(new Dimension(600, 800));
			
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
