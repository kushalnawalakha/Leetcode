import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SpiralPrint {
    public List<Integer> spiralOrder(int[][] matrix) {
        ArrayList<Integer> list=new ArrayList<Integer>();
        int maxRow=matrix.length-1;
        int maxColumn=matrix[0].length-1;

        for(int i=0;i<=maxRow/2;i++){
            for(int j=i;j<=maxColumn;j++){
                list.add(matrix[i][j]);
            }
            for(int j=i+1;j<maxRow;j++){
                list.add(matrix[j][maxColumn]);
            }
            for(int j=maxColumn;j>i&&i<maxRow/2;j--){
                list.add(matrix[maxRow][j]);
            }
            for(int j=maxRow;j>i;j--){
                list.add(matrix[j][i]);
            }
            maxColumn--;
        }
        return list;
    }

    public static void main(String[] args) {
        int nums[][]={{6,9,7}};
        SpiralPrint s=new SpiralPrint();
        System.out.println(s.spiralOrder(nums));

    }
}
