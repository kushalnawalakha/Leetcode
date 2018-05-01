package Medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LongestSubstringWithK {
    int max=0;
    private int helper(String s,int start,int end,int count[],int k){
        if(start>end){
            return -1;
        }
        int right=-1,left=-1;
        count[s.charAt(start)-'a']--;
        helper(s,start+1,end,count,k);
        count[s.charAt(start)-'a']++;
        boolean b=false;
        for(int i=0;i<count.length;i++){
            if(count[i]!=0&&count[i]<k){
                b=true;
                break;
            }
        }
        if(!b){
            right=end-start;
        }

        count[s.charAt(end)-'a']--;
        helper(s,start,end-1,count,k);
        count[s.charAt(end)-'a']++;
        b=false;
        for(int i=0;i<count.length;i++){
            if(count[i]!=0&&count[i]<k){
                b=true;
                break;
            }
        }
        if(!b){
            right=end-start;
        }

        max= Math.max(max,right);
        max=Math.max(max,left);
        return max;
    }

    public int longestSubstring(String s, int k) {
        int max=0;
        int count[]=new int[26];
        for(int i=0;i<s.length();i++){
            count[s.charAt(i)-'a']++;
        }
        helper(s,0,s.length()-1,count,k);
        return max+1;
    }

    public static void main(String[] args) {
        String s="aaabb";
        LongestSubstringWithK k=new LongestSubstringWithK();
        System.out.println(k.longestSubstring(s,3));
    }

}
