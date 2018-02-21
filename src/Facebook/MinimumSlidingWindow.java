package Facebook;

import java.util.*;

/**
 * Created by kusha on 2/4/2018.
 */
public class MinimumSlidingWindow {

    public String minWindow(String s, String t) {
        int map[]=new int[128];
        for(char c: t.toCharArray())
            map[c]++;
        int counter=t.length(), begin=0, end=0, d=Integer.MAX_VALUE, head=0;
        while(end<s.length()){
            if(map[s.charAt(end++)]-->0)
                counter--; //in t
            while(counter==0){ //valid
                if(end-begin<d)
                    d=end-(head=begin);
                if(map[s.charAt(begin++)]++==0)
                    counter++;  //make it invalid
            }
        }
        return d==Integer.MAX_VALUE? "":s.substring(d, head);
    }

    public static void main(String[] args) {
        String s[]=new String[10];
        ;

         MinimumSlidingWindow m=new MinimumSlidingWindow();
        m.minWindow("adeqacbedabd","ab");
    }
}
