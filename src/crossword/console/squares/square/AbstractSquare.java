package crossword.console.squares.square;

import enums.SquareType;

/*
* abstract class
* Holds the variable which each child class has: type and symbol
* Describes the methods which each child class inherits.
 */
public abstract class AbstractSquare implements Square {

    protected SquareType type; // type of the square
    protected String symbol; // symbol which will represent the square in console version

    // constructor
    public AbstractSquare(SquareType type, String symbol){
        this.type = type;
        this.symbol = symbol;
    }

    // getters and setters
    public SquareType getType(){
        return this.type;
    }

    public String getSymbol(){
        return this.symbol;
    }

    public String toString(){
        return "(" + this.getSymbol() + ")";
    }
}
