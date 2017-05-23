/**
 * Created by kusha on 5/16/2017.
 */
public class HorseMoves {
    int moves[][] = {
            { -2, -1 },
            { -2, +1 },
            { -1, -2 },
            { -1, +2 },
            { +1, -2 },
            { +1, +2 },
            { +2, -1 },
            { +2, +1 }
    };
    int min=Integer.MAX_VALUE;
    public void horseMoves(int dimention1,int startx,int starty,int endx,int endy,int array[][],int count){
        if(startx<0||startx>=dimention1||starty<0||starty>=dimention1){
            return;
        }
        if(startx==endx&&starty==endy){
            min=Math.min(min,count);
        }
        for(int i=0;i<moves.length;i++){
            if(array[startx][starty]>0&&array[startx][starty]<count){
                return;
            }
            array[startx][starty]=count;
            horseMoves(dimention1,startx+moves[i][0],starty+moves[i][1],endx,endy,array,count+1);
        }
    }

    public static void main(String[] args) {
        HorseMoves horseMoves=new HorseMoves();
        int array[][]=new int[8][8];
        horseMoves.horseMoves(8,0,0,7,7,array,1);
        for(int i=0;i<8;i++){
            for(int j=0;j<8;j++){
                System.out.print(array[i][j]+" ");
            }
            System.out.println();
        }
    }
}
