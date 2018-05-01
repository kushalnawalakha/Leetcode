package Medium;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/**
 * Created by kushaln on 3/15/2018.
 */
public class CrackingTheSafe {
    Set<String> seen;
    StringBuilder ans;

    public String crackSafe(int n, int k) {
        if (n == 1 && k == 1) return "0";
        seen = new HashSet();
        ans = new StringBuilder();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n-1; ++i)
            sb.append("0");
        String start = sb.toString();

        dfs(start, k);
        ans.append(start);
        return new String(ans);
    }

    public void dfs(String node, int k) {
            for (int x = 0; x < k; ++x) {
            String nei = node + x;
            if (!seen.contains(nei)) {
                seen.add(nei);
                dfs(nei.substring(1), k);
                System.out.println(node+" "+x);
                ans.append(x);
            }
        }
    }

    public static void main(String[] args) {

        CrackingTheSafe c=new CrackingTheSafe();
        System.out.println(c.crackSafe(3,3));
    }
}

