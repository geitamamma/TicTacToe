package is.ru.tictactoe;
// Mock class for TicTacToeGame
// 3 moves left
// Player 1 is next
public class TicTacToeMock implements ITicTacToeGame{
	private int[] gameBoard;
	private int nextPlayer;
	private int movesLeft;

	public TicTacToeMock(){
		//Game Board
		//x x
		//  o o
		//o x
		gameBoard = new int[9];
		gameBoard[0] = 1;
		gameBoard[1] = 1;
		gameBoard[2] = 0;
		gameBoard[3] = 0;
		gameBoard[4] = 2;
		gameBoard[5] = 2;
		gameBoard[6] = 2;
		gameBoard[7] = 1;
		gameBoard[8] = 0;
		nextPlayer = 1;
		movesLeft = 3; 
	}

	public int[] GetGameBoard(){
		return gameBoard;
	}

	public int GetNextPlayer(){
		return nextPlayer;
	}

	public int GetMovesLeft(){
		return movesLeft;
	}

	public void MarkCell(int cellNr, int playerNr) throws IllegalArgumentException{
		if(cellNr < 0 || cellNr > 8)
			throw new IllegalArgumentException("Cell number is out of bounce.");
		if(playerNr < 1 || playerNr > 2)
			throw new IllegalArgumentException("Player number must be between 1 and 2.");
		if(gameBoard[cellNr] != 0)
			throw new IllegalArgumentException("This cell has already been marked.");
		gameBoard[cellNr] = playerNr;
		SetNextPlayer(playerNr);
		movesLeft -= 1;
	}

	private void SetNextPlayer(int playerNr){
		if(playerNr == 1)
			nextPlayer = 2;
		else
			nextPlayer = 1;
	}
}