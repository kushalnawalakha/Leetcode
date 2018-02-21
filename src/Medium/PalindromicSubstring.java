package Medium;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * Created by kushal on 8/26/17.
 */
public class PalindromicSubstring {
        public int countSubstrings(String s) {
            boolean[][] substringset= new boolean[s.length()][s.length()];
            char ch[]=s.toCharArray();
            int count=0;

            for(int i=0;i<substringset.length;i++){
                Arrays.fill(substringset[i],false);
                substringset[i][i]=true;
                count++;
            }
            for(int j=1;j<s.length();j++){
                for(int i=0;i<s.length()-j;i++){
                    if(ch[i]==ch[i+j]&&(j==1||substringset[i+1][i+j-1])){
                        substringset[i][i+j]=true;
                        count++;
                    }
                }

            }
            return count;
        }

    public String longestPalindrome(String s) {
        if(s==null||s.length()==0){
            return "";
        }
        boolean dp[][]=new boolean[s.length()][s.length()];

        for(int i=0;i<s.length();i++){
            dp[i][i]=true;
        }
        int max=0;
        String maxString=""+s.charAt(0);
        for(int i=1;i<s.length();i++){
            for(int j=0;j<s.length()-i;j++){
                if(s.charAt(j)==s.charAt(i+j)&&(i==1||dp[j+1][j+i-1])){
                    dp[j][i+j]=true;
                    if(max<i) {
                        max = i;
                        maxString = s.substring(j, j + i + 1);
                    }
                }
            }
        }
        return maxString;
    }

    public static void main(String[] args) {
        PalindromicSubstring palindromicSubstring=new PalindromicSubstring();
        String out=palindromicSubstring.longestPalindrome("babad");
        System.out.println(out);
    }
}
