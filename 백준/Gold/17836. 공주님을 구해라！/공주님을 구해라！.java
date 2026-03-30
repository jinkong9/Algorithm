import java.io.*;
import java.util.*;
public class Main {
	static int N,M,T, arr[][],mr,mc, ans;
	static int dr[] = { -1, 1, 0, 0 };
	static int dc[] = { 0, 0, -1, 1 };
	static boolean v[][][];
	static class Point {
		int r, c,t,sw;

		Point(int r, int c, int t, int sw) {
			this.r = r;
			this.c = c;
			this.t = t;
			this.sw = sw;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		
		arr = new int[N][M];
		v = new boolean[N][M][2];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if(arr[i][j] == 2) {
					mr = i;
					mc = j;
				}
			}
		}
		ans = 0;
		bfs();
		if(ans == 0) {
			System.out.println("Fail");
			return;
		}
		if(ans > T) System.out.println("Fail");
		else System.out.println(ans);
	}

	static void bfs() {
		Queue <Point> Q = new ArrayDeque<>();
		Q.offer(new Point(0,0,0,0));
		v[0][0][0] = true;
		while(!Q.isEmpty()) {
			Point p = Q.poll();
			if(p.r == N-1 && p.c == M-1) {
				ans = p.t;
				return;
			}
			for(int i=0; i<4; i++) {
				int nr = p.r + dr[i];
				int nc = p.c + dc[i];
				int sw = p.sw;
				if(nr < 0 || nr >=N || nc < 0 || nc >=M) continue;
				if(v[nr][nc][sw]) continue;
				if(arr[nr][nc] == 2) sw = 1;
				if(sw == 1) {
					v[nr][nc][sw] = true;
					Q.offer(new Point(nr,nc,p.t+1, sw));
				} else {
					if(arr[nr][nc] == 1) continue;
					v[nr][nc][sw] = true;
					Q.offer(new Point(nr,nc,p.t+1, sw));
				}
			}
		}
	}
	
}
