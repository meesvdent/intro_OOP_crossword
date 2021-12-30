package console.squares;

public class AnswerSquare extends WhiteSquare{

    private char answer;

    public AnswerSquare(char answer){
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
