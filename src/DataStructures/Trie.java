package DataStructures;

import java.util.*;

/**
 * Created by kushaln on 3/10/2018.
 */
public class Trie{
    Map<Character,Trie> map=new HashMap();
    boolean wordCompleted=false;
    public void put(String word){
        Trie current=this;
        for(char ch:word.toCharArray()){
            if(current.map.containsKey(ch)){
                current=current.map.get(ch);
            }else{
                Trie temp=new Trie();
                current.map.put(ch,temp);
                current=temp;
            }
        }
        current.wordCompleted=true;
    }

    private void get(String prefix,Trie current,List<String> output){
        if(current.wordCompleted)
            output.add(prefix);

        for(Map.Entry<Character,Trie> entry:current.map.entrySet()){
            get(prefix+entry.getKey(),entry.getValue(),output);
        }


    }

    public List<String> get(String prefix){
        Trie current=this;
        List<String> output=new ArrayList();
        for(char ch:prefix.toCharArray()){
            if(current.map.containsKey(ch)){
                current=current.map.get(ch);
            }else{
                return output;
            }
        }
        get(prefix,current,output);
        return output;
    }


    public static void main(String[] args) {
        HashMap set=new HashMap();
        Trie trie=new Trie();
        trie.put("abcd");
        trie.put("abce");
        trie.put("abcf");
        trie.put("abcde");
        System.out.println(trie.get("abcd"));

    }
}


