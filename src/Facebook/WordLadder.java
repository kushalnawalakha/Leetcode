package Facebook;

import java.lang.reflect.Array;
import java.util.*;

/**
 * Created by kusha on 1/28/2018.
 */
public class WordLadder {
    public boolean isSimilar(char word1[],char[] word2){
        boolean setPtr=true;
        for(int i=0;i<word1.length;i++){
            if(word1[i]!=word2[i]){
                if(setPtr)
                    setPtr=false;
                else
                    return false;
            }
        }
        if (!setPtr)
            return true;
        return false;
    }

    public HashSet<String> getSimilar(String currentWord,HashSet<String> unused){
        HashSet<String> set=new HashSet<>();
        for(String word:unused){
            if(isSimilar(currentWord.toCharArray(),word.toCharArray())){
                set.add(word);
            }
        }
        return set;
    }


    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> wordSet=new HashSet<>(wordList);
        wordSet.add(beginWord);
        Queue<String> queue=new LinkedList();
        queue.add(beginWord);
        int currentLevel=1;
        int prevElements=1;
        int currentElements=0;
        while (!queue.isEmpty()){
            currentElements=0;
            for(int i=0;i<prevElements;i++){
                HashSet<String> similar=getSimilar(queue.poll(),wordSet);
                currentElements=currentElements+similar.size();
                wordSet.removeAll(similar);
                if(similar.contains(endWord)){
                    return currentLevel+1;
                }
                queue.addAll(similar);
            }
            prevElements=currentElements;
            currentLevel++;
        }
        return 0;
    }

    public static void main(String[] args) {
        String list[]={"hot","dot","dog","lot","log","cog"};
        WordLadder ladder=new WordLadder();
        System.out.println(ladder.ladderLength("hit","cog", Arrays.asList(list)));
    }
}
