package Medium;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by kushaln on 3/13/2018.
 */
public class FindEvent {
    public static int[] findNearest(int x, int y, List<int[]> events){
        int output[]=new int[3];
        output[2]=Integer.MAX_VALUE;
        int loc=-1,i=0;
        for(int[] event:events){
            int distance=Math.abs(x-event[1])+Math.abs(y-event[2]);
            if(distance<output[2]){
                loc=i;
                output[0]=event[0];
                output[1]=event[3];
                output[2]=distance;
            }else if(distance==output[2]&&event[3]<output[1]){
                loc=i;
                output[0]=event[0];
                output[1]=event[3];
            }else if(distance==output[2]&&event[3]==output[1]){
                loc=i;
                output[0]=Math.min(event[0],output[0]);
            }
            i++;
        }
        if(loc==-1){
            output[0]=-1;
            output[1]=0;
            output[2]=0;
            return output;
        }
        events.remove(loc);
        return output;
    }


    public static void main(String args[] ) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
        Scanner scan = new Scanner(System.in);
        List<int[]> events=new ArrayList<>();
        int sizeOfWorld = Integer.parseInt(scan.nextLine());
        int numberOfEvents = Integer.parseInt(scan.nextLine());
        while(numberOfEvents > 0){
            String[] event = scan.nextLine().split(" ");
            int[] eventArray=new int[4];
            if(event.length>=4) {
                for (int i = 0; i < 4; i++) {
                    eventArray[i] = Integer.parseInt(event[i]);
                }
                events.add(eventArray);
                for (int i = 4; i < event.length; i++) {
                    int[] seventArray = eventArray.clone();
                    seventArray[3] = Integer.parseInt(event[i]);
                    events.add(seventArray);
                }
            }
            numberOfEvents--;
        }

        int numberOfBuyers = Integer.parseInt(scan.nextLine());
        while(numberOfBuyers > 0){
            String buyer = scan.nextLine();
            int x=Integer.parseInt(buyer.split(" ")[0]);
            int y=Integer.parseInt(buyer.split(" ")[1]);
            int nearest[]=findNearest(x,y,events);
            System.out.println(nearest[0]+" "+nearest[1]);
            numberOfBuyers--;
        }

        // The solution to the first sample above would be to output the following to console:
        // (Obviously, your solution will need to figure out the output and not just hard code it)
    }

}
