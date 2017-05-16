package Easy;

import sun.misc.Regexp;

/**
 * Created by kusha on 5/14/2017.
 */
public class DetectCapital520 {
    public boolean detectCapitalUse(String word) {
        if(word.matches("^[A-Z]*$")){
            return true;
        }
        if(word.matches("^([A-Z]{1}[a-z]*)$")){
            return true;
        }
        if(word.matches("^[a-z]*$")){
            return true;
        }
        return false;
    }
    public static void main(String[] args) {
        DetectCapital520 detectCapital520=new DetectCapital520();
        System.out.print(detectCapital520.detectCapitalUse("HHELLO"));

    }
}
