package console;

public class KeyboardKey {

    private final char letter;
    private final boolean available;

    public KeyboardKey(char letter, boolean available){
        this.letter = letter;
        this.available = available;
    }

    public char getLetter() {
        return letter;
    }

    public boolean isAvailable() {
        return available;
    }

    public String toString(){
        if(available){
            return " " + this.letter + " ";
        }
        else{
            return "(" + this.letter + ")";
        }
    }
}
