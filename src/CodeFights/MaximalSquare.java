package CodeFights;

/**
 * Created by kusha on 8/6/2017.
 */
public class MaximalSquare {
    static int maximalSquare(char[][] matrix) {
        if(matrix==null||matrix.length==0){
            return 0;
        }
        int max=0;
        int [][]array=new int[matrix.length+1][matrix[0].length+1];
        for(int i=1;i<=matrix.length;i++){
            for(int j=1;j<=matrix[0].length;j++){
                if(matrix[i-1][j-1]=='1') {
                    int min = Math.min(array[i - 1][j - 1], array[i - 1][j]);
                    min = Math.min(min, array[i][j - 1]);
                    array[i][j] = min + 1;
                    max=Math.max(max,min+1);
                }
            }
        }

        for(int i=0;i<=matrix.length;i++){
            for(int j=0;j<=matrix[0].length;j++){
                System.out.print(" "+array[i][j]);
            }
            System.out.println();
        }

        return max;
    }

    public static void main(String[] args) {
        char array[][]={{'1','0','1','1','1'},
                {'1','0','1','1','1'},
                {'1','1','1','1','1'},
                {'1','0','0','1','0'},
                {'1','0','0','1','0'}};
        maximalSquare(array);

    }

}
