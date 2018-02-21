package CodeFights;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by kusha on 7/24/2017.
 */
public class Sudoku {
    boolean sudoku2(char[][] grid) {
        HashMap<Character,List<int[]>> map=new HashMap<>();
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid.length;j++){
                int array[]=new int[2];
                array[0]=i;
                array[1]=j;
                if(grid[i][j]!='.'&&map.containsKey((Character)grid[i][j])){
                    for(int[] rc:map.get(grid[i][j])){
                        if(rc[0]==i||rc[1]==j){
                            return false;
                        }
                        if(rc[0]/3==i/3&&rc[1]/3==j/3){
                            return false;
                        }
                    }
                    map.get(grid[i][j]).add(array);
                }else{
                    ArrayList<int[]> list=new ArrayList<>();
                    list.add(array);
                    map.put((Character)grid[i][j],list);
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        char array[][]={{'.','.','.','1','4','.','.','2','.'},
                {'.','.','6','.','.','.','.','.','.'},
                {'.','.','.','.','.','.','.','.','.'},
                {'.','.','1','.','.','.','.','.','.'},
                {'.','6','7','.','.','.','.','.','9'},
                {'.','.','.','.','.','.','8','1','.'},
                {'.','3','.','.','.','.','.','.','6'},
                {'.','.','.','.','.','7','.','.','.'},
                {'.','.','.','5','.','.','.','7','.'}};
        Sudoku s=new Sudoku();
        s.sudoku2(array);
    }

}
