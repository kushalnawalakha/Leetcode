package Hard;

/**
 * Created by kusha on 3/18/2018.
 */
public class OrderMinWindow {
    public static void main(String[] args) {
        OrderMinWindow o = new OrderMinWindow();
        o.minWindow("fgrqsqsnodwmxzkzxwqegkndaa1", "1");
    }

    public String minWindow(String S, String T) {
        int dp[][] = new int[T.length() + 1][S.length() + 1];

        for (int j = 0; j <= S.length(); j++) {
            dp[0][j] = j + 1; //dealing with first char
        }

        for (int i = 1; i <= T.length(); i++) {
            for (int j = 1; j <= S.length(); j++) {
                if (T.charAt(i - 1) == S.charAt(j - 1))
                    dp[i][j] = dp[i - 1][j - 1];
                else
                    dp[i][j] = dp[i][j - 1];
            }
        }
        int len = S.length(), start = -1;

        for (int i = 0; i <= S.length(); i++) {
            if (dp[T.length()][i] != 0) {
                if (i - dp[T.length()][i] + 1 < len) {
                    start = dp[T.length()][i] - 1;
                    len = i - dp[T.length()][i] + 1;
                }
            }
        }
        return start == -1 ? "" : S.substring(start, start + len);

    }
}
