package Medium;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kusha on 2/19/2018.
 */
public class GrayCode {
    public List<Integer> grayCode(int n) {
        List<Integer> rs=new ArrayList<Integer>();
        rs.add(0);
        for(int i=0;i<n;i++){
            int size=rs.size();
            for(int k=size-1;k>=0;k--)
                rs.add(rs.get(k) | 1<<i);
        }
        return rs;
    }

    public static void main(String[] args) {
        GrayCode code=new GrayCode();
        code.grayCode(4);
    }

}
