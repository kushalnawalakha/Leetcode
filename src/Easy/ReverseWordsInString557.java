package Easy;

/**
 * Created by kusha on 5/14/2017.
 */
public class ReverseWordsInString557 {
    public String reverseWords(String s) {
        StringBuilder builder=new StringBuilder();
        String str[]=s.split(" ");
        for(String st:str){
            builder.append(new StringBuilder(st).reverse());
        }
        return builder.toString();
    }

    public static void main(String[] args) {

    }
}
