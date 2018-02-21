package Easy;

import java.util.*;

/**
 * Created by kushal on 10/22/17.
 */
class Tri{
    HashMap<Character,Tri> map=new HashMap<Character,Tri>();
    int val=0;
    public void store(String word,int val){
        HashMap<Character,Tri> tempMap=map;
        for(char ch:word.toCharArray()){
            if(tempMap.containsKey(ch)){
                tempMap.get(ch).val=tempMap.get(ch).val+val;
                tempMap=tempMap.get(ch).map;
            }else{
                Tri temp=new Tri();
                temp.val=val;
                tempMap.put(ch,temp);
                tempMap=temp.map;
            }
        }
    }
    public int getVal(String word){
        HashMap<Character,Tri> tempMap=map;
        int output=0;
        for(char ch:word.toCharArray()){
            if(tempMap.containsKey(ch)){
                output=tempMap.get(ch).val;
                tempMap=tempMap.get(ch).map;
            }else{
                return 0;
            }
        }
        return output;
    }
}

public class CSVProblem {

    Tri tri=new Tri();

    public void insert(String key, int val) {
        if(map.containsKey(key)){
            int temp=val;
            val=val-map.get(key);
            map.put(key,temp);
        }else{
            map.put(key,val);
        }
        tri.store(key,val);

    }
    HashMap<String,Integer> map=new HashMap<>();

    public int sum(String prefix) {
        return tri.getVal(prefix);
    }


    public static void main(String[] args) {
        CSVProblem s=new CSVProblem();
        s.insert("aa",3);
        System.out.println(s.sum("a"));
        s.insert("aa",2);
        System.out.println(s.sum("a"));
    }
}
