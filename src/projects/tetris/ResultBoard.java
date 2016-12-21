package projects.tetris;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JPanel;

public class ResultBoard extends AbstractBoard {

	private final int ROWS = 5;

	private final int COLUMNS = 6;

	private JPanel _nextElemPanel;

	private Element _currentNextElement;

	public ResultBoard() {
		_nextElemPanel = new JPanel(new GridLayout(ROWS, COLUMNS));
		_fieldsGrid = new Field[ROWS][COLUMNS];
		_innerBoardPanel = new JPanel();
		_innerBoardPanel.setBackground(Color.BLACK);
		BoxLayout boxLayout = new BoxLayout(_innerBoardPanel, BoxLayout.Y_AXIS);
		_innerBoardPanel.setLayout(boxLayout);
		_innerBoardPanel.setPreferredSize(new Dimension(150, 0));
		JPanel panel = new JPanel();
		panel.setBackground(Color.BLACK);
		panel.add(_nextElemPanel);
		_innerBoardPanel.add(panel);
		_innerBoardPanel.add(Box.createVerticalGlue());

		_innerBoardPanel.setBorder(BorderFactory.createLineBorder(
				Color.LIGHT_GRAY, 5));

		for (int i = 0; i < ROWS; i++) {
			for (int j = 0; j < COLUMNS; j++) {
				final Field field = new Field(i, j);
				addField(i, j, field);
			}
		}
	}

	private void addField(int row, int col, Field field) {
		_nextElemPanel.add(field.asComponent());
		_fieldsGrid[row][col] = field;
	}

	public void showNextElement(Element nextElement) {
		if (_currentNextElement != null) {
			_currentNextElement.hide();
		}
		_currentNextElement = nextElement;
		_currentNextElement.show();
	}

	@Override
	public Field[] createLeftZFields() {
		Field[] resultFields = new Field[4];
		resultFields[0] = getField(1, 4);
		resultFields[1] = getField(1, 3);
		resultFields[2] = getField(2, 3);
		resultFields[3] = getField(2, 2);

		return resultFields;
	}

	@Override
	public Field[] createBarFields() {
		Field[] resultFields = new Field[4];
		resultFields[0] = getField(2, 1);
		resultFields[1] = getField(2, 2);
		resultFields[2] = getField(2, 3);
		resultFields[3] = getField(2, 4);

		return resultFields;
	}

	@Override
	public Field[] createSemiCrossFields() {
		Field[] resultFields = new Field[4];
		resultFields[0] = getField(1, 2);
		resultFields[1] = getField(2, 2);
		resultFields[2] = getField(3, 2);
		resultFields[3] = getField(2, 3);
		return resultFields;
	}

	@Override
	public Field[] createCubeFields() {
		Field[] resultFields = new Field[4];
		resultFields[0] = getField(1, 2);
		resultFields[1] = getField(1, 3);
		resultFields[2] = getField(2, 2);
		resultFields[3] = getField(2, 3);
		return resultFields;
	}

	@Override
	public Field[] createRightGFields() {
		Field[] resultFields = new Field[4];
		resultFields[0] = getField(1, 1);
		resultFields[1] = getField(1, 2);
		resultFields[2] = getField(1, 3);
		resultFields[3] = getField(2, 3);
		return resultFields;
	}

	@Override
	public Field[] createLeftGFields() {
		Field[] resultFields = new Field[4];
		resultFields[0] = getField(1, 2);
		resultFields[1] = getField(1, 3);
		resultFields[2] = getField(1, 4);
		resultFields[3] = getField(2, 2);
		return resultFields;
	}

	@Override
	public Field[] createRightZFields() {
		Field[] resultFields = new Field[4];
		resultFields[0] = getField(1, 2);
		resultFields[1] = getField(1, 3);
		resultFields[2] = getField(2, 3);
		resultFields[3] = getField(2, 4);
		return resultFields;
	}

}
