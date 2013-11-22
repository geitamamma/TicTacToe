package is.ru.tictactoe;

import static spark.Spark.*;
import spark.*;

public class TicTacToe {
    public static void main(String[] args) {
        staticFileLocation("/public");
        
        setPort(Integer.valueOf(System.getenv("PORT")));

        get(new Route("/hello") {
            @Override
            public Object handle(Request request, Response response) {
                return "Hello World!";
            }
        });

        /*
        post(new Route("/mark-cell") {
            @Override
            public Object handle(Request request, Response response) {
                int x = 0;
                return Integer.valueOf(request.queryParams("cell"));
            }
        });
        */
    }
}