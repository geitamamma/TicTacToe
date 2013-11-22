package is.ru.tictactoe;

public class GameHub{
	private ITicTacToeGame game;

	public GameHub(){
		game = new TicTacToeGame();
	}

	public boolean CheckWinner(int p){
		int[] gameBoard = game.GetGameBoard();
		if(gameBoard[0] == p && gameBoard[1] == p && gameBoard[2] == p){
			return true;
		}
		else if(gameBoard[3] == p && gameBoard[4] == p && gameBoard[5] == p){
			return true;
		}
		else if(gameBoard[6] == p && gameBoard[7] == p && gameBoard[8] == p){
			return true;
		}
		else if(gameBoard[0] == p && gameBoard[3] == p && gameBoard[6] == p){
			return true;
		}
		else if(gameBoard[1] == p && gameBoard[4] == p && gameBoard[7] == p){
			return true;
		}
		else if(gameBoard[2] == p && gameBoard[5] == p && gameBoard[8] == p){
			return true;
		}
		else if(gameBoard[0] == p && gameBoard[4] == p && gameBoard[8] == p){
			return true;
		}
		else if(gameBoard[2] == p && gameBoard[4] == p && gameBoard[6] == p){
			return true;
		} 
			return false;


	}

	public	boolean IsWon(int p){
		return CheckWinner(p);
	}	
/*
	public	boolean IsDraw(){
		if(CheckWinner(p) == false)
		{
			return true;
		}
	}
*/
	public boolean MarkCell(int p, int c){
		int[] gameBoard = game.GetGameBoard();
		if(gameBoard[c]==0){
	
		gameBoard[c]=p;
		return true;
	}
		return false;
	}

}