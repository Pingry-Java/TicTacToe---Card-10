import java.util.Scanner; 

public class TicTacToe
{	
	
	public static void main(String[] args)
	{
		int turns = 0; 
		int[][] grid = initializeBoard(); 
		System.out.println("Player 1, your symbol is 0. Player 2, your symbol is -1.");
		while (turns < 9 || checkWinner(grid) == false)
		{
			printGrid(grid); 
			if (turns % 2 == 0)
			{
				System.out.println("Player 1, what space would you like to put your symbol?");
				grid = placeSymbol(grid, "0");
			}
			else
			{
				System.out.println("Player 2, what space would you like to put your symbol?"); 
				grid = placeSymbol(grid, "-1"); 
			}
			
			if (checkWinner(grid))
			{
				if (turns % 2 == 0)
					System.out.println("Player 1, you win!!"); 
				else
					System.out.println("Player 2, you win!!"); 
			}
			turns++; 
		}
	}
	
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
		for (int row = 0; row < grid.length; row++)
		{
			for (int col = 0; col < grid[row].length; col++)
				System.out.print(" –––––––");
			System.out.println();
			System.out.print("|");
			for (int col = 0; col < grid[row].length; col++)
				System.out.print(grid[row][col] + "\t |");
			System.out.println();
		}
		for (int col = 0; col < grid[0].length; col++)
			System.out.print(" –––––––");
		System.out.println();
	}
	  
	  /**
	   * Places the player's symbol in the 2D array board
	   * @param grid The tic tac toe board
	   * @param symbol The symbol of the player that is up
	   * @return The updated tic tac toe board
	   */
	public static int[][] placeSymbol(int[][] grid, String symbol)
	{
        Scanner keyboard = new Scanner(System.in);
        String userinput = keyboard.nextLine();
        //This is the location
        int point = Integer.parseInt(userinput);
        int userSymbol = Integer.parseInt(symbol);
        
        for(int[] row : grid)
        {
            for(int n = 0; n < row.length; n++)
            {
                if (point == n)
                    row[n] = userSymbol;
            }
        }
        return grid;
	   
	}
	   
	
	/**
	* Takes in the board and checks if there is a winner
	* @param board The tic tac toe board being searched
	* @return Boolean value true for win and false for no win
	*/

	public static boolean checkWinner(int[][] board)
	{
		if (checkDiag(board) == true || checkVert(board) == true || 
		checkRevDiag(board) == true || checkDiag(board) == true)
			return true;
		return false;
	}
	
	/**
	
	*/
	public static boolean checkDiag(int[][] board)
	{
		int index = 0;
		while (index < board.length)
		{
			if (board[index][index] != board[index+1][index+1])
				return false;
			index += 1;
		}
		return true;
	}
	
	/**
	
	*/
	public static boolean checkRevDiag(int[][] board)
	{
		int index = 0;
		int index2 = board.length - 1;
		while (index < board.length-1)
		{
			if (board[index][index2] != board[index+1][index2-1])
				return false;
			index += 1;
			index2 -= 1;
		}
		return true;
	}

	/**
	* This method checks each row to see if there is a winner in any of the columns
	* @param board The game board
	* @return Return if there is an entire column matching, indicating a winner
	*/
	public static boolean checkVert(int[][] board)
	{
		int col = 0;
		while (col < board.length)
		{
			if (checkOneVert(board, col))
				return true;
			col += 1;
		}
		return false;
	}

	/**
	* This method checks if a specific column matches
	* @param board The current game board
	* @param col The current column being checked
	* @return Return if the column matches
	*/
	public static boolean checkOneVert(int[][] board, int col)
	{
		int row = 0;
		while (row < (board.length - 1))
		{
			if (board[col][row] != board[col][row + 1])
				return false;
			row += 1;
		}
		return true;
	}

	/**
	
	*/
	public static boolean checkHoriz(int[][] board)

	{
		for (int row = 0; row < board.length; row++)
		{
			for (int col = 0; col < board[row].length; col++)
			{
				if ((board[row][col] == board[row][col + 1]) && (board[row][col] == board[row][col + 2]))
					return true;
				else 
					return false;
			}
		}
		return false; 
	}
}