package projects.minesweeper;

import javax.swing.JLabel;

public interface Item {
	
	int col();
	
	int row();
	
	JLabel label();
	
	void open ();
	
	boolean isMine ();

}
