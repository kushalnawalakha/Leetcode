package CodeFights;

/**
 * Created by kusha on 8/6/2017.
 */
public class ArrayChange {
    static int arrayChange(int[] inputArray) {
        int count=0;
        for(int i=1;i<inputArray.length;i++){
            if(inputArray[i-1]>=inputArray[i]){
                count= (inputArray[i-1]-inputArray[i])+1;
                inputArray[i]=inputArray[i-1]+1;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int array[]={1,1,1};
        arrayChange(array);
    }

}
