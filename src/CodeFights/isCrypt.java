package CodeFights;

import java.util.HashMap;

/**
 * Created by kusha on 7/24/2017.
 */
public class isCrypt {
    boolean isCryptSolution(String[] crypt, char[][] solution) {
        int max=crypt[0].length()>crypt[1].length()?crypt[0].length():crypt[1].length();
        int min=crypt[0].length()<crypt[1].length()?crypt[0].length():crypt[1].length();

        HashMap<Character,Integer> map=new HashMap<>();

        for(char ch[]:solution){
            map.put(ch[0],Integer.parseInt(""+ch[1]));
        }

        if(max>crypt[2].length()||max+1<crypt[2].length()){
            return false;
        }
        int carry=0,i=0;
        for(;i<min;i++){
            int outcome=map.get(crypt[0].charAt(i))+map.get(crypt[1].charAt(i))+carry;
            int current=outcome%10;
            carry=outcome/10;
            if(current!=map.get(crypt[2].charAt(i))){
                return false;
            }
        }

        for(;i<crypt[0].length();i++){
            int outcome=map.get(crypt[0].charAt(i))+carry;
            int current=outcome%10;
            carry=outcome/10;
            if(current!=map.get(crypt[2].charAt(i))){
                return false;
            }
        }

        for(;i<crypt[1].length();i++){
            int outcome=map.get(crypt[1].charAt(i))+carry;
            int current=outcome%10;
            carry=outcome/10;
            if(current!=map.get(crypt[2].charAt(i))){
                return false;
            }
        }

        if(i!=crypt[2].length()){
            if(carry!=map.get(crypt[2].charAt(i))){
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        String str[]={"SEND","MORE","MONEY"};
        char [][]ch={{'O','0'},
                {'M','1'},
                {'Y','2'},
                {'E','5'},
                {'N','6'},
                {'D','7'},
                {'R','8'},
                {'S','9'}};
        isCrypt isCrypt=new isCrypt();
        isCrypt.isCryptSolution(str,ch);
    }
}
