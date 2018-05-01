package Easy;

import java.util.Map;

/**
 * Created by kushal on 10/7/17.
 */
public class MaxArea {
    int max=0;
    int count=0;
    public void maxAreaOfIslandHelper(int[][] grid,boolean b[][],int x,int y) {
        if(x>=grid.length||y>=grid[0].length||x<0||y<0||grid[x][y]==0||b[x][y]){
            return;
        }
        count++;
        max= Math.max(max,count);
        b[x][y]=true;
        maxAreaOfIslandHelper(grid,b,x,y+1);
        maxAreaOfIslandHelper(grid,b,x+1,y);
        maxAreaOfIslandHelper(grid,b,x-1,y);
        maxAreaOfIslandHelper(grid,b,x,y-1);


    }
    public int maxAreaOfIsland(int[][] grid) {
        if(grid.length==0||grid[0].length==0){
            return 0;
        }
        boolean arr[][]=new boolean[grid.length][grid[0].length];
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1&&!arr[i][j]){
                    count=0;
                    maxAreaOfIslandHelper(grid,arr,i,j);
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int arr[][]={{1,1},{1,0}};
        MaxArea m=new MaxArea();
        System.out.println(m.maxAreaOfIsland(arr));
    }
}
