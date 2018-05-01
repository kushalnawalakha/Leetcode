package Easy;

import java.util.*;

/**
 * Created by kushal on 10/16/17.
 */
public class AddStrings {
    public static String addStrings(String num1, String num2) {
        int i=num1.length()-1;
        int j=num2.length()-1;
        StringBuilder output=new StringBuilder();
        int carry=0;
        for(;i>=0&&j>=0;i--,j--){
            int temp=num1.charAt(i)+num2.charAt(j)-(2*'0')+carry;
            carry=temp/10;
            output.append(temp%10);
        }
        for(;i>=0;i--){
            int temp=num1.charAt(i)-'0'+carry;
            carry=temp/10;
            output.append(temp%10);
        }
        for(;j>=0;j--){
            int temp=num2.charAt(j)-'0'+carry;
            carry=temp/10;
            output.append(temp%10);
        }
        if(carry==1){
            output.append("1");
        }
        return output.reverse().toString();
    }


    public static void main(String[] args) {

        String s1="99";
        String s2="9";
        addStrings(s1,s2);
    }

}

interface x{

}