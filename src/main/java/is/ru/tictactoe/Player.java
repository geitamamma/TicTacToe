package is.ru.tictactoe;


public class Player{
	private String name;
	private int playerNr;

	public Player(String _name, int _playerNr) throws IllegalArgumentException{
		if(_name.isEmpty())
			throw new IllegalArgumentException("Please enter a name.");
		if(_playerNr < 1 || _playerNr > 2)
			throw new IllegalArgumentException("Player number must be between 1 and 2.");
		name = _name;
		playerNr = _playerNr;
	}

	public String GetName(){
	   return name;
	}

	public int GetPlayerNr(){
		return playerNr;
	}
}







