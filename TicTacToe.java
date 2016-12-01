import java.util.Scanner; 

public class TicTacToe
{
	/**
	 * This method initializes the board and returns that 2D array
	 * @return 2D array filled with "spots" on the tic tac toe board
	 */ 
	 public static int[][] initializeBoard()
	 {
        int[][] grid = new int[3][3];
        int counter = 1;
        for(int[] row: grid)
        {
            for(int n = 0; n < row.length; n++)
            {
                row[n] = counter;
                ++counter;
            }
        }
        return grid;
         
	 
	 }
	 
	 /**
	  * Prints the tic tac toe board in a nicely formatted grid
	  * @param grid The board to be printed
	  */
	  public static void printGrid(int[][] grid)
	  {
	  
	  }
	  
	  /**
	   * Places the player's symbol in the 2D array board
	   * @param grid The tic tac toe board
	   * @param symbol The symbol of the player that is up
	   * @return The updated tic tac toe board
	   */
	   public static int[][] placeSymbol(int[][] grid, String symbol)
	   {
	   
	   }
	   
	   /**
	    * Takes in the board and checks if there is a winner
	    * @param board The tic tac toe board being searched
	    * @return Boolean value true for win and false for no win
	    */
	    public static boolean checkWinner(int[][] board)
	    {
	    
	    }

}