package console.squares;

public class GreySquare extends WhiteSquare {

    public GreySquare(){
        super("grey", "S");
    }

    public Character[] getOptions(){
        System.out.println("options");
        System.out.println("options: " + this.options);
        int nOptions = this.options.length;
        Character[] characterOptions = new Character[nOptions];
        int i = 0;
        for(char option : this.options){
            characterOptions[i] = option;
            i++;
        }
        return characterOptions;
    }

}
