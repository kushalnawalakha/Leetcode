package Medium;

/**
 * Created by kusha on 7/4/2017.
 */
public class BattleShips419 {
    public boolean check(int x,int y,char board[][]){
        if(x-1>=0&&board[x-1][y]=='X'){
            return true;
        }
        if(y-1>=0&&board[x][y-1]=='X'){
            return true;
        }
/*
        if(x+1<board.length&&board[x+1][y]=='X'){
            return true;
        }
        if(y+1<board[x].length&&board[x][y+1]=='X'){
            return true;
        }
*/


        return false;

    }
    public int countBattleships(char[][] board) {
        int cnt=0;
        for(int x=0;x<board.length;x++){
            for(int y=0;y<board[x].length;y++){
                if(board[x][y]=='X'&&!check(x,y,board)){
                    cnt++;
                }
            }
        }
        return cnt;
    }
    public static void main(String str[]){
        char cnt[][]=new char[3][4];
        cnt[0]="X..X".toCharArray();
        cnt[1]="...X".toCharArray();
        cnt[2]="...X".toCharArray();


    }
}
