package Amazon;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class WordBreak{
        public boolean wordBreak(String s, Set<String> dict) {

            boolean[] f = new boolean[s.length() + 1];

            f[0] = true;

            for(int i=1; i <= s.length(); i++){
                for(int j=0; j < i; j++){
                    if(f[j] && dict.contains(s.substring(j, i))){
                        f[i] = true;
                        break;
                    }
                }
            }

                return f[s.length()];
        }

    public static void main(String[] args) {
        HashSet<String> hashSet=new HashSet<>();
        hashSet.add("leet");
        hashSet.add("code");
        WordBreak wordBreak=new WordBreak();
        wordBreak.wordBreak("leetcode",hashSet);
        ArrayList list=new ArrayList();

    }
}
