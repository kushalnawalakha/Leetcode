package VmWare;

import java.util.ArrayList;

public class MissingWords {
    static String[] missingWords(String s, String t) {
        String s_split[]=s.split(" ");
        String t_split[]=t.split(" ");
        ArrayList<String> list=new ArrayList();
        int i=0,j=0;
        for(;i<s_split.length;i++){
            if(j>=t_split.length){
                break;
            }

            if(s_split[i].equals(t_split[j])){
                j++;
            }else{
                list.add(s_split[i]);
            }
        }

        for(;i<s_split.length;i++){
            list.add(s_split[i]);
        }

        return list.toArray(new String[list.size()]);

    }

    public static void main(String[] args) {
        String string1="I am using hackerrank to improve programming";
        String string2="am hackerrank to improve";
        missingWords(string1,string2);
    }
}
