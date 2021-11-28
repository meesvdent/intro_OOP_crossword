package console.squares;

public abstract class AbstractSquare {

    private String type;
    private String symbol;

    public AbstractSquare(String type, String symbol){
        this.type = type;
        this.symbol = symbol;
    }

    public String getType(){
        return this.type;
    }
}
