package projects.seachess;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public final class FieldPanel {

	private final JPanel _panel;

	private boolean isMarked = false; // needed to avoid multiple marks on single field

	private int row;

	private int column;

	public FieldPanel(int row, int column) {
		_panel = new JPanel();
		_panel.setPreferredSize(new Dimension(60, 60));
		_panel.setBorder(BorderFactory.createLineBorder(Color.black));
		_panel.addMouseListener(new MarkListener());
		this.row = row;
		this.column = column;
	}

	private void mark(Player player) {
		_panel.add(new JLabel(player.getImageIcon()), BorderLayout.CENTER);
		_panel.repaint();
		_panel.revalidate();
	}

	public JPanel asPanel() {
		return _panel;
	}

	private class MarkListener extends MouseAdapter {
		@Override
		public void mouseClicked(MouseEvent e) {
			super.mouseClicked(e);
			if (!isMarked && !Configuration.getConfiguration().gameOver) {
				Player player = Configuration.getConfiguration()._playerInTurn;
				mark(player);
				Configuration.getConfiguration().switchPlayers(row, column);
			} else if (isMarked) {
				JOptionPane.showMessageDialog(null, "The field is marked !");
			} else if (Configuration.getConfiguration().gameOver) {
				JOptionPane.showMessageDialog(null, "Game Over: the winner is " + Configuration.getConfiguration()._playerInTurn.getName());
			}

			isMarked = true;
		}
	}

}
