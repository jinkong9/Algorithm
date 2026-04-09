import java.io.*;
import java.util.*;

public class Main {
	static int N, M, K, arr[][], sr, sc, er, ec, min;
	static int dr[] = { -1, 1, 0, 0 };
	static int dc[] = { 0, 0, -1, 1 };

	static class Point {
		int r, c, t;

		Point(int r, int c, int t) {
			this.r = r;
			this.c = c;
			this.t = t;
		}
	}
	static Queue<Point> Q1;
	static boolean v1[][];
	static ArrayList<Point> list;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		arr = new int[N][M];
		list = new ArrayList<>();
		Q1 = new ArrayDeque<>();
		v1 = new boolean[N][M];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if (arr[i][j] == 3) {
					Q1.offer(new Point(i,j,0));
					v1[i][j] = true;
					arr[i][j] = -1;
				}
				if (arr[i][j] == 4) {
					sr = i;
					sc = j;
				}
			}
		}
		min = Integer.MAX_VALUE;
	    while (!Q1.isEmpty()) {
	        Point p = Q1.poll();

	        if (p.t >= K) continue;

	        for (int i = 0; i < 4; i++) {
	            int nr = p.r + dr[i];
	            int nc = p.c + dc[i];

	            if (nr < 0 || nr >= N || nc < 0 || nc >= M)
	                continue;
	            if (v1[nr][nc])
	                continue;

	            v1[nr][nc] = true;
	             if(arr[nr][nc] != -1) {
	            	arr[nr][nc] = -1;
	            }
	            Q1.offer(new Point(nr, nc, p.t + 1));
	        }
	    }

		bfs();
		if(min == Integer.MAX_VALUE) System.out.println(-1);
		else System.out.println(min);
	}

	static void bfs() {
		Queue<Point> Q = new ArrayDeque<>();
		boolean v[][] = new boolean[N][M];
		v[sr][sc] = true;
		Q.offer(new Point(sr, sc, 0));

		while (!Q.isEmpty()) {
			Point p = Q.poll();

			if(arr[p.r][p.c] == 2) {
				min = Math.min(min, p.t);
				return;
			}
			
			for (int i = 0; i < 4; i++) {
				int nr = p.r + dr[i];
				int nc = p.c + dc[i];

				if (nr < 0 || nr >= N || nc < 0 || nc >= M)
					continue;
				if (v[nr][nc])
					continue;
				if (arr[nr][nc] == 1 || arr[nr][nc] == -1)
					continue;
				v[nr][nc] = true;
				Q.offer(new Point(nr, nc, p.t +1));
			}
		}
	}

}
