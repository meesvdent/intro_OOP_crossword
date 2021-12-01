package console.board;

import console.squares.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Board {

    private int width;
    private int height;

    private String answer;

    private AbstractSquare[][] squares;
    private AnswerSquare[] answerSquares;

    public Board(String filename, String answer){
        this.parseSquares(filename);
        this.parseAnswer(answer);
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

    public String toString(){
        StringBuilder output = new StringBuilder();
        for(int i=0; i<this.height; i++){
            for(int j=0; j<this.width; j++){
                output.append(this.squares[i][j]);
                output.append("\t");
            }
            output.append("\n");
        }
        return output.toString();
    }

    public void inputSquare(int i, int j){
        if(i >= 0 && i < this.getHeight() && j >= 0 && j < this.width){
            AbstractSquare curSquare = this.getSquares(i, j);
            if(curSquare instanceof BlueSquare blueSquare){
                System.out.println("Your options: " + Arrays.toString(blueSquare.getOptions()));
            }
            if(curSquare instanceof WhiteSquare whiteSquare){
                System.out.println("Set the letter on square " + i + ", " + j + ".");
                whiteSquare.setInput(new Scanner(System.in).next());
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
                        this.squares[i][j] = new BlueSquare(nextString.charAt(2));
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

    public void parseAnswer(String answer){

        char[] charArray = answer.toCharArray();
        AnswerSquare[] answerSquares = new AnswerSquare[answer.length()];

        for(int i=0; i<answer.length(); i++){
            char ch = answer.charAt(i);
            answerSquares[i] = new AnswerSquare(ch);
        }

        this.answerSquares = answerSquares;
    }

    public boolean checkAnswer(){
        for(AnswerSquare answerSquare : this.answerSquares){
            if(!answerSquare.checkAnswer()){
                return false;
            }
        }
        return true;
    }

}
