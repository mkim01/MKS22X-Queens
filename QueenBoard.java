public class QueenBoard{
  private int[][]board;

  public QueenBoard(int size){
		board = new int[size][size];
	}

  private boolean addQueen(int r, int c){
    if (board[r][c] == 0){
      board[r][c] = 1;
      return true;
    }
      return false;
    }

  private boolean removeQueen(int r, int c){
    if (board[r][c] == 1){
      board[r][c] = 0;
      return true;
    }
    return false;
    }

  /**
  *@return The output string formatted as follows:
  *All numbers that represent queens are replaced with 'Q'
  *all others are displayed as underscores '_'
  *There are spaces between each symbol:
  *"""_ _ Q _
  *Q _ _ _

  *_ _ _ Q

  *_ Q _ _"""
  *(pythonic string notation for clarity,
  *excludes the character up to the *)
  */
  public String toString(){
    String result = "";
    for (int i = 0; i < board.length; i++){
      for (int j = 0; j < board.length; j++){
        if (board[i][j] == 1){
          result += "Q ";
        }
        else {
          result += "_ ";
        }
        if (j == board.length - 1){
          result += "\n";
        }
      }
    }
    return result;
  }

  /**
  *@return false when the board is not solveable and leaves the board filled with zeros;

  *        true when the board is solveable, and leaves the board in a solved state

  *@throws IllegalStateException when the board starts with any non-zero value

  */
  public boolean solve(){
    return true;
  }

  /**
  *@return the number of solutions found, and leaves the board filled with only 0's
  *@throws IllegalStateException when the board starts with any non-zero value
  */
  public int countSolutions(){
    return 0;
  }

  public static void main (String[] args){
    QueenBoard test = new QueenBoard(4);
    test.addQueen(2,2);
    System.out.println(test);
  }

  }
