package CodeFights;

/**
 * Created by kusha on 8/6/2017.
 */
public class AreSimilar {

    static boolean areSimilar(int[] a, int[] b) {
        if(a.length!=b.length){
            return false;
        }
        boolean bo=false;
        for(int i=0;i<a.length;i++){
            if(a[i]!=b[i]){
                if(bo){
                    return false;
                }
                int temp1=i+1;
                while(true){
                    if(a[temp1]!=b[temp1]&&b[i]==a[temp1]){
                        break;
                    }
                    temp1++;
                    if(temp1>=a.length){
                        return false;
                    }
                }
                a[temp1]=a[i];
                bo=true;
            }
        }

        return true;

    }

    public static void main(String[] args) {
        int a[]={1,2,3};
        int b[]={1,10,2};
        areSimilar(a,b);
    }

}
