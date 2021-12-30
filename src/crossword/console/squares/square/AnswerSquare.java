package crossword.console.squares.square;

// Extends WhiteSquare.
// This square is the only square type which will check whether the user input is correct.
// It receives its correct value in its constructer and stores it. It has a method checkAnswer, which will compare the stored input value with the stored correct value. If the input is empty or doesn’t match the answer this function will return false, otherwise true.
public class AnswerSquare extends WhiteSquare{

    private final char answer; // the correct answer for this square

    public AnswerSquare(char answer){
        super();
        this.answer = answer;
    }

    // function which checks whether the entered answer is correct
    public boolean checkAnswer(){
        if(!(this.input == null)){
            return this.answer == this.input.charAt(0);
        } else{
            return false;
        }
    }

}
