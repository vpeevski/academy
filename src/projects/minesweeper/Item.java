package projects.minesweeper;

import java.util.List;

import javax.swing.JLabel;

public interface Item {
	
	int col();
	
	int row();
	
	JLabel label();
	
	List<Item> neighbours();
	
	boolean isOpen ();
	
	void open ();
	
	boolean isMine ();

}
