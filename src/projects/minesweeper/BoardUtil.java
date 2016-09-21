package projects.minesweeper;

import java.util.ArrayList;
import java.util.List;

public final class BoardUtil {

  private BoardUtil() {}

  public static List<Item> neighbours(int _row, int _col, BoardPanel boardPanel) {
    List<Item> neighboursList = new ArrayList<Item>();

    int upRow = _row - 1;
    int bottomRow = _row + 1;
    int leftCol = _col - 1;
    int rightCol = _col + 1;
    if (upRow >= 0) {
      if (leftCol >= 0) {
        neighboursList.add(boardPanel.getField(upRow, leftCol).getItem());
      }

      neighboursList.add(boardPanel.getField(upRow, _col).getItem());

      if (rightCol < boardPanel.get_cols()) {
        neighboursList.add(boardPanel.getField(upRow, rightCol).getItem());
      }

    }

    if (bottomRow < boardPanel.get_rows()) {
      if (leftCol >= 0) {
        neighboursList.add(boardPanel.getField(bottomRow, leftCol).getItem());
      }

      neighboursList.add(boardPanel.getField(bottomRow, _col).getItem());

      if (rightCol < boardPanel.get_cols()) {
        neighboursList.add(boardPanel.getField(bottomRow, rightCol).getItem());
      }

    }

    if (leftCol >= 0) {
      neighboursList.add(boardPanel.getField(_row, leftCol).getItem());
    }

    if (rightCol < boardPanel.get_cols()) {
      neighboursList.add(boardPanel.getField(_row, rightCol).getItem());
    }

    return neighboursList;
  }

  public static void populateBoard(int rowExcl, int colExcl, BoardPanel boardPanel) {
    MinePosRandomGen minesGenerator = new MinePosRandomGen(boardPanel.get_rows(), boardPanel.get_cols(), boardPanel.get_minesCount());
    Mine[] mines = minesGenerator.generateRandom(rowExcl, colExcl, boardPanel);
    putMinesOnBoard(mines, boardPanel);
    calculateFieldItems(boardPanel);
  }

  private static void calculateFieldItems(BoardPanel boardPanel) {
    for (int i = 0; i < boardPanel.get_rows(); i++) {
      for (int j = 0; j < boardPanel.get_cols(); j++) {
        if (boardPanel.getField(i, j).getItem() == null) {
          Item newItem = new NumericItem(i, j, boardPanel);
          boardPanel.getField(i, j).setItem(newItem);
        }
      }
    }

  }

  private static void putMinesOnBoard(Mine[] mines, BoardPanel boardPanel) {
    for (int i = 0; i < mines.length; i++) {
      Mine currentMine = mines[i];
      boardPanel.getField(currentMine.row(), currentMine.col()).setItem(currentMine);
    }
  }

}
