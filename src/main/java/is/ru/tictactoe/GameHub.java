package is.ru.tictactoe;

import java.util.ArrayList;

public class GameHub{
	private static ITicTacToeGame game;
	private static Player player1;
	private static Player player2;
	private boolean gameOver;
	private boolean isDraw;
	private String message;
	private int winner;

	public GameHub(ITicTacToeGame _game, Player _player1, Player _player2) throws IllegalArgumentException{
		if(_game == null || _player1 == null || _player2 == null)
			throw new IllegalArgumentException("This is somewhat embarrassing, please try again.");
		game = _game;
		player1 = _player1;
		player2 = _player2;
		winner = 0;
		message = "First player is " + GetNextPlayerName() + ".";
	}

	public void MarkCell(int cellNr, int playerNr){
		if(gameOver)
			return;
		try{
			game.MarkCell(cellNr, playerNr);
		}
		catch(IllegalArgumentException ex){
			message = ex.getMessage() + " Next player is " + GetNextPlayerName() + "."; 
			return;
		}
		CheckWinner(playerNr);
		if(!gameOver)
			message = GetNextPlayerName() + ", it's your turn !";
	}

	private void CheckWinner(int playerNr){
		int[] gameBoard = game.GetGameBoard();
		for(int i=0; i<3; i++){
			if((gameBoard[i*3] != 0 
				&& gameBoard[i*3] == gameBoard[(i*3)+1] 
				&& gameBoard[i*3] == gameBoard[(i*3)+2]) || 
				(gameBoard[i] != 0 
				&& gameBoard[i] == gameBoard[i+3] 
				&& gameBoard[i] == gameBoard[i+6])){
			gameOver = true;
			message = GetWinner(playerNr);
			return;
			}
		}
		if((gameBoard[0] != 0 
			&& gameBoard[0] == gameBoard[4]
			&& gameBoard[0] == gameBoard[8]) ||
			(gameBoard[2] != 0
			&& gameBoard[2] == gameBoard[4]
			&& gameBoard[2] == gameBoard[6])){
		gameOver = true;
		message = GetWinner(playerNr);
		return;
		}
		if(game.GetMovesLeft() < 1){
			message = "It's a draw !";
			gameOver = true;
		}
	}

	public String GetWinner(int playerNr){
		if(player1.GetPlayerNr() == playerNr)
			return player1.GetName() + " has won !";
		return player2.GetName() + " has won !";
	}

	public String GetMessage(){
		return message;
	}

	public String GetNextPlayerName(){
		if(player1.GetPlayerNr() == game.GetNextPlayer())
			return player1.GetName();
		else
			return player2.GetName();
	}

	public int GetNextPlayerNr(){
		return game.GetNextPlayer();
	}
}
