package console.squares;

public class BlueSquare extends WhiteSquare{

    private final char hint;
    // private final char[] options;

    public BlueSquare(char hint){
        super("blue");
        this.hint = hint;
    }

    public char getHint(){
        return this.hint;
    }
}
