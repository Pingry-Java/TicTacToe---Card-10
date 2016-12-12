import java.util.Scanner; 

public class TicTacToe
{	
	
	public static void main(String[] args)
	{
		System.out.println("WELCOME TO INT ARRAY TIC TAC TOE");
		int turns = 0; 
		int[][] grid = initializeBoard(); 
		System.out.println("Player 1, your symbol is 0. Player 2, your symbol is -1.");
		while (turns < 9 &&  checkWinner(grid) == false)
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
				printGrid(grid); 
				if (turns % 2 == 0)
					System.out.println("Player 1, you win!!"); 
				else
					
					System.out.println("Player 2, you win!!"); 
				break; 
			}
			
			turns++; 	
		}
		
			if (turns == 9)
			{
				printGrid(grid); 
				System.out.println("No winner.");
			}
	}
	
	/**
	 * Checks if a spot has already been chosen using indices stored in an array
	
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
	   * Also checks if that spot has already been chosen
	   * @param grid The tic tac toe board
	   * @param symbol The symbol of the player that is up
	   * @return The updated tic tac toe board
	   */
	public static int[][] placeSymbol(int[][] grid, String symbol)
	{
       boolean alreadyChosen = true; 
       	Scanner keyboard = new Scanner(System.in);
        String userinput = keyboard.nextLine();
        //This is the location
        int point = Integer.parseInt(userinput);
        point--; 
        int userSymbol = Integer.parseInt(symbol);
        
        int column = point % 3;
        int row = point / 3; 
        
        //Check to make sure haven't already used that spot on the board
        while (grid[row][column] < 1)
        {
        	System.out.println("That spot has already been chosen. Please pick another: ");
        	userinput = keyboard.nextLine(); 
        	point = Integer.parseInt(userinput); 
        	point--; 
        	column = point % 3; 
        	row = point / 3;
        	
        }
        grid[row][column] = userSymbol;
        
        return grid;
	   
	}
	   
	
	/**
	* Takes in the board and checks if there is a winner
	* @param board The tic tac toe board being searched
	* @return Boolean value true for win and false for no win
	*/

	public static boolean checkWinner(int[][] board)
	{
		if (checkDiag(board) == true || checkVert(board) == true || checkRevDiag(board) == true || checkDiag(board) == true || checkHoriz(board) == true)
			return true;
		return false;
	}
	
	/**
	
	*/
	public static boolean checkDiag(int[][] board) //works
	{
		int index = 0;
		while (index < board.length-1)
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
	public static boolean checkVert(int[][] grid) //works
	{
		int sum = 0; 
		for (int column = 0; column < grid.length; column++){
			int value = grid[0][column];
			for (int row = 0; row < grid.length; row++){
				if (grid[row][column] == (value))
			 	 	sum++;
			}
			if (sum == grid.length)
				return true;
			sum = 0;
		}
		return false; 
	}


	/**
	
	*/
	public static boolean checkHoriz(int[][] grid)
	{
		int sum = 0; 
		for (int row = 0; row < grid.length; row++){
			int value = grid[row][0];
			for (int column = 0; column < grid.length; column++){
				if (grid[row][column] == (value))
			 	 	sum++;
			}
			if (sum == grid.length)
				return true;
			sum = 0;
		}
		return false; 


	}
}