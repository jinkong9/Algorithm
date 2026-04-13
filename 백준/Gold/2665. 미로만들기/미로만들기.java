import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    static int N, arr[][], min;
    static int dr[] = {-1,1,0,0};
    static int dc[] = {0,0,-1,1};
    static class Point implements Comparable<Point> {
        int r,c,t;
        Point(int r, int c, int t) {
            this.r = r;
            this.c = c;
            this.t = t;
        }
        public int compareTo(Point o) {
			return this.t - o.t;
		}
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        arr = new int[N][N];

        for(int i=0; i<N; i++) {
            String s = br.readLine();
            for(int j=0; j<N; j++) {
                arr[i][j] = s.charAt(j) - '0';
            }
        }
         min = Integer.MAX_VALUE;
        dijkstra();
    }

    static void dijkstra() {
        PriorityQueue <Point> Q = new PriorityQueue<>();
        Q.offer(new Point(0,0,0));
        int dist[][] = new int[N][N];
        for(int i=0; i<N; i++) Arrays.fill(dist[i], Integer.MAX_VALUE);
        dist[0][0] = 0;

        while(!Q.isEmpty()) {
            Point p = Q.poll();
            if(p.r == N-1 && p.c == N-1) {
                min = Math.min(min,p.t);
            }
            if(dist[p.r][p.c] < p.t) continue;
            
            for(int i=0; i<4; i++) {
                int nr = p.r + dr[i];
                int nc = p.c + dc[i];
                int tt = p.t;
                if(nr <0 || nr >= N || nc < 0 || nc >= N) continue;
                if(arr[nr][nc] == 0) tt += 1;
                if(dist[nr][nc] > dist[p.r][p.c] + 1) {
                    dist[nr][nc] = dist[p.r][p.c] + 1;
                    Q.offer(new Point(nr,nc,tt));
                }
            }
        }
        System.out.println(min);
    }
}