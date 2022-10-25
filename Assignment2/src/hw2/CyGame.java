package hw2;
/**
 * Model of a Monopoly-like game. Two players take turns rolling dice to move
 * around a board. The game ends when one of the players has at least
 * MONEY_TO_WIN money or one of the players goes bankrupt (has negative money).
 * 
 * @author YOUR_NAME_HERE
 */
public class CyGame {
/**
 * Do nothing square type.
 */
public static final int DO_NOTHING = 0;
/**
 * Pass go square type.
 */
public static final int PASS_GO = 1;
/**
 * Cyclone square type.
 */
public static final int CYCLONE = 2;
/**
 * Pay the other player square type.
 */
public static final int PAY_PLAYER = 3;
/**
 * Get an extra turn square type.
 */
public static final int EXTRA_TURN = 4;
/**
 * Jump forward square type.
 */
public static final int JUMP_FORWARD = 5;
/**
 * Stuck square type.
 */
public static final int STUCK = 6;
/**
 * Points awarded when landing on or passing over go.
 */
public static final int PASS_GO_PRIZE = 200;
/**
 * The amount payed to the other player per unit when landing on a
 * PAY_PLAYER square.
 */
public static final int PAYMENT_PER_UNIT = 20;
/**
 * The amount of money required to win.
 */
public static final int MONEY_TO_WIN = 400;
/**
 * The cost of one unit.
 */
public static final int UNIT_COST = 50;
// TODO: EVERTHING ELSE
// Note that this code will not compile until you have put in stubs for all
// the required methods.
// The method below is provided for you and you should not modify it.
// The compile errors will go away after you have written stubs for the
// rest of the API methods.
/**
 * Returns a one-line string representation of the current game state. The
 * format is:
 * <p>
 * <tt>Player 1*: (0, 0, $0) Player 2: (0, 0, $0)</tt>
 * <p>
 * The asterisks next to the player's name indicates which players turn it
 * is. The numbers (0, 0, $0) indicate which square the player is on, how
 * many units the player has, and how much money the player has
 * respectively.
 * 
 * @return one-line string representation of the game state
 */

private int player1Money;
private int player2Money;
private int player1Units;
private int player2Units;
private int player1Square;
private int player2Square;
private int numSquares;
private int currentPlayer;

public CyGame(int i, int j) {
	numSquares = (i - 1);
	player1Money = j;
	player2Money = j;
	player1Units = 1;
	player2Units = 1;
	currentPlayer = 1;
}

public String toString() {
	String fmt = "Player 1%s: (%d, %d, $%d) Player 2%s: (%d, %d, $%d)";
	String player1Turn = "";
	String player2Turn = "";
	if (getCurrentPlayer() == 1) {
			player1Turn = "*";
	} 
	else {
			player2Turn = "*";
	}
	return String.format(fmt,
			player1Turn, getPlayer1Square(), getPlayer1Units(), getPlayer1Money(),
			player2Turn, getPlayer2Square(), getPlayer2Units(), getPlayer2Money());
	}

public void buyUnit() {
	if (isGameEnded() == false) {
		if (getCurrentPlayer() == 1 && player1Money >= UNIT_COST && getSquareType(player1Square) == DO_NOTHING) 
		{
			++player1Units;
			player1Money -= UNIT_COST;
			endTurn();
		}
		else if (getCurrentPlayer() == 2 && player2Money >= UNIT_COST && getSquareType(player2Square) == DO_NOTHING) 
		{
			++player2Units;
			player2Money -= UNIT_COST;
			endTurn();
		}
	}
}
/*
 * Method called to indicate the current player attempts to buy one unit.
 */
public void endTurn() {
	if (getCurrentPlayer() == 1) 
	{
		currentPlayer = 2;
	}
	else if (getCurrentPlayer() == 2)
	{
		currentPlayer = 1;
	}
}
/*
 * Method called to indicate the current player passes or completes their turn.
 */
public int getCurrentPlayer() {
	if(isGameEnded() == false) {
		if (currentPlayer == 1) 
		{
			return (1);
		}
		else if (currentPlayer == 2) 
		{
			return (2);
		}
	}
	return 0; //Here so program will compile
}
/*
 * Get the current player.
 */
public int getPlayer1Money() 
{
	return (player1Money);
}
/*
 * Get Player 1's money.
 */

public int getPlayer2Money() 
{
	return (player2Money);
}
/*
 * Get Player 2's money.
 */

public int getPlayer1Square() 
{
	return (player1Square);
}
/*
 * Get Player 1's square.
 */

public int getPlayer2Square() 
{
	return (player2Square);
}
/*
 * Get Player 2's square.
 */

public int getPlayer1Units() 
{
	return (player1Units);
}
/*
 * Get Player 1's units.
 */
public int getPlayer2Units() 
{
	return (player2Units);
}
/*
 * Get Player 1's units.
 */
public int getSquareType (int square) 
 {
	if (square == 0)
	{
		return (PASS_GO);
	}	
	/**
	 * If player's positions is equal to 0, adds PASS_GO_PRIZE and returns PASS_GO
	 */
	else if (square == numSquares)
	{
		return (CYCLONE);
	}
	/**
	 * If player's positions is equal to gameSquareAmount, sets player position to other players position, returns CYCLONE
	 */
	else if ((square % 5) == 0)
	{
		return (PAY_PLAYER);
	}
	/**
	 * If player's positions is equal to (i % 5) == 0, takes or adds PAYMENT_PER_UNIT, return PAY_PLAYER
	 */
	else if ((square % 7) == 0 || (square % 11 == 0))
	{
		return (EXTRA_TURN);
	}
	/**
	 * If player's positions is equal to (i % 7) or (i % 11) == 0, player revives extra turn, returns EXTRA_TURN
	 */
	else if ((square % 3) == 0)
	{
			return (STUCK);
	}
	/**
	 * If player's positions is equal to (i % 3) == 0, skips players turn, return STUCK
	 */
		
	else if ((square % 2) == 0)
	{
		return (JUMP_FORWARD);
	}
	/**
	 * If player's positions is equal to (i % 2) == 0, adds 4 square to position, return JUMP_FOWARD
	 */
	else
	{
		return (DO_NOTHING);
	}
	/**
	 * If none of the above, return DO_NOTHING
	 */
}
/*
 * Get the type of square for the given square number.
 */
public boolean isGameEnded() 
{
	if (player1Money >= MONEY_TO_WIN || player2Money >= MONEY_TO_WIN || player1Money < 0 || player2Money < 0) 
	{
		return (true);
	}
	else 
	{
		return (false);
	}
}
/*
 * Returns true if game is over, false otherwise.
 */
public void	roll (int value) {
	if (getCurrentPlayer() == 1 && !isGameEnded())
	{
		while (getCurrentPlayer() == 1)
		{
			if  (getSquareType(player1Square) == STUCK && value % 2 != 0) 
			{
				endTurn();
				break;
			}
			
			if ((player1Square + value) > numSquares)
			{
				player1Square -= numSquares;
				player1Square += (value - 1);
				player1Money += PASS_GO_PRIZE;
			}
			
			else
			{
				player1Square += value;
			}
			
			if (getSquareType(player1Square) == CYCLONE)
			{
				player1Square = player2Square;
			}
			
			else if (getSquareType(player1Square) == PAY_PLAYER)
			{
				player1Money -= (PAYMENT_PER_UNIT * player2Units);
				player2Money += (PAYMENT_PER_UNIT * player2Units);
			}
			
			else if (getSquareType(player1Square) == EXTRA_TURN)
			{
				break;
			}
			
			else if (getSquareType(player1Square) == JUMP_FORWARD)
			{
				if ((player1Square + 4) > numSquares)
				{
					player1Square -= numSquares;
					player1Square += 3;
					player1Money += PASS_GO_PRIZE;
				}
				else
				{
				player1Square += (4);
				}
			}
			
			endTurn();
		}
	}
	
	else if (getCurrentPlayer() == 2 && !isGameEnded()) {
		while (getCurrentPlayer() == 2)
		{
			if  (getSquareType(player2Square) == STUCK && value % 2 != 0) 
			{
				endTurn();
				break;
			}
			
			if ((player2Square + value) > numSquares)
			{
				player2Square += (value - numSquares); 
				player2Money += PASS_GO_PRIZE;
			}
			
			else
			{
				player2Square += value;
			}
			
			if (getSquareType(player2Square) == CYCLONE)
			{
				player2Square = player1Square;
			}
			
			else if (getSquareType(player2Square) == PAY_PLAYER)
			{
				player2Money -= (PAYMENT_PER_UNIT * player1Units);
				player1Money += (PAYMENT_PER_UNIT * player1Units);
			}
			
			else if (getSquareType(player2Square) == EXTRA_TURN)
			{
				break;
			}
			
			else if (getSquareType(player2Square) == JUMP_FORWARD)
			{
				player2Square += (4);
			}
			
			endTurn();
		}
	}
}
/*
 * Method called to indicate the dice has been rolled.
 */
public void	sellUnit() {
	if (isGameEnded() == false) {
		if (getCurrentPlayer() == 1 && player1Units > 0) 
		{
			--player1Units;
			player1Money += UNIT_COST;
			endTurn();
		}
		else if (getCurrentPlayer() == 2 && player2Units > 0) 
		{
			--player2Units;
			player2Money += UNIT_COST;
			endTurn();
		}
	}
}
/*
 * Method called to indicate the current player attempts to sell one unit.
 */
}
