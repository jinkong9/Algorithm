

import java.io.*;
import java.util.*;

public class Solution {
	static int dr[] = { -1, 1, 0, 0 };
	static int dc[] = { 0, 0, -1, 1 };
	static int endr, endc, sr, sc, arr[][], N, min;
	static boolean v[][];

	static class Point {
		int r, c, t;

		Point(int r, int c, int t) {
			this.r = r;
			this.c = c;
			this.t = t;
		}
	}

	static Queue<Point> Q;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());

			arr = new int[N][N];

			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			StringTokenizer st1 = new StringTokenizer(br.readLine());
			sr = Integer.parseInt(st1.nextToken());
			sc = Integer.parseInt(st1.nextToken());
			StringTokenizer st2 = new StringTokenizer(br.readLine());
			endr = Integer.parseInt(st2.nextToken());
			endc = Integer.parseInt(st2.nextToken());
			min = Integer.MAX_VALUE;
			Q = new ArrayDeque<>();
			v = new boolean[N][N];
			Q.offer(new Point(sr, sc, 0));
			v[sr][sc] = true;
			if(sr == endr && sc == endc) {
				System.out.println(0);
				continue;
			} 
			System.out.println("#" + tc + " " + (bfs() ? min : -1));
		}
	}

	static boolean bfs() {
		while (!Q.isEmpty()) {
			Point p = Q.poll();
			int time = p.t;

			if (p.r == endr && p.c == endc) {
				min = time;
				return true;
			}
			for (int i = 0; i < 4; i++) {
				int nr = p.r + dr[i];
				int nc = p.c + dc[i];

				if (nr < 0 || nr >= N || nc < 0 || nc >= N) continue;
				if (arr[nr][nc] == 1) continue;
				if(v[nr][nc]) continue;
				
				if (arr[nr][nc] == 2) {
					if(time % 3 == 2) {
						v[nr][nc] = true;
						Q.offer(new Point(nr, nc, time+1));
					} else {
						v[p.r][p.c] = true;
						Q.offer(new Point(p.r,p.c,time+1));
					}
				} else {
					v[nr][nc] = true;
					Q.offer(new Point(nr, nc, time + 1));
				}

			}
		}
		return false;
	}
}
