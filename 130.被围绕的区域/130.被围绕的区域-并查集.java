/*
 * @lc app=leetcode.cn id=130 lang=java
 *
 * [130] 被围绕的区域
 */

// @lc code=start
class Solution {
    static int cols;
    public void solve(char[][] board) {
        int [][] dir = new int[][]{{1,0},{0,1},{-1,0},{0,-1}};
        if(board == null||board.length==0)return;
        int rows=board.length;
        cols=board[0].length;
        //使用一个虚拟节点作为边界上0的父节点，这样他们就是一个连通分量
        UnionFind uf = new UnionFind(rows*cols+1);
        int dummyNode = rows*cols;
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(board[i][j]=='O'){
                    if(i==0||i==rows-1||j==0||j==cols-1){
                        //边界上的点，与dummynode合并成一个区域
                        uf.union(node(i, j),dummyNode);
                    }
                    else{
                        //和上下左右合并
                        for(int k=0;k<4;k++){
                            if(board[i+dir[k][0]][j+dir[k][1]]=='O'){
                                uf.union(node(i, j),node(i+dir[k][0],j+dir[k][1]));
                            }
                        }
                    }
                }
            }
        }
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(uf.isConnected(node(i, j), dummyNode)){
                    board[i][j] = 'O';
                }
                else{
                    board[i][j]='X';
                }
            }
        }
        return;
    }
    int node(int i,int j){
        return i*cols+j;
    }
}
class UnionFind{
    int[] parents;
    public UnionFind(int totalNodes){//并查集的父节点一开始为其本身
        parents = new int[totalNodes];
        for(int i=0;i<totalNodes;i++){
            parents[i]=i;
        }
    }

    //使用find来合并连通区域，这两个节点是在一个连通区域内
    void union(int node1,int node2){
        int root1 = find(node1);
        int root2 = find(node2);
        if(root1!=root2){
            parents[root2]=root1;
        }
    }

    int find(int node){//寻找父亲节点
        if(node==parents[node])return node;
        else{
            parents[node]=find(parents[node]);//路径压缩
            return parents[node];
        }
        // while(parents[node]!=node){
        //     //当前节点的父节点 
        //     parents[node]=parents[parents[node]];
        //     node = parents[node];
        // }
        // return node;
    }

    boolean isConnected(int node1,int node2){
        return find(node1)==find(node2);
    }
}
// @lc code=end

