package crossword.console.squares.square;

import enums.SquareType;

// Class which describes subtype of squares in which an input can be entered.
public class WhiteSquare extends AbstractSquare{

    protected String input; // user input
    protected char[] options; // options which can be entered in this square, if whitesquare will hold the alphabet

    public WhiteSquare(){
        super(SquareType.WHITE, "O");
        this.setOptions();
    }

    // constructor
    public WhiteSquare(SquareType type, String symbol){
        super(type, symbol);
        this.setOptions();
    }

    // getters and setters
    public void setOptions(){
        char[] optionCharacters = new char[26];
        for(int i = 0; i<26; i++){
             optionCharacters[i] = (char) (i+'A');
        }
        this.options =  optionCharacters;
    }

    public Character[] getOptions(){
        return getCharacters(this.options);
    }

    protected static Character[] getCharacters(char[] options) {
        int nOptions = options.length;
        Character[] characterOptions = new Character[nOptions];
        int i = 0;
        for(char option : options){
            characterOptions[i] = option;
            i++;
        }
        return characterOptions;
    }

    public String getSymbol(){
        if(! (this.getInput() == null)){
            return this.getInput();
        }
        else{
            return this.symbol;
        }
    }

    public String getInput(){
        return this.input;
    }

    public void setInput(String input){
        this.input = input;
    }

    public String toString(){
        if(this.input == null){
            return "(" + this.getSymbol() + ")";
        } else{
            return " " + this.getInput() + " ";
        }
    }

}
