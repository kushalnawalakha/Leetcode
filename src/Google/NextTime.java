package Google;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kusha on 12/10/2017.
 */
public class NextTime {
    private int diffLarger=Integer.MAX_VALUE;
    private int diffSmaller=Integer.MAX_VALUE;
    private int currentMins=0;
    private String result = "";
    public String nextClosestTime(String time) {
        int[] digit = new int[4];
        String[] val = time.split(":");
        int hh = Integer.parseInt(val[0]);
        int mm = Integer.parseInt(val[1]);
        digit[0] = hh / 10;
        digit[1] = hh % 10;
        digit[2] = mm / 10;
        digit[3] = mm % 10;
        currentMins=hh*60+mm;
        dfs(new ArrayList<>(),digit,new boolean[4]);
        return result.equals("")?time:result;
    }

    void isValid(List<Integer> list){
        int hh = 10 * list.get(0)+ list.get(1);
        int mm = 10 * list.get(2)+ list.get(3);
        if (hh >= 0 && hh <= 23 && mm >= 0 && mm <= 59) {
            int c=hh*60+mm-currentMins;
            if(c>0&&c<diffLarger){
                result = validTimeInString(hh) + ":" + validTimeInString(mm);
                diffLarger=c;
            }
            if(diffLarger==Integer.MAX_VALUE&&c<0&&c<diffSmaller){
                result = validTimeInString(hh) + ":" + validTimeInString(mm);
                diffSmaller=c;
            }
        }

    }


    private void dfs(List<Integer> tempList, int [] nums, boolean used[]){
        if(tempList.size() == nums.length){
            isValid(tempList);
        } else{
            for(int i = 0; i < nums.length; i++){
                if(used[i]) continue; // element already exists, skip
                used[i]=true;
                tempList.add(nums[i]);
                dfs(tempList, nums,used);
                used[i]=false;
                tempList.remove(tempList.size() - 1);
            }
        }
    }


    public String validTimeInString(int time) {
        if (time >= 0 && time <= 9) return "0" + time;
        else return time + "";
    }

    public static void main(String sp[]){
        NextTime nextTime=new NextTime();
        System.out.println(nextTime.nextClosestTime("19:44"));
    }

}
