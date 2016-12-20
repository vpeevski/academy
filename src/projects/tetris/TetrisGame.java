package projects.tetris;

import java.awt.Color;

import javax.swing.JFrame;

public class TetrisGame {

	private JFrame mainFrame;

	public static void main(String[] args) {
		TetrisGame tetrisGame = new TetrisGame();
		tetrisGame.createAndShowGui();
	}

	public void createAndShowGui() {
		mainFrame = new JFrame("Tetris");
		TetrisBoard mainBoard = new TetrisBoard();

		mainFrame.add(mainBoard.asPanel());
		mainFrame.setSize(300, 600);
		mainFrame.setResizable(false);
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.setVisible(true);
		mainBoard.startTimer(1000);

	}

	public void closeFrame() {
		mainFrame.dispose();
	}
}
