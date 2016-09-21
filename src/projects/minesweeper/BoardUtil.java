package projects.minesweeper;

import java.util.ArrayList;
import java.util.List;

public final class BoardUtil {

  private BoardUtil() {}

  public static List<Field> neighbours(int _row, int _col, BoardPanel boardPanel) {
    List<Field> neighboursList = new ArrayList<Field>();

    int upRow = _row - 1;
    int bottomRow = _row + 1;
    int leftCol = _col - 1;
    int rightCol = _col + 1;
    if (upRow >= 0) {
      if (leftCol >= 0) {
        neighboursList.add(boardPanel.getField(upRow, leftCol));
      }

      neighboursList.add(boardPanel.getField(upRow, _col));

      if (rightCol < boardPanel.get_cols()) {
        neighboursList.add(boardPanel.getField(upRow, rightCol));
      }

    }

    if (bottomRow < boardPanel.get_rows()) {
      if (leftCol >= 0) {
        neighboursList.add(boardPanel.getField(bottomRow, leftCol));
      }

      neighboursList.add(boardPanel.getField(bottomRow, _col));

      if (rightCol < boardPanel.get_cols()) {
        neighboursList.add(boardPanel.getField(bottomRow, rightCol));
      }

    }

    if (leftCol >= 0) {
      neighboursList.add(boardPanel.getField(_row, leftCol));
    }

    if (rightCol < boardPanel.get_cols()) {
      neighboursList.add(boardPanel.getField(_row, rightCol));
    }

    return neighboursList;
  }

  public static void populateBoard(int rowExcl, int colExcl, BoardPanel boardPanel) {
    MinePosRandomGen minesGenerator = new MinePosRandomGen(boardPanel.get_rows(), boardPanel.get_cols(), boardPanel.get_minesCount());
    minesGenerator.generateRandom(rowExcl, colExcl, boardPanel);
    calculateFieldItems(boardPanel);
  }

  private static void calculateFieldItems(BoardPanel boardPanel) {
    for (int i = 0; i < boardPanel.get_rows(); i++) {
      for (int j = 0; j < boardPanel.get_cols(); j++) {
        if (!boardPanel.getField(i, j).isMine()) {
          Item newItem = new NumericItem(i, j, boardPanel);
          boardPanel.getField(i, j).setItem(newItem);
        }
      }
    }

  }

}
