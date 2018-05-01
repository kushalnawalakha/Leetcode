package Medium;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by kushaln on 3/15/2018.
 */
public class flipGame {
    public boolean canWin(String s) {
        if(s == null || s.length() < 2) return false;
        Map<String, Boolean> map = new HashMap<>();
        boolean b=canWin(s,map);
        System.out.println(map);
        return b;
    }

    public boolean canWin(String s, Map<String, Boolean> map){
        if(map.containsKey(s)) return map.get(s);
        for(int i = 0; i < s.length() - 1; i++) {
            if(s.charAt(i) == '+' && s.charAt(i + 1) == '+') {
                String opponent = s.substring(0, i) + "--" + s.substring(i + 2);
                if(!canWin(opponent, map)) {
                    map.put(s, true);
                    return true;
                }
            }
        }
        map.put(s, false);
        return false;
    }


    public static void main(String[] args) {
        String s="+++++";
        StringBuilder builde=new StringBuilder();
        flipGame g=new flipGame();
        System.out.println(g.canWin(s));
    }
}
