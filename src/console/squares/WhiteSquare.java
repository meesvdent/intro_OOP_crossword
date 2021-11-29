package console.squares;

public class WhiteSquare extends AbstractSquare{

    private String input;

    public WhiteSquare(){
        super("white", "O");
    }

    public WhiteSquare(String type, String symbol){
        super(type, symbol);
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
