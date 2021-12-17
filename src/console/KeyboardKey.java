package console;

public class KeyboardKey {

    char letter;
    boolean available;

    public KeyboardKey(char letter, boolean available){
        this.letter = letter;
        this.available = available;
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
