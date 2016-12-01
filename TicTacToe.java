import java.util.Scanner; 

public class TicTacToe
{
	/**
	* This method initializes the board and returns that 2D array
	* @return 2D array filled with "spots" on the tic tac toe board
	*/ 
	public static int[][] initializeBoard()
	{
		int[][] board = new int[3][3];
		int counter = 1;
		for (int row = 0; row < 3; row++)
		{
			for (int col = 0; col < 3; col++)
			{
				board[row][col] = counter;
				counter++;
			}
		}
		return board;
	}
	 
	/**
	* Prints the tic tac toe board in a nicely formatted grid
	* @param grid The board to be printed
	*/
	
	public static void printBoard(int[][] grid)
	{
		for (int row = 0; row < grid.length; row++)
		{
			System.out.println("------------");
			for (int col = 0; col < grid[row].length; col++)
			{
				System.out.print("|" + grid[row][col]);
				if (grid[row][col] < 10)
					System.out.print(" ");
			}
			System.out.print("|");
			System.out.println();
		}
		System.out.println("------------");
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