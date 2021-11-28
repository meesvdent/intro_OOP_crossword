package console.squares;

public class BlueSquare extends WhiteSquare{

    private final String hint;
    // private final char[] options;

    public BlueSquare(String hint){
        super("blue", "H(" + hint + ")");
        this.hint = hint;
    }

    public char getHint(){
        return this.hint;
    }
}
