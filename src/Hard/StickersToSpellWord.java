package Hard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/**
 * Created by kushal on 10/7/17.
 */
public class StickersToSpellWord {

    public boolean getBest(int arr1[][],int arr2[]){
        int max=0;
        int best=-1;
        for(int i=0;i<arr1.length;i++){
            int current=0;
            for(int j=0;j<26;j++){
                if(arr2[j]!=0&&arr1[i][j]!=0){
                    int temp=arr2[j]-arr1[i][j];
                    current=current+(temp>0?temp:arr2[j]);
                }
            }
            if(max<current){
                max=current;
                best=i;
            }
        }
        if(best==-1){
            return false;
        }
        for(int j=0;j<26;j++){
            if(arr2[j]!=0){
                int temp=arr2[j]-arr1[best][j];
                arr2[j]=temp>=0?temp:0;
            }
        }
        return true;
    }

    public int minStickers(String[] stickers, String target) {
        int array[][]=new int[stickers.length][26];
        int targetArray[]=new int[26];
        int i=0;
        for(String sticker:stickers){
            for(char ch:sticker.toCharArray()){
                array[i][ch-'a']++;
            }
            i++;
        }
        for(char ch:target.toCharArray()){
            targetArray[ch-'a']++;
        }
        int count=0;
        while (getBest(array,targetArray)){
            count++;
        }

        for(int j=0;j<26;j++){
            if(targetArray[j]!=0){
                return -1;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        String s[]={"these","guess","about","garden","him"};
        StickersToSpellWord st=new StickersToSpellWord();
        System.out.print(st.minStickers(s,"atomher"));
    }
}
