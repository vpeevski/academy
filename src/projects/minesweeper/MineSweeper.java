package projects.minesweeper;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public final class MineSweeper {
	
	private BoardPanel _boardPanel;
	
	private JFrame _mainFrame;

	public static void main(String[] args) {
		GameController.instance().startNewGame(8, 8, 10);
	}

	public JFrame buildFrame(int rows, int cols, int minesCount) {
		JPanel mainPanel = new JPanel(new BorderLayout());
		_boardPanel = new BoardPanel(rows, cols, minesCount);
		
		for (int i = 0; i < rows; i++) {
			for(int j = 0 ; j < cols; j++) {
				Field fieldButton = new Field(i, j, _boardPanel);
				_boardPanel.addField(i, j, fieldButton);
			}
			
		}
		
		JPanel topPanel = new JPanel(new FlowLayout());
		final JLabel minesLeftCount = new JLabel(_boardPanel.getMinesLeft() + "");
		final JLabel minesLeftText = new JLabel("Mines left : ");
		minesLeftText.setHorizontalAlignment(SwingConstants.CENTER);
		minesLeftText.setForeground(Color.RED);
		minesLeftCount.setHorizontalAlignment(SwingConstants.CENTER);
		minesLeftCount.setForeground(Color.RED);
		
		topPanel.add(minesLeftText);
		topPanel.add(minesLeftCount);
		mainPanel.add(topPanel, BorderLayout.NORTH);
		_boardPanel.addMineMarkListener(new MineMarkListener() {
			
			@Override
			public void mineMarkeChange() {
				minesLeftCount.setText(_boardPanel.getMinesLeft() + "");
				
			}
		});
		
		mainPanel.add(_boardPanel.asPanel(), BorderLayout.CENTER);
		
		

		_mainFrame = new JFrame("MineSweeper");
		_mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		_mainFrame.add(mainPanel);

		_mainFrame.setSize(cols*40, rows*40);
		_mainFrame.setLocationRelativeTo(null);
		_mainFrame.setResizable(false);
		_mainFrame.setVisible(true);
		return _mainFrame;
	}
	
	public void closeFrame() {
		_mainFrame.setVisible(false);
		_mainFrame = null;
	}

	
}
