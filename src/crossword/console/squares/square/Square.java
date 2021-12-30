package crossword.console.squares.square;

import enums.SquareType;

// interface which specify methods necessary for square classes
public interface Square {

    SquareType getType();
    String getSymbol();
}
