package com.ds.algo.LLD.tictactoe;

import com.ds.algo.LLD.tictactoe.Model.*;

import java.util.Deque;
import java.util.LinkedList;

public class TicTacToeGame extends Game {
    Deque<Player> players;
    Board gameBoard;

    public TicTacToeGame() {
        initialise();
    }

    public void initialise() {

        players = new LinkedList<>();

        Player player1 = new Player("player1", new PieceX(PieceType.X));
        Player player2 = new Player("player2", new PieceX(PieceType.O));

        players.add(player1);
        players.add(player2);

        gameBoard = new Board(3);
    }

    public String startGame(){
        boolean noWinner = true;

        while(noWinner){
            Player playerTurn = players.removeFirst();

            //print board with free spaces
            //create getFreeCells method in Board

            //if there is no free space available then return as Tied

            //or else ask player to input the cell where piece needs to be added

            // add piece on the provided input above on the gameBoard, take input through console
            int row=0;
            int col=0;

            // validations if provided input position is not null then throw error for incorrect position
            // add the player at First in deque so that same player can enter the input again

            //if successfull then add the player at the last in deque

            //write logic to check the winner if it is then return players name
            isWinner(row, col, playerTurn.getPlayingPiece().getType());

        }
        return "tie";
    }

    public boolean isWinner(int row, int col, PieceType pieceType){
        //check rows
        //check columns
        //check rightDiagonal
        //check leftDiagonal
        /***
         * Optimial solution would be use n queens algorithm
          */
        return true;
    }
}
