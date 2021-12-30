package console.squares;

/*
* abstract class
* Holds the variable which each child class has: type and symbol
* Describes the methods which each child class inherits.
 */
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

    public String toString(){
        return "(" + this.getSymbol() + ")";
    }
}
