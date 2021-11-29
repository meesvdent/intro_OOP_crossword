package console.squares;

public class BlueSquare extends WhiteSquare{

    private final String hint;
    // private final char[] options;

    public BlueSquare(String hint){
        super("blue", "H");
        this.hint = hint;
    }

    public String getHint(){
        return this.hint;
    }
}
