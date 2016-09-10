package projects.minesweeper;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.SwingUtilities;

public final class FieldButton {

	private final JButton _button;
	
	private Item _item;
	
	private BoardPanel _boardPanel;
	
	private int _row;
	
	private int _col;
	
	private boolean hasFlag = false;
	
	private GameController _gameController;

	public FieldButton(int row, int col, BoardPanel boardPanel, GameController gameController) {
		_button = new JButton();
		_button.setPreferredSize(new Dimension(40, 40));
		_button.addActionListener(new ButtonPressedListener());
		_button.addMouseListener(new MouseRightClickListener());
		_row = row;
		_col = col;
		_boardPanel = boardPanel;
		_gameController = gameController;
	}

	

	public Item getItem() {
		return _item;
	}



	public void setItem(Item _item) {
		this._item = _item;
	}



	public JButton asComponent() {
		return _button;
	}
	
	private class ButtonPressedListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			if(_boardPanel.isFirstClick()) {
				MineSweeperModel model = new MineSweeperModel(_row, _col, _boardPanel, _gameController);
				_boardPanel.populateGridItems(model);
			} 
				
			_item.open();
			
			
			
			
		}
		
	}
	
	private class MouseRightClickListener extends MouseAdapter {

		@Override
		public void mouseReleased(MouseEvent e) {
			if(SwingUtilities.isRightMouseButton(e)) {
				if(hasFlag){
					_button.setIcon(null);
					hasFlag = false;
				} else {
					URL imageURL = getClass().getClassLoader().getResource("projects/minesweeper/flag.png");
					_button.setIcon(new ImageIcon(imageURL));
					hasFlag = true;
				}
				
			}
			
		}

		
		
	}


}
