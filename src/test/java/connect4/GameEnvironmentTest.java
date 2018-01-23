package connect4;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * Created by loick on 07/12/2016.
 */
public class GameEnvironmentTest extends GameEnvironment{
    GameEnvironmentTest game;
    Display display = new Display();
    public GameEnvironmentTest() {
        super();
    }

    @Test
    public void  testVerifyIfBoardFullAtInitilisation() throws Exception{
        game = new GameEnvironmentTest();
        assertEquals(false,game.VerifyIfBoardFull());
    }
    @Test
    public void testVerifyIfBoardFullWhenIsFull() throws Exception{
        game = new GameEnvironmentTest();
        for (int i =0;i<7;i++){
            for (int j =0;j<6;j++){
                if(game.board.GetCase(i,j).symbol == ' '){
                   game.board.GetCase(i,j).symbol = 'X';
                }
            }
        }
        display.Update(game.board);
        assertEquals(true,game.VerifyIfBoardFull());
    }
    @Test
    public void testGetNeighboursInDirection(){
        game = new GameEnvironmentTest();
        game.board.PutPieceInBoard(new Player(),0);
        game.board.PutPieceInBoard(new Player(),0);
        display.Update(game.board);
        assertEquals(game.board.GetCase(0,4),game.GetNeighboursInDirection(game.board.GetCase(0,5),Direction.NORTH));
    }
    @Test
    public void testVerifyNeighbours(){
        game = new GameEnvironmentTest();
        game.listPlayer[0] = new Player();
        game.board.PutPieceInBoard(game.listPlayer[0],0);
        game.board.PutPieceInBoard(game.listPlayer[0],0);
        game.board.PutPieceInBoard(game.listPlayer[0],0);
        game.board.PutPieceInBoard(game.listPlayer[0],0);
        display.Update(game.board);
        ArrayList<Cell> testNeighArray = new ArrayList<>();
        testNeighArray.add(game.board.GetCase(0,4));
        testNeighArray.add(game.board.GetCase(0,3));
        testNeighArray.add(game.board.GetCase(0,2));
        game.VerifyNeighbours(game.board.GetCase(0,5),Direction.NORTH);
        assertEquals(testNeighArray,game.neighboursArray);
    }
    @Test
    public void testVerifyIfPlayerWin(){
        game = new GameEnvironmentTest();
        game.listPlayer[0] = new Player();
        game.board.PutPieceInBoard(game.listPlayer[0],0);
        game.board.PutPieceInBoard(game.listPlayer[0],0);
        game.board.PutPieceInBoard(game.listPlayer[0],0);
        game.board.PutPieceInBoard(game.listPlayer[0],0);
        assertTrue(game.VerifyIfPlayerWin());
    }

    @Test
    public void testVerifyIfPlayerLoose(){
        game = new GameEnvironmentTest();
        game.listPlayer[0] = new Player();
        game.board.PutPieceInBoard(game.listPlayer[0],0);
        game.board.PutPieceInBoard(game.listPlayer[0],0);
        game.board.PutPieceInBoard(game.listPlayer[0],0);
        assertFalse(game.VerifyIfPlayerWin());
    }

}