package console.squares;

public class WhiteSquare extends AbstractSquare{

    private char input;

    public WhiteSquare(){
        super("white", "O");
    }

    public WhiteSquare(String type, String symbol){
        super(type, symbol);
    }

    public char getInput(){
        return this.input;
    }

    public void setInput(char input){
        this.input = input;
    }

}
