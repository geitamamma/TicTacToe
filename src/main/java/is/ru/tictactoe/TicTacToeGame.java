package is.ru.tictactoe;

public class TicTacToeGame implements ITicTacToeGame{
	private int[] gameBoard;
	private static int nextPlayer;
	private static int movesLeft;

	public TicTacToeGame(){
		Initialize();
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

	private void Initialize(){
		nextPlayer = 1;
		movesLeft = 9;
		gameBoard = new int[9];
		for(int i=0; i<9; i++)
			gameBoard[i] = 0;
	}
}