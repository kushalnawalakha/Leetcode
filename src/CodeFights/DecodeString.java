package CodeFights;

import java.util.LinkedList;
import java.util.Stack;

/**
 * Created by kusha on 8/5/2017.
 */
public class DecodeString {
    static String decodeString(String s) {
        Stack stack=new Stack<>();
        for(char ch:s.toCharArray()) {
            String current = "" + ch;
            if(current.matches("[0-9]")){
                if(!stack.isEmpty()&&stack.peek() instanceof Integer){
                    int top=(Integer) stack.pop()*10+Integer.parseInt(current);
                    stack.push(top);
                }else{
                    stack.push(Integer.parseInt(current));
                }
            }
            else if(current.equals("]")){
                StringBuilder temp=new StringBuilder();
                while (!stack.peek().toString().equals("[")){
                    temp.append(stack.pop());
                }
                stack.pop();
                if(!stack.isEmpty()&&stack.peek() instanceof Integer){
                    StringBuilder t=new StringBuilder();
                    Integer loop=(Integer) stack.pop();
                    for(int i=0;i<loop;i++){
                        t.append(temp);
                    }
                    stack.push(t.toString());
                }else{
                    stack.push(temp.toString());
                }
            }else{
                stack.push(current);
            }
        }

        StringBuilder output=new StringBuilder();
        LinkedList<String> l=new LinkedList<>(stack);
        for(String out:l){
            StringBuilder builder=new StringBuilder(out).reverse();
            output.append(builder.toString());
        }
        return output.toString();


    }

    public static void main(String[] args) {
        String string="2[ab3[cd]]4[xy]";
        System.out.println(decodeString(string));

    }

}
