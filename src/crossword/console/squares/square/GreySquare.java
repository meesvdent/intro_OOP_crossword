package crossword.console.squares.square;

import enums.SquareType;

// Extends white square, has the same behavior as WhiteSquare, except that the background in the GUI will be grey.
// The user will be able to see that this letter will be part of the answer.
public class GreySquare extends WhiteSquare {

    // just calls the constructor of parent class with correct variables
    public GreySquare(){
        super(SquareType.GREY, "S");
    }

}
