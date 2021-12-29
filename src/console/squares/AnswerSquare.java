package console.squares;

public class AnswerSquare extends WhiteSquare{

    private char answer;

    public AnswerSquare(char answer){
        this.answer = answer;
    }

    public boolean checkAnswer(){
        System.out.println("checking: ");
        System.out.println(answer);
        System.out.println(input);
        if(!this.input.isEmpty()){
            return this.answer == this.input.charAt(0);
        } else{
            return false;
        }
    }

}
