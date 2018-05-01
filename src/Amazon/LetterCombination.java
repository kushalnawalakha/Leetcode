package Amazon;

import java.util.ArrayList;
import java.util.List;

public class LetterCombination {
    String[] chars=new String[10];
    public void init(){
        chars[0]=" ";
        chars[1]="";
        chars[2]="abc";
        chars[3]="def";
        chars[4]="ghi";
        chars[5]="jkl";
        chars[6]="mno";
        chars[7]="pqrs";
        chars[8]="tuv";
        chars[9]="wxyz";
    }

    public char[] getAssociatedChars(char num){
        return chars[num-'0'].toCharArray();
    }

    public void helper(String digits,List<String> list,String currentString,int current){

        if(currentString.length()==digits.length()){
            list.add(currentString);
            return;
        }
        for(int i=current;i<digits.length();i++){
            for(char ch:getAssociatedChars(digits.charAt(i))){
                helper(digits,list,currentString+ch,i+1);
            }
        }

    }
    public List<String> letterCombinations(String digits) {
        init();
        List<String> list=new ArrayList<>();
        if(digits.length()>0){
            helper(digits,list,"",0);
        }
        return list;
    }

    public static void main(String s[]){
        LetterCombination letterCombination=new LetterCombination();
        letterCombination.letterCombinations("23");
    }
}
