package projects.minesweeper;

import java.awt.GridLayout;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class BoardPanel {
	
	private JPanel _innerBoardPanel;
	
	private MineSweeperModel _model;
	
	public BoardPanel(MineSweeperModel model) {
		_innerBoardPanel = new JPanel(new GridLayout(model.rows(), model.cols() ));
		_model = model;
	}
	
	public JPanel asPanel () {
		return _innerBoardPanel;
	}
	
	public void openItem (Item item) {
		if (item instanceof Mine) {
			simpleOpenField(item);
			JOptionPane.showMessageDialog(_innerBoardPanel, "GAME OVER !");
		} else if (item instanceof NumericItem) {
			simpleOpenField(item);
		} else {
			openField(item);
		}
		
	}
	
	private void simpleOpenField(Item item) {
		item.open();
		_innerBoardPanel.remove(item.row()*_model.cols() + item.col());
		JPanel panel = new JPanel ();
		panel.add(item.label());
		_innerBoardPanel.add(panel, item.row()*_model.cols() + item.col());
		_innerBoardPanel.revalidate();
		_innerBoardPanel.repaint();
		
	}

	private void openField (Item item) {
		if (! item.isOpen()) {
			simpleOpenField(item);
		
			List<Item> neighbours = item.neighbours();
			for (Item neighbour : neighbours) {
				if(!neighbour.isOpen() && neighbour instanceof EmptyItem) {
					openField(neighbour);
				} else if (!neighbour.isOpen() && neighbour instanceof NumericItem) {
					simpleOpenField(neighbour);
				}
			}
		}
	}

	

}
