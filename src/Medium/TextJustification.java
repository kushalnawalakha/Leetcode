package Medium;

import java.util.ArrayList;
import java.util.List;

public class TextJustification {
    public List<String> fullJustify(String[] words, int maxWidth) {
        int costMatrix[][]=new int[words.length][words.length];
        int wordLength[]=new int[words.length+1];
        for(int i=1;i<=words.length;i++){
            wordLength[i]=wordLength[i-1]+words[i-1].length();
        }
        for(int i=0;i<words.length;i++){
            for(int j=i;j<words.length;j++){
                if(wordLength[j+1]-wordLength[i]+(j-i)<=maxWidth){
                    costMatrix[i][j]=(10-(wordLength[j+1]-wordLength[i]+(j-i)))*(10-(wordLength[j+1]-wordLength[i]+(j-i)));
                }else{
                    costMatrix[i][j]=Integer.MAX_VALUE;
                }
            }
        }

        int numberOfchars[]=new int[words.length+1];
        int split[]=new int[words.length];
        split[words.length-1]=words.length;
        numberOfchars[words.length]=0;

        for(int i=words.length-1;i>=0;i--){
            int j=words.length-1;
            while (costMatrix[i][j]==Integer.MAX_VALUE){
                j--;
            }
            numberOfchars[i]=costMatrix[i][j]+numberOfchars[j+1];
            split[i]=j+1;
            while (i<=j){
                if(numberOfchars[i]>costMatrix[i][j]+numberOfchars[j+1]){
                    numberOfchars[i]=costMatrix[i][j]+numberOfchars[j+1];
                    split[i]=j+1;
                }
                j--;

            }
        }
        int prev=0;
        ArrayList<String> arrayList=new ArrayList<>();
        for(int i=0;i<words.length;i=split[i]){
            StringBuilder stringBuilder=new StringBuilder();
            for(int j=prev;j<split[i];j++){
                stringBuilder.append(words[j]+" ");
            }
            stringBuilder.trimToSize();
            for(int j=stringBuilder.length();j<maxWidth;j++){
                stringBuilder.append(" ");
            }
            prev=split[i];
            arrayList.add(stringBuilder.toString());
        }

        return arrayList;
    }
    public static void main(String[] args) {
        String words[]={"tushar","roy","likes","to","code"};
        TextJustification textJustification=new TextJustification();
        System.out.println(textJustification.fullJustify(words,10));
    }
}
