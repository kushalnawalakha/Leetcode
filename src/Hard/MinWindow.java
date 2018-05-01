package Hard;

public class MinWindow {
    public static String minWindow(String S, String T) {
        int arr[][]=new int[T.length()+1][S.length()+1];
        T=new StringBuilder(T).reverse().toString();
        for(int i=1;i<=T.length();i++){
            for(int j=S.length()-1;j>0;j--){
                if(T.charAt(i-1)==S.charAt(j-1)){
                    arr[i][j]=Math.max(arr[i-1][j+1]+1,arr[i-1][j]);
                    arr[i][j]=Math.max(arr[i][j+1],arr[i][j]);
                }else{
                    arr[i][j]=Math.max(arr[i][j+1],arr[i-1][j]);
                }
            }
        }
        for(int i=0;i<=T.length();i++){
            for(int j=0;j<=S.length();j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
        return null;
    }

    public static void main(String[] args) {
        String S="abcdebdde";
        String T="bde";
        minWindow(S,T);
    }
}
