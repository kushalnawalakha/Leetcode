package Easy;

/**
 * Created by kushal on 10/7/17.
 */
public class AlternatingBits {
    public static boolean hasAlternatingBits1(int n) {
        boolean bit=!((n&1)==1);
        while(n!=0){
            if(bit&&((n&1)==0)){
                bit=false;
            }else if(!bit&&((n&1)==1)){
                bit=true;
            }else{
                return false;
            }
            n=n>>1;
        }
        return true;
    }

    public static boolean hasAlternatingBits(int n) {
        String bits=Integer.toBinaryString(n);
        boolean prev= bits.charAt(0)=='0';
        prev=!prev;
        for(char bit:bits.toCharArray()){
            if(prev==(bit=='0')){
                return false;
            }
            prev=(bit=='0');
        }
        return true;
    }

    public static void main(String[] args) {
        hasAlternatingBits1(5);
    }

}
