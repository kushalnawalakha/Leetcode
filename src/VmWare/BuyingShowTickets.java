package VmWare;

import java.util.Arrays;

/**
 * Created by kusha on 1/23/2018.
 */
public class BuyingShowTickets {
    public static long times( int[] tickets, int p) {
        long time = 0;
        int[] sub = Arrays.copyOf(tickets, tickets.length);
        for(int i = 0; i < tickets.length; i++ ) {
            sub[i] = tickets[i] - tickets[p];
        }
        int i=0;
        for(int ticket:tickets) {
            if(sub[i] < 0)
                time = ticket+time;
            else {
                if(i <= p)
                    time =time+ tickets[p];
                else
                    time =time+ tickets[p] - 1;
            }
            i++;
        }
        System.out.println(time);
        return time;
    }

    public static void main(String[] args) {
        int nums[]={2,6,3,4,5};
        times(nums,2);
    }

}
