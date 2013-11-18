package is.ru.tictactoe;

public interface ITicTacToeGame{
	int[] GetGameBoard();
	int GetNextPlayer();
	int GetMovesLeft();
	void MarkCell(int cellNr, int playerNr) throws Exception;
}