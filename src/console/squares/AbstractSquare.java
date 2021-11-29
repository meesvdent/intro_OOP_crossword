package console.squares;

public abstract class AbstractSquare {

    protected String type;
    protected String symbol;

    public AbstractSquare(String type, String symbol){
        this.type = type;
        this.symbol = symbol;
    }

    public String getType(){
        return this.type;
    }

    public String getSymbol(){
        return this.symbol;
    }

    public String[] getOptions(){
        return new String[0];
    }
}
