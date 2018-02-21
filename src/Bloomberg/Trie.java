package Bloomberg;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

class Trie {
    HashMap<Character,Trie> map;
    boolean isEnd=false;
    /** Initialize your data structure here. */
    public Trie() {
        map=new HashMap<Character,Trie>();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        HashMap<Character,Trie> temp=map;
        int i=0;
        for(Character c:word.toCharArray()){
            if(temp.containsKey(c)){
                if(i==word.length()-1){
                    temp.get(c).isEnd=true;
                }
                temp=temp.get(c).map;

            }else{
                Trie newTrie=new Trie();
                temp.put(c,newTrie);
                if(i==word.length()-1){
                    newTrie.isEnd=true;
                }
                temp=newTrie.map;
            }
            i++;
        }

    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        HashMap<Character,Trie> temp=map;
        HashMap<Character,Trie> prev=null;
        for(Character c:word.toCharArray()){
            if(temp.containsKey(c)){
                prev=temp;
                temp=temp.get(c).map;
            }else{
                return false;
            }
        }
        if(prev==null){
            return false;
        }
        return prev.get(word.charAt(word.length()-1)).isEnd;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String word) {
        HashMap<Character,Trie> temp=map;
        for(Character c:word.toCharArray()){
            if(temp.containsKey(c)){
                temp=temp.get(c).map;
            }else{
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {


        Trie trie=new Trie();
        trie.insert("ab");
        trie.search("a");
        trie.search("ab");
    }
}
