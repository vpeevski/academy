package projects.minesweeper;

import java.util.List;

import javax.swing.JLabel;
import javax.swing.JPanel;

public interface Item {
	
	int col();
	
	int row();
	
	JLabel label();
	
	List<Item> neighbours();
	
	boolean isOpen ();
	
	void open ();
	
	void putFlag (boolean flagged);
	
	boolean isFlagged ();
	
	void select (JPanel panel);
	
	void unselect (JPanel panel);

}
