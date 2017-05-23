package Medium;

/**
 * Created by kusha on 5/23/2017.
 */
public class UniquePaths63 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m=obstacleGrid.length;
        int n=obstacleGrid[0].length;
        int nums[][]=new int[m][n];
        for(int i=0;i<n;i++){
            if(obstacleGrid[0][i]==1){
                break;
            }
            nums[0][i]=1;

        }
        for(int i=0;i<m;i++){
            if(obstacleGrid[i][0]==1){
                break;
            }
            nums[i][0]=1;
        }

        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                if(obstacleGrid[i][j]==1){
                    continue;
                }
                nums[i][j]=nums[i-1][j]+nums[i][j-1];
            }
        }
        return nums[n-1][m-1];

    }
    public static void main(String[] args) {

    }
}
