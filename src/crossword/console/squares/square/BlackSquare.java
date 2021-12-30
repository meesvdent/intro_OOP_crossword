package crossword.console.squares.square;

import enums.SquareType;

// square with white background, cannot be clicked in console, does not accept input.
public class BlackSquare extends AbstractSquare {

    public BlackSquare(){
        super(SquareType.BLACK, "X");
    }
}
