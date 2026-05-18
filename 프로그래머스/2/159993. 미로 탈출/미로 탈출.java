import java.util.*;

class Solution {
    static class Point {
        int r,c,t, time;
        Point(int r, int c, int t, int time) {
            this.r = r;
            this.c = c;
            this.t = t;
            this.time = time;
        }
    }
    static boolean v[][][];
    static int dr[] = {-1,1,0,0};
    static int dc[] = {0,0,-1,1};
    static int N,M, sr,sc ,er,ec, ans;
    static char arr[][];
    
    public int solution(String[] maps) {
        int answer = 0;
        N = maps.length;
        M = maps[0].length();
        arr = new char[N][M];
        for(int i=0; i<N; i++) {
            String s = maps[i];
            for(int j=0; j<M; j++) {
                arr[i][j] = s.charAt(j);
                if(arr[i][j] == 'S') {
                    sr = i;
                    sc = j;
                } else if(arr[i][j] == 'E') {
                    er = i;
                    ec = j;
                }
            }
        }
        ans = 0;
        bfs();
        System.out.println(ans);
        if(ans == 0) return -1;
        else return ans;
    }
    
    static void bfs() {
        v = new boolean[N][M][2];
        v[sr][sc][0] = true;
        Queue <Point> Q = new ArrayDeque<>();
        Q.offer(new Point(sr,sc,0,0));
        
        while(!Q.isEmpty()) {
            Point p = Q.poll();
            if(p.r == er && p.c == ec && p.t == 1) {
                ans = p.time;
                return;
            }
            for(int i=0; i<4; i++) {
                int nr = p.r + dr[i];
                int nc = p.c + dc[i];
                
                if(nr <0 || nr >= N || nc <0 || nc >=M) continue;
                if(arr[nr][nc] == 'X') continue;
                
                int tmp = p.t;
                if(arr[nr][nc] == 'L') tmp = 1;
                if(v[nr][nc][tmp]) continue;
                
                Q.offer(new Point(nr,nc,tmp,p.time+1));
                v[nr][nc][tmp] = true;
                
            }
        }
    }
}