package connect4;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by loick on 07/12/2016.
 */
public class PlayerTest extends Player{

    public PlayerTest(){
        super();
    }

    @Test
    public void testPlay() throws Exception {
        Board board = new Board();
        Play(board,0);
        Play(board, 10);
        Play(board, -1);
        boolean test;
        if(board.GetCase(0,0).symbol == ' ')
            { test = true;}
        else
            { test = false;}
        assertEquals(true, test);
    }

}