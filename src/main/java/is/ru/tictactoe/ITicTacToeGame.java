package is.ru.tictactoe;

public interface ITicTacToeGame{
	public int[] GetGameBoard();
	public int GetNextPlayer();
	public int GetMovesLeft();
	public void MarkCell(int cellNr, int playerNr) throws IllegalArgumentException;
}