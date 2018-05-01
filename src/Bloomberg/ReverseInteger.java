package Bloomberg;

public class ReverseInteger {
    private int getInt(StringBuilder str){
        long num=Long.parseLong(str.reverse().toString());
        if(num>Integer.MAX_VALUE){
            return 0;
        }
        return (int)num;
    }
    public int reverse(int x) {
        long temp=x;
        if(temp<0){
            StringBuilder str=new StringBuilder(""+(-temp));
            return -getInt(str);
        }else{
            StringBuilder str=new StringBuilder(""+temp);
            return getInt(str);
        }


    }

    public static void main(String[] args) {
        ReverseInteger reverseInteger=new ReverseInteger();
        reverseInteger.reverse(-2147483648);
    }
}
