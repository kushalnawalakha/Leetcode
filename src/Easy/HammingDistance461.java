package Easy;
/**
 * Created by kusha on 5/13/2017.
 */
public class HammingDistance461 {
    public int hammingDistance(int x, int y) {
        int count=0;
        while (x!=0||y!=0){
            if((x&1)!=(y&1)){
                count++;
            }
            x=x>>1;
            y=y>>1;
        }
        return count;
    }
    public static void main(String[] args) {
        HammingDistance461 obj=new HammingDistance461();
        System.out.print(obj.hammingDistance(1,4));
    }
}