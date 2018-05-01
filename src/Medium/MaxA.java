package Medium;

/**
 * Created by kusha on 2/19/2018.
 */
public class MaxA {
    public int maxA(int n){
        int[] dp = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            dp[i] = i;
            for (int j = 1; j <= i - 3; j++)
                dp[i] = Math.max(dp[i], dp[j] * (i - j - 1));
        }
        return dp[n];
    }

    public static void main(String[] args) {
        int foo = Integer.parseInt("1001", 2);
        MaxA maxA=new MaxA();
        maxA.maxA(10);
    }
}
