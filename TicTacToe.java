package misc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class TicTacToe {
    static String[][] Board = { {" ", " ", " "},
                                {" ", " ", " "},
                                {" ", " ", " "}};
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        printBoard(Board);
        int turns = 0;
        char playerTurn = 'X';
        System.out.println("X's turn");
        while(in.hasNextLine() && turns<=10) {
            try{
            String[] parts = in.nextLine().split("\\s+", 3);
            int col = Integer.parseInt(parts[0]);
            int row = Integer.parseInt(parts[1]);
            if (turns % 2 == 0 && parts[2].equals("X")) {
                if(!checkIfTaken(Board, row, col)) {
                    makeX(Board, row - 1, col - 1);
                    System.out.println("O's turn");
                    playerTurn = 'O';
                    printBoard(Board);
                    if (checkWin(Board)) break;
                    if (checkForDraw(Board)) break;
                }
                else {
                    printBoard(Board);
                    System.out.println("Spot is already taken, please choose an empty spot");
                    System.out.println("X's turn");
                }
            }
            if (turns % 2 == 1 && parts[2].equals("O")) {
                if(!checkIfTaken(Board, row, col)) {
                    makeO(Board, row - 1, col - 1);
                    printBoard(Board);
                    System.out.println("X's turn");
                    playerTurn = 'X';
                    if (checkWin(Board)) break;
                    if (checkForDraw(Board)) break;
                }
                else {
                    printBoard(Board);
                    System.out.println("Spot is already taken, please choose an empty spot");
                    System.out.println("O's turn");
                }
            }
            if (!parts[2].equals("X") && !parts[2].equals("O")) {
                System.out.println("Please input a proper command");
            }
            turns++;
        } catch (IndexOutOfBoundsException e){
                System.out.println("Please input a proper coordinate");
                if(playerTurn=='X'){
                    printBoard(Board);
                    System.out.println("X's turn");
                }
                if(playerTurn=='O'){
                    printBoard(Board);
                    System.out.println("O's turn");
                }
            }
        }
    }
    //prints the board
    public static void printBoard(String[][] Board) {
        for(int row = 0; row<Board.length; row++){
            System.out.println(Arrays.toString(Board[row]));
        }
    }
    //takes the inputted coordinates and makes it an X
    public static void makeX(String[][]Board, int row, int col){
        Board[row][col]="X";
    }
    //takes the inputted coordinates and makes it an O
    public static void makeO(String[][]Board, int row, int col){
        Board[row][col]="O";
    }
    public static boolean checkWin(String[][]Board){
        //checks rows
        for(int row = 0; row<Board.length; row++){
            if((!Board[row][0].equals(" ")) && (Board[row][0].equals("X") || Board[row][0].equals("O")) && (Board[row][0].equals(Board[row][1]) &&  Board[row][0].equals(Board[row][2]))){
                System.out.println(Board[row][0] + " wins!");
                return true;
            }
        }
        //checks columns
        for(int col = 0; col<Board.length; col++){
            if((!Board[0][col].equals(" ")) && (Board[0][col].equals("X") || Board[0][col].equals("O")) && (Board[0][col].equals(Board[1][col]) &&  Board[0][col].equals(Board[2][col]))){
                System.out.println(Board[0][col] + " wins!");
                return true;
            }
        }
        //checks  bottom right diagonals
        for(int col = 0, row = 0; col<Board.length; col++, row++){
            if((!Board[row][col].equals(" ")) && (Board[row][col].equals("X") || Board[row][col].equals("O")) && (Board[row][col].equals(Board[1][1]) &&  Board[row][col].equals(Board[2][2]))){
                System.out.println(Board[row][col] + " wins!");
                return true;
            }
        }
        //checks bottom left diagonals
        for(int col = 2, row = 0; row<Board.length; col--, row++){
            if((!Board[row][col].equals(" ")) && (Board[row][col].equals("X") || Board[row][col].equals("O")) && (Board[row][col].equals(Board[1][1]) &&  Board[row][col].equals(Board[2][0]))){
                System.out.println(Board[row][col] + " wins!");
                return true;
            }
        }
        return false;
    }
    //checks if the end result is a draw
    public static boolean checkForDraw(String[][]Board){
        int ans = 0;
        for(int row = 0; row < Board.length; row++){
            for(int col = 0; col<Board[row].length; col++){
                if(!Board[row][col].equals(" ")){
                    ans++;
                }
            }
        }
        if(ans==9){
            return true;
        }
        return false;
    }
    //checks if the current spot is already taken by something
    public static boolean checkIfTaken(String[][]Board, int row, int col){
        if(!Board[row][col].equals(" ")){
            return true;
        }
        return false;
    }
}


