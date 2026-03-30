import java.io.*;
import java.util.*;

public class Main {
	static int N, arr[][], min;
	static int dr[] = { -1, 1, 0, 0 };
	static int dc[] = { 0, 0, -1, 1 };
	static boolean v[][];

	static class Point {
		int r, c, t;

		Point(int r, int c, int t) {
			this.r = r;
			this.c = c;
			this.t = t;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		arr = new int[N][N];
		v = new boolean[N][N];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int idx = 1;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (arr[i][j] == 1 && !v[i][j]) {
					bfs(idx, i, j);
					idx++;
				}
			}
		}
		min = Integer.MAX_VALUE;
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(arr[i][j] > 0) {
					for(int k =0; k<4; k++) {
						int nr = i + dr[k];
						int nc = j + dc[k];
						if (nr < 0 || nr >= N || nc < 0 || nc >= N)
							continue;
						if(arr[nr][nc] == 0) {
							bri(i,j, arr[i][j]);
							break;
						}
					}
				}
			}
		}
		System.out.println(min);
	}

	static void bri(int r, int c, int a) {
		Queue<Point> Q = new ArrayDeque<>();
		boolean v1[][] = new boolean[N][N];
		Q.offer(new Point(r,c,0));
		v1[r][c] = true;
		
		while(!Q.isEmpty()) {
			Point p = Q.poll();
			if(arr[p.r][p.c] != a && arr[p.r][p.c] >0) {
				min = Math.min(min, p.t-1);
				return;
			}
			for(int i=0; i<4; i++) {
				int nr = p.r + dr[i];
				int nc = p.c + dc[i];
				
				if (nr < 0 || nr >= N || nc < 0 || nc >= N)
					continue;
				if (v1[nr][nc])
					continue;
				if (arr[nr][nc] == a)
					continue;
				v1[nr][nc] = true;
				Q.offer(new Point(nr, nc,p.t+1));
			}
		}
	}
	
	static void bfs(int idx, int r, int c) {
		Queue<Point> Q = new ArrayDeque<>();
		v[r][c] = true;
		arr[r][c] = idx;
		Q.offer(new Point(r, c,0));

		while (!Q.isEmpty()) {
			Point p = Q.poll();

			for (int i = 0; i < 4; i++) {
				int nr = p.r + dr[i];
				int nc = p.c + dc[i];

				if (nr < 0 || nr >= N || nc < 0 || nc >= N)
					continue;
				if (v[nr][nc])
					continue;
				if (arr[nr][nc] == 0)
					continue;
				arr[nr][nc] = idx;
				v[nr][nc] = true;
				Q.offer(new Point(nr, nc,0));
			}
		}
	}
}
