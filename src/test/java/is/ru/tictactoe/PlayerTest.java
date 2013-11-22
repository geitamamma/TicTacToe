package is.ru.tictactoe;

import static org.junit.Assert.*;
import org.junit.Test;

public class PlayerTest{

     @Test
     public void Testplayer(){
        Player player  = new Player("Nonni", 1);
     	assertEquals("Nonni", player.GetName());
     }

}