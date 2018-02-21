package CodeFights;

import java.util.LinkedList;
import java.util.Stack;

/**
 * Created by kusha on 8/5/2017.
 */
public class SimplifyPath {
    static String simplifyPath(String path) {
        String strs[]=path.split("/");
        Stack<String> stk=new Stack<String>();

        for(String str:strs){
            if(str.equals(".")||str.trim().equals("")){
                continue;
            }
            else if(str.equals("..")){
                if(stk.empty()){
                    continue;
                }
                stk.pop();
            }
            else{
                stk.push(str);
            }

        }
        StringBuilder output=new StringBuilder();
        LinkedList<String> l=new LinkedList<>(stk);
        for(String s:l){
            output.append("/"+s);
        }
        if(output.toString().trim().equals("")){
            return "/";
        }

        return output.toString();

    }

    public static void main(String[] args) {
        String str="/../";
        System.out.println(simplifyPath(str));
    }

}
