package console.board;

import console.squares.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Board {

    private int width;
    private int height;

    AbstractSquare[][] squares;

    public Board(String filename){
        this.parseSquares(filename);
    }

    public int getWidth(){
        return this.width;
    }

    public int getHeight(){
        return this.height;
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
                        this.squares[i][j] = new BlueSquare((String) nextString.charAt(2));
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
        System.out.println(this.squares);
    }

    public static void main(String[] args) {
        String filename = "puzzle-1-adjusted.txt";
        Board testBoard = new Board(filename);
        System.out.println(testBoard.getHeight() + testBoard.getWidth());
    }
}
