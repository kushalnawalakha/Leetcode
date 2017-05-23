package Easy;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * Created by kusha on 5/16/2017.
 */
public class PlusOne66 {
    public int[] plusOne(int[] digits) {
        LinkedList<Integer> linkedList=new LinkedList();
        int count=1;
        for(int i=digits.length-1;i>=0;i--){
            if(digits[i]+count>9)
                linkedList.addFirst(0);
            else
                linkedList.addFirst(digits[i]+count);
        }
        if(count==1){
            linkedList.addFirst(1);
        }
        int[] arr = linkedList.stream().mapToInt(i -> i).toArray();
        return arr;
    }

    public static void main(String[] args) {
        PlusOne66 plusOne66=new PlusOne66();
        int arr[]={1,2,3};
        System.out.print(Arrays.toString(plusOne66.plusOne(arr)));

    }
}
