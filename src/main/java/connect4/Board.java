package connect4;

import javafx.collections.ObservableArray;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by brice on 24/11/2016.
 */
public class Board {
    //Protected for test
    protected Cell[][] vBoard = new Cell[7][6];

    public Board(Board b){
        vBoard = b.vBoard ;
    }
    public Board() {
        for (int i = 0;i<7;i++) {
            for(int j =0; j<6;j++){
                vBoard[i][j] =  new Cell(i,j,' ');
            }
        }
    }

    public boolean IsInBoard(int x){
        if(x < 0 || x > 6){
            return false;
        }
        else{
            return true;
        }
    }
    public boolean ColumnIsNotFull(int x){
        int i = 0;
        int numberOfCasePlayed = 0;

        for (i = 0;i<6;i++){
            if(vBoard[x][i].symbol == 'X' || vBoard[x][i].symbol == 'O') {
                numberOfCasePlayed ++;
            }
        }

        if(numberOfCasePlayed == 6){
            return false;

        }
        else{
            return true;
        }
    }
    public void PutPieceInBoard(Player player,int x){
        int i = 5;
        while((vBoard[x][i].symbol != ' ')&&(i>=0)){
            i--;
        }
        if(i>=0){
            vBoard[x][i].SetSymbol(player.getPieceForm());

        }

    }
    public Cell GetCase(int x,int y){
        return vBoard[x][y];
    }


}
