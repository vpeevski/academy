package projects.minesweeper;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

public final class MineSweeper {

	public MineSweeper() {
	}

	public static void main(String[] args) {
		MineSweeperModel  model = new MineSweeperModel(8, 16, 35);
		new MineSweeper().buildFrame(model);
	}

	public JFrame buildFrame(MineSweeperModel model) {
		JPanel mainPanel = new JPanel(new BorderLayout());
		BoardPanel boardPanel = new BoardPanel(model);
		
		for (int i = 0; i < model.rows(); i++) {
			for(int j = 0 ; j < model.cols(); j++) {
				FieldButton fieldButton = new FieldButton(model.getItem(i, j), boardPanel);
				boardPanel.asPanel().add(fieldButton.asComponent());
			}
			
		}
		mainPanel.add(boardPanel.asPanel(), BorderLayout.CENTER);
		
		

		JFrame mainFrame = new JFrame("MineSweeper");
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.add(mainPanel);

		mainFrame.setSize(model.cols()*40, model.rows()*40);
		mainFrame.setLocationRelativeTo(null);
		mainFrame.setResizable(true);
		mainFrame.setVisible(true);
		return mainFrame;
	}

	
}
