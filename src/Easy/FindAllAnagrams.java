package Easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by kushal on 10/17/17.
 */
public class FindAllAnagrams {
    private static boolean check(int array[],HashMap<Character,Integer> map){
        for(Map.Entry<Character,Integer> entry:map.entrySet()){
            if(array[entry.getKey()-'a']!=entry.getValue()){
                return false;
            }
        }
        return true;
    }
    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> list=new ArrayList<Integer>();
        if(s.length()==0||p.length()==0||p.length()>s.length()){
            return list;
        }
        HashMap<Character,Integer> map=new HashMap<>();
        for(char ch:p.toCharArray()){
            map.put(ch,map.getOrDefault(ch,0)+1);
        }
        int array[]=new int[26];
        for(int i=0;i<p.length();i++){
            array[s.charAt(i)-'a']++;
        }
        if(check(array,map)){
            list.add(0);
        }
        for(int i=1;i<=s.length()-p.length();i++){
            array[s.charAt(i-1)-'a']--;
            array[s.charAt(i+p.length()-1)-'a']++;
            if(check(array,map)){
                list.add(i);
            }
        }
        return list;
    }

    public static void main(String[] args) {
        System.out.print(findAnagrams("abab","ab"));
    }
}
