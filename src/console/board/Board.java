package console.board;

import console.squares.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Board {

    private int width;
    private int height;

    private AbstractSquare[][] squares;

    public Board(String filename){
        this.parseSquares(filename);
    }

    public int getWidth(){
        return this.width;
    }

    public int getHeight(){
        return this.height;
    }

    public AbstractSquare[][] getSquares(){
        return this.squares;
    }

    public AbstractSquare getSquares(int i, int j){
        return this.squares[i][j];
    }

    public void printBoard(){
        for(int i=0; i<this.height; i++){
            for(int j=0; j<this.width; j++){
                System.out.print(this.squares[i][j].getSymbol());
                System.out.print("\t");
            }
            System.out.print("\n");
        }
    }

    public void inputSquare(int i, int j){
        if(i >= 0 && i < this.getHeight() && j >= 0 && j < this.width){
            AbstractSquare curSquare = this.getSquares(i, j);
            if(curSquare instanceof BlueSquare){
                System.out.println("Your options: " + Arrays.toString(curSquare.getOptions()));
            }
            if(curSquare instanceof WhiteSquare){
                System.out.println("Set the letter on square " + i + ", " + j + ".");
                ((WhiteSquare) curSquare).setInput(new Scanner(System.in).next());
            }
            else{
                System.out.println("This square does not accept input.");
            }
        }
        else{
            System.out.println("out of bounds");
        }
        this.printBoard();
    }

    public void parseSquares(String filename){

        try(Scanner scan = new Scanner(new File(filename))){
            String line = scan.nextLine();
            Scanner lineScan = new Scanner(line);
            lineScan.useDelimiter(" ");
            this.width = lineScan.nextInt();
            this.height = lineScan.nextInt();
            this.squares = new AbstractSquare[this.getHeight()][this.getWidth()];

            for(int i=0; i<this.getHeight(); i++){
                String nextLine = scan.nextLine();
                Scanner nextScan = new Scanner(nextLine);
                nextScan.useDelimiter(" ");
                for(int j=0; j<this.getWidth(); j++){
                    String nextString = nextScan.next();
                    if(nextString.equals("O")){
                        this.squares[i][j] = new WhiteSquare();
                    }
                    if(nextString.charAt(0) == 'H'){
                        this.squares[i][j] = new BlueSquare(String.valueOf(nextString.charAt(2)));
                    }
                    if(nextString.equals("X")){
                        this.squares[i][j] = new BlackSquare();
                    }
                    if(nextString.equals("S")){
                        this.squares[i][j] = new GreySquare();
                    }
                }
            }
        }
        catch(IllegalArgumentException | FileNotFoundException e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        String filename = "puzzle-1-adjusted.txt";
        Board testBoard = new Board(filename);
        testBoard.printBoard();
        testBoard.inputSquare(0, 3);
    }
}
