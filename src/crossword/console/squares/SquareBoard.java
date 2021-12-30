package crossword.console.squares;

import crossword.console.squares.square.*;
import enums.SquareType;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

/*
* class which holds the squares (these are colored boxes where the answers to questions can be filled)
*
 */
public class SquareBoard {

    private int width; // number of horizontal squares, determined from input file
    private int height; // number of vertical squares, determined from input file

    private AbstractSquare[][] squares; // 2d array which holds the squares

    // Constructor method. As the parsing is a large function, this is called from the constructor.
    public SquareBoard(String filename){
        this.parseSquares(filename);
    }

    // Parsing method. Reads the input file and parses the part which contains the layout of the crossword puzzle.
    // Creates the correct squares and places these in squares at correct location.
    public void parseSquares(String filename){

        // start reading the input file
        try(Scanner scan = new Scanner(new File(filename))){
            String line = scan.nextLine();
            Scanner lineScan = new Scanner(line);
            lineScan.useDelimiter(" ");
            // read and set width and height from input file
            this.width = lineScan.nextInt();
            this.height = lineScan.nextInt();
            // initialize squares array with correct dimensions
            this.squares = new AbstractSquare[this.getHeight()][this.getWidth()];

            // loop through lines of the grid with squares
            for(int i=0; i<this.getHeight(); i++){
                String nextLine = scan.nextLine();
                Scanner nextScan = new Scanner(nextLine);
                nextScan.useDelimiter(" ");
                // loop through square representations within row
                for(int j=0; j<this.getWidth(); j++){
                    String nextString = nextScan.next();
                    // if O: create new whitesquare
                    if(nextString.equals("O")){
                        this.squares[i][j] = new WhiteSquare();
                    }
                    // if H: create new bluesquare
                    if(nextString.charAt(0) == 'H'){
                        this.squares[i][j] = new BlueSquare(nextString.charAt(2));
                    }
                    // if x: create new blacksquare
                    if(nextString.equals("X")){
                        this.squares[i][j] = new BlackSquare();
                    }
                    // if S: create new greysquare
                    if(nextString.equals("S")){
                        this.squares[i][j] = new GreySquare();
                    }
                }
            }
        }
        catch(IllegalArgumentException | FileNotFoundException e){
            e.printStackTrace();
            // if filenotfoundexception or illegalargumentexception an error must be thrown
        }
    }




    // getter functions for width and height
    public int getWidth(){
        return this.width;
    }

    public int getHeight(){
        return this.height;
    }

    // getter functions for squares
    public AbstractSquare[][] getSquares(){
        return this.squares;
    }

    public AbstractSquare getSquares(int i, int j){
        return this.squares[i][j];
    }

    // toString method to represent squares in human-readable format: similar to representation in input file.
    // used in console version. Can also represent state of squares (input).
    public String toString(){
        StringBuilder output = new StringBuilder();
        for(int i=0; i<this.height; i++){
            for(int j=0; j<this.width; j++){
                output.append(this.squares[i][j]).append("\t");
            }
            output.append("\n");
        }
        return output.toString();
    }

    // input entry into a square through console.
    public void inputSquare(int i, int j){
        // enter a character input in a square

        // check whether indexes are within domain
        if(i >= 0 && i < this.getHeight() && j >= 0 && j < this.width){
            AbstractSquare curSquare = this.getSquares(i, j);

            // Check whether the chosen square is an instance of WhiteSquare (the only squares which accept input).
            if(curSquare.getType() == SquareType.WHITE){
                System.out.println("Set the letter on square " + i + ", " + j + ".");
                System.out.println("Your white square options: " + Arrays.toString(((WhiteSquare) curSquare).getOptions()));
                ((WhiteSquare) curSquare).setInput(new Scanner(System.in).next());
            }
            else{
                System.out.println("This square does not accept input.");
            }
        }
        else{
            System.out.println("out of bounds");
        }
        System.out.println(this);
    }
}
