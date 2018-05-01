package Easy;

/**
 * Created by kusha on 11/2/2017.
 */
public class ValidPalindrome {

    public boolean validPalindrome(String s,int start,int end){
        while(start<end){
            if(s.charAt(start)==s.charAt(end)){
                start++;
                end--;
            }
            else{
                return false;
            }
        }
        return true;
    }

    public boolean validPalindrome(String s) {
        int end=s.length()-1,start=0;
        while(start<end){
            if(s.charAt(start)==s.charAt(end)){
                start++;
                end--;
            }
            else{
                return validPalindrome(s,start+1,end)||validPalindrome(s,start,end-1);
            }
        }
        return true;
    }

    public static void main(String[] args) {
        ValidPalindrome palindrome=new ValidPalindrome();
        System.out.println(palindrome.validPalindrome("aguokepatgbnvfqmgmlcupuufxoohdfpgjdmysgvhmvffcnqxjjxqncffvmhvgsymdjgpfdhooxfuupuculmgmqfvnbgtapekouga"));
    }
}
