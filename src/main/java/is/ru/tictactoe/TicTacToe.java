package is.ru.tictactoe;

import static spark.Spark.*;
import spark.*;

public class TicTacToe {
    private static GameHub gameHub;
    private static Player player1;
    private static Player player2;

    public static void main(String[] args) {
        staticFileLocation("/public");
        
        if(System.getenv("PORT") == null)
            setPort(4567);
        else
            setPort(Integer.valueOf(System.getenv("PORT")));

        post(new Route("/add-names"){
            @Override
            public Object handle(Request request, Response response){
                String playerName1 = String.valueOf(request.queryParams("player1"));
                String playerName2 = String.valueOf(request.queryParams("player2"));
                try{
                    player1 = new Player(playerName1, 1);
                    player2 = new Player(playerName2, 2);
                }
                catch(IllegalArgumentException ex){
                    return ex.getMessage();
                }
                return "valid";
            }
        });

        post(new Route("/start-game"){
            @Override
            public Object handle(Request request, Response response){
                ITicTacToeGame game = new TicTacToeGame();
                gameHub = new GameHub(game, player1, player2);
                return gameHub.GetMessage();
            }
        });
        
        post(new Route("/mark-cell") {
            @Override
            public Object handle(Request request, Response response) {
                int cellNr = Integer.valueOf(request.queryParams("cell"));
                int playerNr = gameHub.GetNextPlayerNr();
                String returnString = "";
                gameHub.MarkCell(cellNr, gameHub.GetNextPlayerNr());
                int playerNrAfter = gameHub.GetNextPlayerNr();
                if(playerNr != playerNrAfter){
                    if(playerNr == 1)
                        return "X;" + gameHub.GetMessage();
                    return "O;" + gameHub.GetMessage();
                }
                return gameHub.GetMessage();
            }
        });
    }
}