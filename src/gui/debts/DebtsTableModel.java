package gui.debts;

import java.util.Vector;

import javax.swing.table.DefaultTableModel;

public final class DebtsTableModel extends DefaultTableModel {
	
	private static final String DEBT_ID = "Debt Id";
	private static final String DEBT_SUM = "Debt Sum";
	private static final String DEBT_DUE_DATE = "Due Date";
	private static final String DEBTOR_NAME= "Debtor Name";
	private static final String CREDITOR_NAME= "Creditor Name";
	
	public DebtsTableModel (Vector<Vector<String>> data) {
		super(data, columns());
	}
	
	private static Vector<String> columns () {
		Vector<String> columns = new Vector<String>();
		columns.add(DEBT_ID);
		columns.add(DEBT_SUM);
		columns.add(DEBT_DUE_DATE);
		columns.add(DEBTOR_NAME);
		columns.add(CREDITOR_NAME);
		return columns;
	}
	
	
	

}
