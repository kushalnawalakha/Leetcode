package Hard;

import java.lang.reflect.Array;
import java.util.*;

/**
 * Created by kushal on 8/27/17.
 */
public class NQueens {

    static String[][] catalogUpdate(String[][] catalog, String[][] updates) {
        TreeMap<String,ArrayList<String>> map=new TreeMap();
        for(String update[]:updates){
            if(map.containsKey(update[0])){
                map.get(update[0]).add(update[1]);
            }else{
                ArrayList list=new ArrayList();
                list.add(update[1]);
                map.put(update[0],list);
            }
        }
        for(String cat[]:catalog){
            if(map.containsKey(cat[0])){
                ArrayList<String> list=map.get(cat[0]);
                for(int i=1;i<cat.length;i++){
                    list.add(cat[i]);
                }
            }else{
                ArrayList list=new ArrayList();
                for(int i=1;i<cat.length;i++){
                    list.add(cat[i]);
                }
                map.put(cat[0],list);
            }
        }
        String nCatlog[][]=new String[map.size()][];
        int i=0;
        for(Map.Entry<String,ArrayList<String>> e:map.entrySet()){
            nCatlog[i]=new String[e.getValue().size()+1];
            nCatlog[i][0]=e.getKey();
            int j=1;
            Collections.sort(e.getValue());
            for(String s:e.getValue()){
                nCatlog[i][j++]=s;
            }
            i++;

        }
        for(int l=0;l<nCatlog.length;l++){
            for(int z=0;z<nCatlog[l].length;z++){
                System.out.print(nCatlog[l][z]+",");
            }
            System.out.println();
        }
        return nCatlog;

    }



    static boolean b=false;
    static void wordFound(char[][] board, char []word, HashSet<String> set, int i, int j, int k){

        if(b||k==word.length){
            b=true;
            return;
        }
        if(i>=board.length||i<0||j>=board[0].length||j<0||set.contains(i+","+j)){
            return;
        }
        if(board[i][j]==word[k]){
            set.add(i+","+j);
            wordFound(board,word,set,i-1,j-1,k+1);
            wordFound(board,word,set,i-1,j  ,k+1);
            wordFound(board,word,set,i-1,j+1,k+1);
            wordFound(board,word,set,i,j-1  ,k+1);
            wordFound(board,word,set,i,j+1  ,k+1);
            wordFound(board,word,set,i+1,j-1,k+1);
            wordFound(board,word,set,i+1,j  ,k+1);
            wordFound(board,word,set,i+1,j+1,k+1);
        }
    }
    static String[] wordBoggle(char[][] board, String[] words) {
        ArrayList<String> list=new ArrayList<>();
        for(String word:words){
            b=false;
            for(int i=0;i<board.length&&!b;i++){
                for(int j=0;j<board[0].length&&!b;j++){
                    if(board[i][j]==word.charAt(0)){
                        wordFound(board,word.toCharArray(),new HashSet(),i,j,0);
                        if(b){
                            list.add(word);
                            System.out.println(word);
                        }
                    }
                }
            }
        }
        String arr[]=new String[list.size()];
        int i=0;
        for(String l:list){
            arr[i++]=l;
        }
        ArrayList<String> l=new ArrayList<>();
        String s[]=l.toArray(new String[l.size()]);
        TreeMap<String,ArrayList<String>> map=new TreeMap<>();
        return arr;
    }

    public static void main(String[] args) {
        char [][] ch={{'R','L','D'},
                {'U','O','E'},
                {'C','S','O'}};
        String words[]= {"CODE",
                "SOLO",
                "RULES",
                "COOL"};
        //wordBoggle(ch,words);
        String catalog[][]={{"Books","Classics","Fiction"},
            {"Electronics","Cell Phones","Computers","Ultimate item"},
            {"Grocery","Beverages","Snacks"},
            {"Snacks","Chocolate","Sweets"},
            {"root","Books","Electronics","Grocery"}};
        String updates[][]= {{"Snacks","Marmalade"},
            {"Fiction","Harry Potter"},
            {"root","T-shirts"},
            {"T-shirts","CodeFights"}};
        catalogUpdate(catalog,updates);
    }
}
