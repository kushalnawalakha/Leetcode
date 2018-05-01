package Bloomberg;

import java.util.HashMap;

public class LengthOfLongestSubString {
    public int lengthOfLongestSubstring(String s) {
        if(s==null||s.length()==0){
            return 0;
        }
        HashMap<Character,Integer> locationMap=new HashMap<Character,Integer>();
        int max=1,started=0;
        int i=1;
        for(char ch:s.toCharArray()){
            if(locationMap.containsKey(ch)&&locationMap.get(ch)>=started){
                started=locationMap.get(ch)+1;
                locationMap.put(ch,i-1);
            }else{
                max=Math.max(max,i-started);
                locationMap.put(ch,i-1);
            }
            i++;
        }
        return max;
    }

    public static void main(String[] args) {
        LengthOfLongestSubString l=new LengthOfLongestSubString();
        System.out.println(l.lengthOfLongestSubstring("aaaaaaa"));
    }
}
