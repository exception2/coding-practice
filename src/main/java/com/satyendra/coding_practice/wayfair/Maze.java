package com.satyendra.coding_practice.wayfair;

// https://leetcode.com/discuss/interview-question/algorithms/4418282/WayFair-Hackerrank-or-SSE-or-Dec-2023/
import java.util.LinkedList;
import java.util.Queue;

public class Maze {
    public static void main(String[] args) {
        //System.out.println(solve(new int[][]{{0,0,0},{1,0,0}},1));
        //System.out.println(solve(new int[][]{{0,1,0},{0,1,0},{0,0,0}},1));
        System.out.println(solve(new int[][]{{0,0,1,0},{0,0,0,0}},2));
    }
    static int colPrefix [][];
    static int rowPrefix [][];
    static int n,m;
    static boolean seen[][];
    static int grid[][];
    public static int solve(int maze[][],int k){
        grid = maze;
        n = maze.length;
        m = maze[0].length;
        seen = new boolean[n][m];

        int dx[]=new int[]{0,-1*k,0,k};
        int dy[]=new int[]{-1*k,0,k,0};

        rowPrefix=new int[n][m];
        for(int i=0;i<n;i++){
            rowPrefix[i][0] = maze[i][0];
            for(int j=1;j<m;j++){
                rowPrefix[i][j] = rowPrefix[i][j-1] + maze[i][j];
            }
        }

        colPrefix=new int[n][m];
        for(int i=0;i<m;i++){
            colPrefix[0][i] = maze[0][i];
            for(int j=1;j<n;j++){
                colPrefix[j][i] = colPrefix[j-1][i] + maze[j][i];
            }
        }

        Queue<int []> q = new LinkedList<>();
        q.add(new int[]{0,0});
        seen[0][0]=true;
        int depth=0;
        while(!q.isEmpty()){
            int currSize = q.size();
            for(int i=0;i<currSize;i++){
                int []cell = q.poll();
                for (int d=0;d<4;d++){
                    int new_x = cell[0] + dx[d];
                    int new_y = cell[1] + dy[d];
                    if(isPossible2(cell[0],cell[1],new_x,new_y)){

                        if(new_x==n-1 && new_y==m-1)
                            return depth;

                        seen[new_x][new_y]=true;
                        q.add(new int[]{new_x,new_y});
                    }
                }
            }
            depth++;
        }

        return -1;
    }

    private static boolean isPossible(int x,int y,int p,int q){
        if(!(p>=0 && p<n && q>=0 && q<m))
            return false;

        if(seen[p][q])
            return false;
        int obstacles = 0;
        if(x==p){ //column move
            if(q>y){ //right move
                obstacles = (y==0) ? rowPrefix[x][q] : rowPrefix[x][q] - rowPrefix[x][y-1] ;
            }else{ //left move
                obstacles = (q==0) ? rowPrefix[x][y] : rowPrefix[x][y] - rowPrefix[x][q-1] ;
            }
        }else{ //row move
            if(p>x){ //down move
                obstacles = (x==0) ? colPrefix[p][y] : colPrefix[p][y] - colPrefix[x-1][y];
            }else{ //up move
                obstacles = (p==0) ? colPrefix[x][y] : colPrefix[x][y] - colPrefix[p-1][y];
            }
        }

        return obstacles==0;
    }

    private static boolean isPossible2(int x,int y,int p,int q){
        if(!(p>=0 && p<n && q>=0 && q<m))
            return false;

        if(seen[p][q])
            return false;
        int obstacles = 0;
        if(x==p){ //column move
            if(q>y){ //right move
                for(int i=y;i<=q;i++){
                    if(grid[x][i]==1)
                        return false;
                }
            }else{ //left move
                for(int i=q;i<=y;i++){
                    if(grid[x][i]==1)
                        return false;
                }
            }
        }else{ //row move
            if(p>x){ //down move
                for(int i=x;i<=p;i++){
                    if(grid[i][y]==1)
                        return false;
                }
            }else{ //up move
                for(int i=p;i<=x;i++){
                    if(grid[i][y]==1)
                        return false;
                }
            }
        }

        return true;
    }
}
