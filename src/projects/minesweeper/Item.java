package projects.minesweeper;

import javax.swing.JLabel;

public interface Item {
	
	JLabel label();
	
	void open ();
	
	boolean isMine ();

}
