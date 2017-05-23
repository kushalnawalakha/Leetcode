package Medium;

import java.util.List;

/**
 * Created by kusha on 5/20/2017.
 */
public class GenerateParanthesis22 {

    public void generateParenthesis(int left,int right,List<String> paranthesis,String str) {
        if(left>right){
            return ;
        }
        if(left==0&&right==0){
            paranthesis.add(str);
        }

        if(left>0){
            generateParenthesis(left+1,right,paranthesis,str+"(");
        }
        if(right>0){
            generateParenthesis(left,right+1,paranthesis,str+") ");
        }

    }
    public static void main(String[] args) {

    }
}
