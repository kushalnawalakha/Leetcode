package HackerRank.DynamicProgramming;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by kusha on 8/10/2017.
 */
public class Abrevation {
    static HashMap<String,String> map;
    static String out="NO";
    static String abbreviation(String a, String b) {
        if(b.length()>a.length()){
            return "NO";
        }
        if(b.length()==0||out.equals("YES")){
            out="YES";
            return "YES";
        }
        if(map.containsKey(a)&&map.get(a).equals(b)){
            return "NO";
        }

        if(a.charAt(0)==b.charAt(0)){
            String output=abbreviation(a.substring(1),b.substring(1));
            map.put(a,b);
            return output;
        }else if((char)(a.charAt(0)-32)==b.charAt(0)){
            String output;
            output=abbreviation(a.substring(1),b);
            map.put(a,b);
            if(output.equals("NO")){
                output= abbreviation(a.substring(1),b.substring(1));
                map.put(a,b);
            }
            return output;
        }else{
            if((""+a.charAt(0)).matches("[A-Z]")){
                return "NO";
            }
            String output=abbreviation(a.substring(1),b);
            map.put(a,b);
            return output;
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int q = in.nextInt();
        for(int a0 = 0; a0 < q; a0++){
            String a = in.next();
            String b = in.next();
            StringBuilder buildera=new StringBuilder(a);
            StringBuilder builderb=new StringBuilder(b);
            out="NO";
            map=new HashMap<String,String>();
            String result = abbreviation(buildera.reverse().toString(), builderb.reverse().toString());
            System.out.println(result);
        }
        in.close();
    }


}
