package Amazon;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Stack;

/**
 * Created by kushal on 10/24/17.
 */
public class ValidParentheses {
    public boolean isValid(String s) {
        Stack<Character> stack=new Stack<>();
        HashSet<Character> openMap=new HashSet<>();
        openMap.add('(');
        openMap.add('{');
        openMap.add('[');
        HashMap<Character,Character> closeMap=new HashMap<>();
        closeMap.put(')','(');
        closeMap.put('}','{');
        closeMap.put(']','[');
        for(char ch:s.toCharArray()){
            if(openMap.contains(ch)){
                stack.add(ch);
            }else{
                if(stack.size()==0){
                    return false;
                }
                if(stack.peek()!=closeMap.get(ch)){
                    return false;
                }else{
                    stack.pop();
                }
            }
        }
        if(stack.size()==0)
        return true;
        return false;
    }

    public static void main(String[] args) {
        String out="()";
        ValidParentheses validParentheses=new ValidParentheses();
        System.out.println(validParentheses.isValid(out));
    }
}
