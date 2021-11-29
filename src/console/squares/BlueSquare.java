package console.squares;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class BlueSquare extends WhiteSquare{

    private final String hint;
    private String[] options;

    public BlueSquare(String hint){
        super("blue", "H");
        this.hint = hint;
        this.initHint(5);
    }

    public String getHint(){
        return this.hint;
    }

    private void setOptions(String[] options){
        this.options = options;
    }

    public String[] getOptions(){
        return this.options;
    }

    private void initHint(int n){
        ArrayList<Integer> optionsInt = new ArrayList<>();
        String[] optionsString = new String[n];
        Random r = new Random();
        int hintLocation = r.nextInt(n);
        optionsString[hintLocation] = this.getHint();
        for(int i = 0; i < 26; i++){
            if(i != (this.hint.charAt(0) - 'A')){
                optionsInt.add(i);
            }
        }
        for(int j=0; j<n; j++){
            if(j != hintLocation){
                int k = r.nextInt(optionsInt.size());
                char curChar = (char) (optionsInt.get(k) + 'A');
                optionsString[j] = String.valueOf(curChar);
                optionsInt.remove(k);
            }
        }
        this.setOptions(optionsString);
        System.out.println(Arrays.toString(this.getOptions()));
    }
}
