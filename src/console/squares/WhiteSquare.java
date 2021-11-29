package console.squares;

import java.util.Arrays;

public class WhiteSquare extends AbstractSquare{

    private String input;
    private String[] options;

    public WhiteSquare(){
        super("white", "O");
        this.setOptions();
    }

    public WhiteSquare(String type, String symbol){
        super(type, symbol);
    }

    public void setOptions(){
        String[] stringArray = new String[26];
        for(int i = 0; i<26; i++){
            char e = (char) (i+'A');
            stringArray[i] = String.valueOf(e);
        }
        this.options = stringArray;
    }

    public String[] getOptions(){
        return this.options;
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

}
