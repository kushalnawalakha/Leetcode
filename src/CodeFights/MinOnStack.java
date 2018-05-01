package CodeFights;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by kusha on 8/5/2017.
 */
public class MinOnStack {
    static int[] minimumOnStack(String[] operations) {
        Stack<Integer> minStack=new Stack<>();
        Stack<Integer> all=new Stack<>();
        ArrayList<Integer> li=new ArrayList<>();
        for(String str:operations){
            if(str.startsWith("push")){
                int currentNum=Integer.parseInt(str.split(" ")[1]);
                if(minStack.isEmpty()||minStack.peek()>currentNum){
                    minStack.push(currentNum);
                }
                all.push(currentNum);
            }

            else if(str.startsWith("pop")){
                if(minStack.peek()==all.peek()){
                    minStack.pop();
                }
                all.pop();
            }

            else if(str.startsWith("min")){
                li.add(minStack.peek());
            }

        }
        int []out=new int[li.size()];
        int i=0;
        for(Integer o:li){
            out[i++]=o;
        }
        return out;

    }

    public static void main(String[] args) {
        String array[]={"push 10","min",
                "push 5",
                "min",
                "push 8",
                "min",
                "pop",
                "min",
                "pop",
                "min"};
        minimumOnStack(array);
    }

}
