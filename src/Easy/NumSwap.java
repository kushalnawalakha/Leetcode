package Easy;

/**
 * Created by kushal on 9/2/17.
 */
public class NumSwap {
        public static int app1(char cNum[],int num){
            char minNum='9'+1;
            int loc2=0;
            for(int i=0;i<cNum.length;i++){
                if(minNum>cNum[i]){
                    minNum=cNum[i];
                    loc2=i;
                }
            }
            char maxNum='0'-1;
            int loc1=-1;
            for(int i=cNum.length-1;i>loc2;i--){
                if(maxNum<cNum[i]){
                    maxNum=cNum[i];
                    loc1=i;
                }
            }
            if(loc1==-1){
                return num;
            }
            char temp=cNum[loc2];
            cNum[loc2]=cNum[loc1];
            cNum[loc1]=temp;
            return Integer.parseInt(String.valueOf(cNum));
        }

    public static int app2(char cNum[],int num){

        char maxNum='0'-1;
        int loc1=-1;
        for(int i=cNum.length-1;i>=0;i--){
            if(maxNum<cNum[i]){
                maxNum=cNum[i];
                loc1=i;
            }
        }
        char minNum='9'+1;
        int loc2=-1;
        for(int i=0;i<loc1;i++){
            if(minNum>cNum[i]){
                minNum=cNum[i];
                loc2=i;
            }
        }
        if(loc2==-1){
            return num;
        }
        char temp=cNum[loc2];
        cNum[loc2]=cNum[loc1];
        cNum[loc1]=temp;
        return Integer.parseInt(String.valueOf(cNum));
    }

        public static int maximumSwap(int num) {
            String strNum=""+num;
            char cNum1[]=strNum.toCharArray();
            char cNum2[]=strNum.toCharArray();
            return Math.max(app1(cNum1,num),app2(cNum2,num));

        }

    public static void main(String[] args) {
        int num=22345342;
        System.out.println(maximumSwap(num));
    }
}
