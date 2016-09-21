package projects.minesweeper;

import java.util.ArrayList;
import java.util.List;

public final class BoardUtil {
  
  private BoardUtil () {}
  
  
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
      
      if(leftCol >= 0) {
          neighboursList.add(boardPanel.getField(_row, leftCol).getItem());
      }
      
      if(rightCol < boardPanel.get_cols()) {
          neighboursList.add(boardPanel.getField(_row, rightCol).getItem());
      }
      
      return neighboursList;
  }

}
