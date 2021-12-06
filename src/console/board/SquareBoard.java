package console.board;

import console.questions.Question;
import console.squares.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class SquareBoard {

    private int width;
    private int height;

    private AbstractSquare[][] squares;

    private ArrayList<Question>[] questions;

    public SquareBoard(String filename, String answer){
        this.parseSquares(filename);
        this.parseQuestions(filename);
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
                output.append(this.squares[i][j]).append("\t");
            }
            output.append("\n");
        }
        output.append("Questions:\n");
        output.append("ACROSS\n");
        for(Object question : this.questions[0]){
            output.append(question).append("\n");
        }
        output.append("DOWN\n");
        for(Object question: this.questions[1]){
            output.append(question).append("\n");
        }
        return output.toString();
    }

    public void inputSquare(int i, int j){
        // enter a character input in a square

        // check whether indexes are within domain
        if(i >= 0 && i < this.getHeight() && j >= 0 && j < this.width){
            AbstractSquare curSquare = this.getSquares(i, j);

            // Check whether the chosen square is an instance of WhiteSquare (the only squares which accept input).
            if(curSquare instanceof WhiteSquare whiteSquare){
                System.out.println("Set the letter on square " + i + ", " + j + ".");
                System.out.println("Your white square options: " + Arrays.toString(whiteSquare.getOptions()));
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

    public void parseQuestions(String filename){

        this.questions = new ArrayList[2];

        try(Scanner questionScan = new Scanner(new FileReader(filename))){
            while (questionScan.hasNextLine()){
                String nextLine = questionScan.nextLine();
                Scanner nextScan = new Scanner(nextLine);
                String nextWord = nextScan.next();
                if(nextWord.equals("ACROSS")){
                    this.questions[0] = new ArrayList<>();
                    nextLine = questionScan.nextLine();
                    nextScan = new Scanner(nextLine);
                    nextWord = nextScan.next();
                    while(! nextWord.equals("DOWN")){
                        this.questions[0].add(new Question(nextLine));
                        nextLine = questionScan.nextLine();
                        nextScan = new Scanner(nextLine);
                        nextWord = nextScan.next();
                    }
                }
                if (nextWord.equals("DOWN")) {
                    this.questions[1] = new ArrayList<>();
                    while (questionScan.hasNextLine()){
                        this.questions[1].add(new Question(questionScan.nextLine()));
                    }
                }

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }


}
