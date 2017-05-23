package Easy;

/**
 * Created by kusha on 5/16/2017.
 */
public class ClimbingStairs70 {
    public int climbStairs(int n) {
        int steps[]=new int[n+1];
        steps[0]=1;
        steps[1]=1;
        for(int i=2;i<steps.length;i++){
            steps[i]=steps[i-1]+steps[i-2];
        }
        return steps[n];
    }
    public static void main(String[] args) {
        ClimbingStairs70 obj=new ClimbingStairs70();
        System.out.print(obj.climbStairs(3));
    }
}
