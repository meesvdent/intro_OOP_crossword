package console.squares;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class BlueSquare extends WhiteSquare{

    private final char hint;
    private char[] options;

    public BlueSquare(char hint){
        super("blue", "H");
        this.hint = hint;
        this.initHint(5);
    }

    public char getHint(){
        return this.hint;
    }

    private void setOptions(char[] options){
        this.options = options;
    }

    public char[] getOptions(){
        return this.options;
    }

    private void initHint(int n){
        // function which initializes the options array, which holds n unique characters of which n-1 random characters and the hint

        if(n< 3 || n>25){
            throw new IllegalArgumentException("Number of random characters in the hint must be between 2 and 26.");
        }

        // initialize arrays
        // initialize array which will hold 4 random integers between 0 and 26 which will be converted to char
        ArrayList<Integer> optionsInt = new ArrayList<>();
        // array which will hold the 4 random characters and the hint at a random location
        char[] optionCharacters = new char[n];
        // initialize random
        Random r = new Random();

        // place the hint at a random location in the array (only relevant for console version)
        int hintLocation = r.nextInt(n);
        optionCharacters[hintLocation] = this.getHint();

        // create list of ints representing every letter in the alphabet except the hint.
        for(int i = 0; i < 26; i++){
            if(i != (this.hint - 'A')){
                optionsInt.add(i);
            }
        }

        // randomly choose a letter from the remaining letters of the alphabet and fill the optionCharacters array
        // remove this letter from the alphabet, so every letter can only be chosen once
        for(int j=0; j<n; j++){
            if(j != hintLocation){
                int k = r.nextInt(optionsInt.size());
                char curChar = (char) (optionsInt.get(k) + 'A');
                optionCharacters[j] = curChar;
                optionsInt.remove(k);
            }
        }

        // use setter function to set options
        this.setOptions(optionCharacters);
    }
}
