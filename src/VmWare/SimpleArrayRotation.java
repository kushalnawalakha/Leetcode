package VmWare;

/**
 * Created by kusha on 1/23/2018.
 */
public class SimpleArrayRotation {
    static int[] getMaxElementIndices(int[] a, int[] rotate) {
        int maxLocation=0;
        int maxValue=a[0];
        for(int i=1;i<a.length;i++){
            if(a[i]>maxValue){
                maxValue=a[i];
                maxLocation=i;
            }
        }
        int output[]=new int[rotate.length];
        for(int i=0;i<output.length;i++){
            if(rotate[i]!=0) {
                output[i] = maxLocation - rotate[i] % a.length;
                if(output[i]<0){
                    output[i]=a.length+output[i];
                }
            }else{
                output[i]=maxLocation;
            }
            System.out.println(output[i]);
        }
        return output;
    }

    public static void main(String[] args) {
        int num[]={1,2,4,3};
        int rotate[]={1,3};
        getMaxElementIndices(num,rotate);
    }
}
