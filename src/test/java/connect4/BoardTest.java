package connect4;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by loick on 07/12/2016.
 */
public class BoardTest extends Board{

    public BoardTest(){
        super();
    }

    @Test
    public void testIsInBoard() throws Exception {
        assertEquals(true,IsInBoard(5));
        assertEquals(false, IsInBoard(9));
    }

    @Test
    public void testColumnIsFull() throws Exception {
        assertEquals(true, ColumnIsNotFull(1));
        for(int i = 0; i < 6; i++){
            PutPieceInBoard(new Player(),1);
        }
        assertEquals(false, ColumnIsNotFull(1));
    }

    @Test
    public void testPutPieceInBoard() throws Exception {
        PutPieceInBoard(new Player(), 1);
        boolean test;
        if(GetCase(0,0).symbol == ' ')
        { test = true;}
        else
        { test = false;}
        assertEquals(true, test);
    }

    @Test
    public void testGetCase() throws Exception {
        GetCase(1,2);
        assertEquals(vBoard[1][2], GetCase(1,2));
    }

}