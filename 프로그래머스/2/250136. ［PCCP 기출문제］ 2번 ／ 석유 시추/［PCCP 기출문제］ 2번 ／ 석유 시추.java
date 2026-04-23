import java.util.*;

class Solution {

    static int N,M;
    static int[][] land;
    static boolean[][] v;
    static int[][] group;

    static int[] dr = {-1,1,0,0};
    static int[] dc = {0,0,-1,1};

    static class Point{
        int r,c;
        Point(int r,int c){
            this.r=r;
            this.c=c;
        }
    }

    public int solution(int[][] arr) {

        land = arr;
        N = land.length;
        M = land[0].length;

        v = new boolean[N][M];
        group = new int[N][M];

        int[] size = new int[N*M+1];

        int num = 1;

        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(land[i][j]==1 && !v[i][j]){
                    size[num] = bfs(i,j,num);
                    num++;
                }
            }
        }

        int ans = 0;

        for(int c=0;c<M;c++){

            boolean[] used = new boolean[num+1];
            int sum = 0;

            for(int r=0;r<N;r++){
                int g = group[r][c];

                if(g > 0 && !used[g]){
                    used[g] = true;
                    sum += size[g];
                }
            }

            ans = Math.max(ans,sum);
        }

        return ans;
    }

    static int bfs(int r,int c,int num){

        Queue<Point> q = new ArrayDeque<>();
        q.offer(new Point(r,c));

        v[r][c] = true;
        group[r][c] = num;

        int cnt = 1;

        while(!q.isEmpty()){

            Point p = q.poll();

            for(int i=0;i<4;i++){

                int nr = p.r + dr[i];
                int nc = p.c + dc[i];

                if(nr<0||nr>=N||nc<0||nc>=M) continue;
                if(v[nr][nc]) continue;
                if(land[nr][nc]==0) continue;

                v[nr][nc] = true;
                group[nr][nc] = num;

                q.offer(new Point(nr,nc));
                cnt++;
            }
        }

        return cnt;
    }
}