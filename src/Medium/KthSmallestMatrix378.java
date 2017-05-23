package Medium;

import java.util.PriorityQueue;
import java.util.Stack;

/**
 * Created by kusha on 5/20/2017.
 */
public class KthSmallestMatrix378 {
    public int kthSmallest(int[][] matrix, int k) {
        Stack<Integer[]> stack=new Stack<>();
        int currentr=0;
        int currentc=0;
        for(int i=0;i<k;i++){
            Integer st[]=stack.pop();
            if(matrix[currentr+1][currentc]<matrix[st[0]][st[1]]){
                Integer loc[]=new Integer[2];
                loc[0]=currentr;
                loc[1]=currentc+1;
                stack.push(loc);
                currentr=currentr+1;
            }

        }
        return 0;
    }
    public static void main(String[] args) {

    }
}
