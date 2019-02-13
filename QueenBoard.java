public class QueenBoard{
  private int[][]board;

  public QueenBoard(int size){
		board = new int[size][size];
	}

  private boolean addQueen(int r, int c){
    if (board[r][c] == 0){
      board[r][c] = -1;
      //vertical
      for (int v1 = r - 1; v1 >= 0; v1--){
        board[v1][c] = board[v1][c] + 1;
      }
      for (int v2 = r + 1; v2 < board.length; v2++){
        board[v2][c] = board[v2][c] + 1;
      }
      //horizontal
      for (int h1 = c - 1; h1 >= 0; h1-- ){
        board[r][h1] = board[r][h1] + 1;
      }
      for (int h2 = c + 1; h2 < board.length; h2++){
        board[r][h2] = board[r][h2] + 1;
      }
      //diagonal
      for (int d1 = 1; r < board.length - d1 && c < board.length - d1; d1++){
        board[r + 1][c + 1] = board[r + 1][c + 1] + 1;
      }
      for (int d2 = 1; r >= d2 && c < board.length - d2; d2++){
        board[r - d2][c + d2] = board[r - d2][c + d2] + 1;
      }
      return true;
    }
      return false;
    }

  private boolean removeQueen(int r, int c){
    if (board[r][c] == -1){
      board[r][c] = 0;
      //vertical
      for (int v1 = r - 1; v1 >= 0; v1--){
        board[v1][c] = board[v1][c] -1;
      }
      for (int v2 = r + 1; v2 < board.length; v2++){
        board[v2][c] = board[v2][c] - 1;
      }
      //horizontal
      for (int h1 = c - 1; h1 >= 0; h1-- ){
        board[r][h1] = board[r][h1] - 1;
      }
      for (int h2 = c + 1; h2 < board.length; h2++){
        board[r][h2] = board[r][h2] - 1;
      }
      //diagonal
      for (int d1 = 1; r < board.length - d1 && c < board.length - d1; d1++){
        board[r + 1][c + 1] = board[r + 1][c + 1] - 1;
      }
      for (int d2 = 1; r >= d2 && c < board.length - d2; d2++){
        board[r - d2][c + d2] = board[r - d2][c + d2] - 1;
      }
      return false;
    }
      return true;
    }

  public String toString(){
    String result = "";
    for (int i = 0; i < board.length; i++){
      for (int j = 0; j < board.length; j++){
        if (board[i][j] == -1){
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
    for (int i = 0; i < board.length; i++){
      for (int j = 0; j < board.length; j++){
        if(board[i][j]!= 0){
          throw new IllegalStateException();
        }
      }
    }
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
        removeQueen(i,col);
      }
    }
    return false;
  }


  // public boolean check(int[][] board, int row, int col){
  //   for(int i = 0; i < col; i++){
  //     if (board[row][i] == 1){
  //       return false;
  //     }
  //   }
  //   for(int a = row; j > 0; j  ){
  //     if (board[row - j][col - j] == 1){
  //       return false;
  //     }
  //   }
  //   for(int k = 0; k < board.length; k++){
  //     if (board[row + k][col + k] == 1){
  //       return false;
  //     }
  //   }
  //   return true;
  // }
  //
  // public boolean helper(int[][] board, int col){
  //   if(col >= board.length){
  //     return true;
  //   }
  //   else{
  //     for(int i = 0; i < board.length; i++){
  //       if(check(board, i, col)){
  //         board[col][i] = 1;
  //       }
  //     }
  //     return helper(board, col - 1);
  //   }
  //   return true;
  // }

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

  public static void main (String[] args){
    // QueenBoard board1 = new QueenBoard(5);
    // QueenBoard board1c = new QueenBoard(5);
    // System.out.println(board1);
    // System.out.println(board1.solve());
    // System.out.println(board1);
    // System.out.println(board1c.countSolutions());
    // //System.out.print(board1.solve());
    QueenBoard board2 = new QueenBoard(8);
  //  QueenBoard board2c = new QueenBoard(8);
    System.out.println(board2.solve());
    System.out.println(board2);

  //  System.out.println("?"+ System.currentTimeMillis());
  //  System.out.println(board2);
  //  System.out.println(board2c.countSolutions());

  //  System.out.print(board2.solve());
  }

  }
