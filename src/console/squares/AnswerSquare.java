package console.squares;

public class AnswerSquare extends WhiteSquare{

    private char answer;
    private char input;

    public AnswerSquare(char answer){
        this.answer = answer;
    }

    public void setInput(char input){
        this.input = input;
    }

    public boolean checkAnswer(){
        return this.answer == this.input;
    }

}
