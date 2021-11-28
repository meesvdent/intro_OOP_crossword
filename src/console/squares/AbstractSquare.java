package console.squares;

public abstract class AbstractSquare {

    private String type;

    public AbstractSquare(String type){
        this.type = type;
    }

    public String getType(){
        return this.type;
    }
}
