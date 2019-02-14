public class QueenBoard{
  private int[][]board;

  public QueenBoard(int size){
		board = new int[size][size];
    for(int i = 0; i < size; i++){
      for (int j = 0; j< size; j++){
        board[i][j] = 0;
      }
    }
	}

  private boolean addQueen(int r, int c){
    if (board[r][c] == 0){
      for(int i = 0; i < board.length; i++){
        board[r][i] = board[r][i] + 1;
        board[i][c] = board[i][c] + 1;

      //vertical
      // for (int v1 = r - 1; v1 >= 0; v1--){ board[v1][c] = board[v1][c] + 1;}
      // for (int v2 = r + 1; v2 < board.length; v2++){ board[v2][c] = board[v2][c] + 1;}
      // //horizontal
      // for (int h1 = c - 1; h1 >= 0; h1-- ){board[r][h1] = board[r][h1] + 1;}
      // for (int h2 = c + 1; h2 < board.length; h2++){board[r][h2] = board[r][h2] + 1;}
      //diagonal
      if (r < board.length - i && c < board.length - i){
        board[r + i][c + i] = board[r + i][c + i] + 1;
      }
      if (r >= i && c < board.length - i){
        board[r - i][c + i] = board[r - i][c + i] + 1;
      }
    }
      board[r][c] = -1;
      return true;
    }
      return false;
    }

  private boolean removeQueen(int r, int c){
    if (board[r][c] == -1){
      for (int i = 0; i < board.length; i++){
        board[r][i] = board[r][i] - 1;
        board[i][c] = board[i][c] - 1;
      //vertical
      // for (int v1 = r - 1; v1 >= 0; v1--){board[v1][c] = board[v1][c] -1;}
      // for (int v2 = r + 1; v2 < board.length; v2++){board[v2][c] = board[v2][c] - 1;}
      // //horizontal
      // for (int h1 = c - 1; h1 >= 0; h1-- ){board[r][h1] = board[r][h1] - 1;}
      // for (int h2 = c + 1; h2 < board.length; h2++){board[r][h2] = board[r][h2] - 1;}
      //diagonal
    if (r < board.length - i && c < board.length - i){
        board[r + i][c + i] = board[r + i][c + i] - 1;
      }
    if (r >= i && c < board.length - i){
        board[r - i][c + i] = board[r - i][c + i] - 1;
      }
    }
      board[r][c] = 0;
      return true;
    }
      return false;
    }

  /**
  *@return false when the board is not solveable and leaves the board filled with zeros;

  *        true when the board is solveable, and leaves the board in a solved state

  *@throws IllegalStateException when the board starts with any non-zero value

  */
  public boolean solve(){
    // for (int i = 0; i < board.length; i++){
    //   for (int j = 0; j < board.length; j++){
    //     if(board[i][j]!= 0){
    //       throw new IllegalStateException();
    //     }
    //   }
    // }
    return solveR(0);
  }
  // boolean solveR(int col)
  //  if col is past end of board:
  //     return true
  //  for each row:
  //      if addQueen:
  //          if solveR(col+1):
  //              return true
  //          removeQueen
  //  return false

  public boolean solveR(int col){
    if (col >= board.length){
      return true;
    }
    for (int i = 0; i < board.length; i++){
      if (addQueen(i,col)){
        if (solveR(col + 1)){
          return true;
        }
        else{
        removeQueen(i,col);
      }
    }
  }
      return false;
}

  /**
  *@return the number of solutions found, and leaves the board filled with only 0's
  *@throws IllegalStateException when the board starts with any non-zero value
  */
  public int countSolutions(){
    int num = 0;
    for (int i = 0; i < board.length; i++){
      for (int j = 0; j < board.length; j++){
        if(board[i][j]!=0){
          throw new IllegalStateException();
        }
      }
    }
    return countR(0);
  }

  public int countR(int c){
    int nums = 0;
    if (c >= board.length){
      return 1;
    }
    for (int r = 0; r < board.length; r++){
      if (addQueen(r,c)){
        nums += countR(c + 1);
      }
      removeQueen(r,c);
    }
    return nums;
  }

  public String toString(){
    String result = "";
    for (int i = 0; i < board.length; i++){
      result += "\n";
      for (int j = 0; j < board.length; j++){
        if (board[i][j] == -1){
          result += "Q ";
        }
        else {
          result += "_ ";
        }
      }
    }
      return result;
    }

  public static void main (String[] args){
    QueenBoard board = new QueenBoard(14);
    System.out.println(board.countSolutions());
    System.out.println(board.solve());
    System.out.println(board);

  //  System.out.println(board2);
  //  System.out.println(board2c.countSolutions());
  //  System.out.print(board2.solve());
    }

  }
