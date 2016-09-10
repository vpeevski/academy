package projects.minesweeper;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

public final class MineSweeper {
	
	private BoardPanel _boardPanel;

	public static void main(String[] args) {
		new MineSweeper().buildFrame(8, 8, 10);
	}

	public JFrame buildFrame(int rows, int cols, int minesCount) {
		JPanel mainPanel = new JPanel(new BorderLayout());
		_boardPanel = new BoardPanel(rows, cols, minesCount);
		
		for (int i = 0; i < rows; i++) {
			for(int j = 0 ; j < cols; j++) {
				FieldButton fieldButton = new FieldButton(i, j, _boardPanel);
				_boardPanel.addField(i, j, fieldButton);
			}
			
		}
		mainPanel.add(_boardPanel.asPanel(), BorderLayout.CENTER);
		
		

		JFrame mainFrame = new JFrame("MineSweeper");
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.add(mainPanel);

		mainFrame.setSize(cols*40, rows*40);
		mainFrame.setLocationRelativeTo(null);
		mainFrame.setResizable(false);
		mainFrame.setVisible(true);
		return mainFrame;
	}

	
}
