package CodeFights;

/**
 * Created by kusha on 8/5/2017.
 */
public class ClimbingStairs {
    int climbingStairs(int n) {
        int nums[]=new int[n+1];
        nums[0]=0;
        nums[1]=1;
        for(int i=2;i<=n;i++){
            nums[i]=nums[i-1]+nums[i-2]+1;
        }
        return nums[n];
    }

    public static void main(String[] args) {
        ClimbingStairs climbingStairs=new ClimbingStairs();
        System.out.println(climbingStairs.climbingStairs(6));
    }
}
