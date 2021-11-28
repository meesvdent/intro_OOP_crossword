package console.squares;

public class WhiteSquare extends AbstractSquare{

    private char input;

    public WhiteSquare(){
        super("white");
    }

    public WhiteSquare(String type){
        super(type);
    }

    public char getInput(){
        return this.input;
    }

    public void setInput(char input){
        this.input = input;
    }

}
