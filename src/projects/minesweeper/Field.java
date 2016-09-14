package projects.minesweeper;

import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URL;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public final class Field implements Flaggable{

	private final JPanel _initialPanel;
	
	private Item _item;
	
	private BoardPanel _boardPanel;
	
	private int _row;
	
	private int _col;
	
	private boolean _isOpened = false;
	
	private boolean _isFlagged;

	public Field(int row, int col, BoardPanel boardPanel) {
		_initialPanel = new JPanel();
		_initialPanel.setBorder(BorderFactory.createRaisedBevelBorder());
		_initialPanel.setPreferredSize(new Dimension(40, 40));
		_initialPanel.addMouseListener(new ButtonPressedListener());
		_initialPanel.addMouseListener(new MouseRightClickListener());
		_row = row;
		_col = col;
		_boardPanel = boardPanel;
	}

	

	



	public void setItem(Item _item) {
	  _item.setPanel(_initialPanel);
	  this._item = _item;
	}



	public JPanel asComponent() {
		return _initialPanel;
	}
	
	private class ButtonPressedListener extends MouseAdapter {

		@Override
		public void mousePressed (MouseEvent e) {
		  if(SwingUtilities.isLeftMouseButton(e)) {
			if(_boardPanel.isFirstClick()) {
				MineSweeperModel model = new MineSweeperModel(_row, _col, _boardPanel);
				_boardPanel.populateGridItems(model);
			} 
				
			if (!isFlagged()) {
			  _item.open();
			}
			 
		  }			
		}
		
	}
	
	public void open () {
		_isOpened = true;
	}
	
	public boolean isOpened () {
		return _isOpened;
	}
	
	@Override
    public void putFlag(boolean flagged) {
      _isFlagged  = flagged;
      if (flagged) {
          _boardPanel.markMine();
      } else {
          _boardPanel.unMarkMine();
      }
      
    }
    
    @Override
    public boolean isFlagged() {
      return _isFlagged;
    }
	
	private class MouseRightClickListener extends MouseAdapter {

		@Override
		public void mouseReleased(MouseEvent e) {
			if(SwingUtilities.isRightMouseButton(e)) {
			    
				if(isFlagged()){
					_initialPanel.removeAll();			
				} else {
					URL imageURL = getClass().getClassLoader().getResource("projects/minesweeper/flag.png");
					_initialPanel.add(new JLabel(new ImageIcon(imageURL)));
				}
				
				putFlag(!isFlagged());
				_initialPanel.revalidate();
				_initialPanel.repaint();
				
			}
			
		}

		
		
	}


}
