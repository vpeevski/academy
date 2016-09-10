package projects.minesweeper;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComponent;

public final class FieldButton {

	private final JButton _button;

	private Item _item;
	
	private BoardPanel _boardPanel;

	

	public FieldButton(Item item, BoardPanel boardPanel) {
		_button = new JButton();
		_button.setPreferredSize(new Dimension(40, 40));
		_boardPanel = boardPanel;
		_button.addActionListener(new ButtonPressedListener());
		_item = item;
	}

	

	public JComponent asComponent() {
		return _button;
	}
	
	private class ButtonPressedListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			_boardPanel.openItem(_item);
			
		}
		
	}
	

}
