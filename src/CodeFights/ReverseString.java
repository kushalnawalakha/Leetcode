package CodeFights;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;

/**
 * Created by kusha on 8/6/2017.
 */
public class ReverseString {
    static String reverseParentheses(String s) {
        Stack<Character> stack=new Stack<Character>();
        char[] chs=s.toCharArray();
        for(int i=0;i<chs.length;i++){
            if(chs[i]==')'||chs[i]=='}'||chs[i]==']')
            {
                Stack<Character> tstack=new Stack<>();
                while(stack.peek()!='('&&stack.peek()!='{'&&stack.peek()!='['){
                    tstack.push(stack.pop());
                }
                stack.pop();
                for(Character ch:tstack){
                    stack.push(ch);
                }
            }else{
                stack.push(chs[i]);
            }

        }
        StringBuilder b=new StringBuilder();
        for(Character ch:stack){
            b.append(ch);
        }
        return b.toString();

    }

    public static void main(String[] args) {
        String s="a(b(de)c)de";
        reverseParentheses(s);
        String str="";
        HashMap<Integer,Integer> map=new HashMap<>();

    }

}
