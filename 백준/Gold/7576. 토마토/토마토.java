

import java.io.*;
import java.util.*;

public class Main {

	static int cnt = 0;
	static int dr[] = { -1, 1, 0, 0 };
	static int dc[] = { 0, 0, -1, 1 };
	static int N, M, H;
	static int max = 0;
	static int arr[][];
	static boolean v[][];
	static Queue<Point> Q = new ArrayDeque<>();
	static class Point {
		int r;
		int c;
		int day;

		Point(int r, int c, int day) {
			this.r = r;
			this.c = c;
			this.day = day;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[M][N];
		v = new boolean[M][N];
		for (int i = 0; i < M; i++) {
			StringTokenizer st1 = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st1.nextToken());
				if(arr[i][j] == 1  && !v[i][j]) {
					Q.offer(new Point(i,j,0));
				}
			}
		}
		bfs();
		System.out.println(done(arr));
	}

	static void bfs() {
		int d = 0;
		while (!Q.isEmpty()) {
			Point p = Q.poll();
			int pr = p.r;
			int pc = p.c;
			v[pr][pc] = true;
			d = p.day;
			max = Math.max(max, d);
			for (int i = 0; i < 4; i++) {
				int nr = pr + dr[i];
				int nc = pc + dc[i];
				if (nr >= 0 && nr < M && nc >= 0 && nc < N && !v[nr][nc] && arr[nr][nc] == 0) {
					v[nr][nc] = true;
					arr[nr][nc] = 1;
					Q.offer(new Point(nr, nc, d + 1));
				}
			}
		}
	}


	static int done(int arr[][]) {
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				if (arr[i][j] == 0)
					return -1;
			}
		}
		return max;
	}

}
