/*
 * @lc app=leetcode.cn id=130 lang=java
 *
 * [130] 被围绕的区域
 */

// @lc code=start
class Solution {
    static int[][] dir={{1,0},{0,1},{-1,0},{0,-1}};

    public void solve(char[][] board) {
        for(int i=0;i<board.length;i++){
            dfs(i,0,board);
            dfs(i,board[0].length-1,board);
        }
        for(int i=1;i<board[0].length-1;i++){
            dfs(0,i,board);
            dfs(board.length-1,i,board);
        }
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(board[i][j]=='*')board[i][j]='O';
                else if(board[i][j]=='O')board[i][j]='X';
            }
        }
        return;
    }
    void dfs(int x,int y,char[][] board){
        if(board[x][y]=='X')return;
        board[x][y]='*';
        for(int i=0;i<4;i++){
            if(x==board.length-1&&dir[i][0]==1)continue;
            if(x==0&&dir[i][0]==-1)continue;
            if(y==board[0].length-1&&dir[i][1]==1)continue;
            if(y==0&&dir[i][1]==-1)continue;
            if(board[x+dir[i][0]][y+dir[i][1]]=='O'){
                dfs(x+dir[i][0],y+dir[i][1],board);
            }
        }
        return;
    }
}
// @lc code=end

