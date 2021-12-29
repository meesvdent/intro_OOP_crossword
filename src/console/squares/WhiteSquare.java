package console.squares;

import java.util.Arrays;

public class WhiteSquare extends AbstractSquare{

    protected String input;
    protected char[] options;

    public WhiteSquare(){
        super("white", "O");
        this.setOptions();
    }

    public WhiteSquare(String type, String symbol){
        super(type, symbol);
        this.setOptions();
    }

    public void setOptions(){
        char[] optionCharacters = new char[26];
        for(int i = 0; i<26; i++){
             optionCharacters[i] = (char) (i+'A');
        }
        this.options =  optionCharacters;
    }

    public Character[] getOptions(){
        int nOptions = this.options.length;
        Character[] characterOptions = new Character[nOptions];
        int i = 0;
        for(char option : this.options){
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
