package crossword.console.squares.square;

public class AnswerSquare extends WhiteSquare{

    private final char answer;

    public AnswerSquare(char answer){
        super();
        this.answer = answer;
    }

    public boolean checkAnswer(){
        if(!(this.input == null)){
            return this.answer == this.input.charAt(0);
        } else{
            return false;
        }
    }

}
