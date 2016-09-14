package projects.minesweeper;

import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.net.URL;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public final class Field implements Flaggable, Selectable {

	private JPanel _currentPanel;
	
	private Item _item;
	
	private BoardPanel _boardPanel;
	
	private int _row;
	
	private int _col;
	
	private boolean _isOpened = false;
	
	private boolean _isFlagged;

	public Field(int row, int col, BoardPanel boardPanel) {
		_currentPanel = new JPanel();
		_currentPanel.setBorder(BorderFactory.createRaisedBevelBorder());
		_currentPanel.setPreferredSize(new Dimension(40, 40));
		_currentPanel.addMouseListener(new ButtonPressedListener());
		_currentPanel.addMouseListener(new MouseRightClickListener());
		_row = row;
		_col = col;
		_boardPanel = boardPanel;
	}

	

	



	public void setItem(Item _item) {
	  this._item = _item;
	}



	public JPanel asComponent() {
		return _currentPanel;
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
		_boardPanel.asPanel().remove(_row*_boardPanel.get_cols() + _col);
		_currentPanel = new JPanel ();
		_currentPanel.setBorder(BorderFactory.createEtchedBorder());
		//setBackGround(_currentPanel);
		_currentPanel.add(_item.label());
		_boardPanel.asPanel().add(_currentPanel, _row*_boardPanel.get_cols() + _col);
		
		
		_currentPanel.revalidate();
		_currentPanel.repaint();
		checkEndGame();
	}
	
	private void checkEndGame () {
		if (_boardPanel.getUnOpenedFieldsCount() == _boardPanel.get_minesCount()) {
			GameController.instance().endGame();
		}
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
    
    @Override
	public void select() {
		_currentPanel.setBorder(BorderFactory.createEtchedBorder());
	}
	
	@Override
    public void unselect() {
		_currentPanel.setBorder(BorderFactory.createRaisedBevelBorder());
    }
	
	public void addMouseListener (MouseListener mouseListener) {
		_currentPanel.addMouseListener(mouseListener);
	}
	
	private class MouseRightClickListener extends MouseAdapter {

		@Override
		public void mouseReleased(MouseEvent e) {
			if(SwingUtilities.isRightMouseButton(e)) {
			    
				if(isFlagged()){
					_currentPanel.removeAll();			
				} else {
					URL imageURL = getClass().getClassLoader().getResource("projects/minesweeper/flag.png");
					_currentPanel.add(new JLabel(new ImageIcon(imageURL)));
				}
				
				putFlag(!isFlagged());
				_currentPanel.revalidate();
				_currentPanel.repaint();
				
			}
			
		}

		
		
	}


}
