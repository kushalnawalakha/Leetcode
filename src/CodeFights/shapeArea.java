package CodeFights;

/**
 * Created by kusha on 8/5/2017.
 */
public class shapeArea {

    static int shapeArea(int n) {
        int prev=0;
        if(prev>n-2){
            prev=0;
        }else{
            prev=n-2;
            prev=prev*(prev+1)/2;
        }

        return (n-1)*4+1+prev*4;
    }



    public static void main(String[] args) {
        System.out.println(shapeArea(4));
    }

}
