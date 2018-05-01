package Medium;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kusha on 5/20/2017.
 */
public class GenerateParanthesis22 {

    public static void main(String[] args) {

        GenerateParanthesis22 g = new GenerateParanthesis22();
        System.out.println(g.generateParenthesis(3));
    }

    public void generateParenthesis(int left, int right, int max, List<String> paranthesis, String str) {
        if (left == max && right == max) {
            paranthesis.add(str);
            return;
        }

        if (left < max) {
            generateParenthesis(left + 1, right, max, paranthesis, str + "(");
        }
        if (right < left) {
            generateParenthesis(left, right + 1, max, paranthesis, str + ")");
        }
    }

    public List<String> generateParenthesis(int max) {
        List<String> list = new ArrayList<>();
        generateParenthesis(0, 0, max, list, "");
        return list;
    }
}
