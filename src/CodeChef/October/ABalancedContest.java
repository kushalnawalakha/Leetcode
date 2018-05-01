package CodeChef.October;

import java.util.Scanner;

/**
 * Created by kusha on 10/8/2017.
 */
public class ABalancedContest {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        for(int i=0;i<n;i++){
            int cnt=scanner.nextInt();
            int total=scanner.nextInt();
            boolean h1=false,h2=false,c=false,fail=false;
            for(int j=0;j<cnt;j++){
                int current=scanner.nextInt();
                if(current>=total/2){
                    if(c==true){
                        fail=true;
                    }
                    c=true;
                }else if(current<=total/10){
                    if(!h1){
                        h1=true;
                    }else if(!h2){
                        h2=true;
                    }else{
                        fail=true;
                    }
                }
            }
            if(h1&&h2&&c&&!fail){
                System.out.println("yes");
            }else{
                System.out.println("no");
            }
        }
    }
}
