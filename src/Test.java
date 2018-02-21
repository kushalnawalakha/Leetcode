/**
 * Created by kushal on 8/27/17.
 */

public class Test    {
    int checkAnagram(String s1,String s2){
        if(s1.length()!=s2.length()){
            return -1;
        }
        char[] values=new char[26];
        for(char ch:s1.toCharArray()){
            values[ch-'a']++;
        }
        for(char ch:s2.toCharArray()){
            values[ch-'a']++;
        }
        int s=0;
        for(int i=0;i<values.length;i++){
            s+=values[i]<0?values[i]:0;
        }
        return -s;
    }
    public static void main(String sp[]){

    }
}
