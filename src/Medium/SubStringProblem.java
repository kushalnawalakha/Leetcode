package Medium;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by kushal on 5/29/17.
 */
public class SubStringProblem {
    public static boolean check(String str){
        if(str.length()%2!=0||str.length()==1){
            return false;
        }
        HashMap<Character,Integer> count=new HashMap<>();
        for(char ch:str.toCharArray()){
            count.put(ch,count.getOrDefault(ch,0)+1);
        }
        for(Map.Entry<Character,Integer> ent:count.entrySet()){
            if(ent.getValue()%2!=0){
                return false;
            }
        }
        return true;

    }
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int num=scanner.nextInt();
        for(int i=0;i<num;i++){
            String str=scanner.next();
            if(check(str)){
                System.out.println(1);
            }else{
                System.out.println(-1);
            }
        }
    }
}
