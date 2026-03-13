import java.io.*;
import java.util.*;

public class Solution {
	static int N, M, sr, sc, ans, ar, ac;
	static char arr[][];
	static int map[][];
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };

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
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			arr = new char[N][M];
			for (int i = 0; i < N; i++) {
				String s = br.readLine();
				for (int j = 0; j < M; j++) {
					arr[i][j] = s.charAt(j);
					if (arr[i][j] == 'S') {
						sr = i;
						sc = j;
					} else if (arr[i][j] == 'D') {
						ar = i;
						ac = j;
					}
				}
			}
			map = new int[N][M];
			ans = Integer.MAX_VALUE;
			bfs();
			bfs2(sr, sc);
			sb.append("#").append(tc).append(" ");
			if (ans == Integer.MAX_VALUE)
				sb.append("GAME OVER");
			else
				sb.append(ans);
			sb.append("\n");
		}
		System.out.println(sb);
	}

	static void bfs() {
		for (int i = 0; i < N; i++) {
			Arrays.fill(map[i], -1);
		}
		Queue<Point> Q = new ArrayDeque<>();
		boolean v[][] = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (arr[i][j] == '*') {
					Q.offer(new Point(i, j, 0));
					v[i][j] = true;
					map[i][j] = 0;
				}
			}
		}

		while (!Q.isEmpty()) {
			Point p = Q.poll();

			for (int i = 0; i < 4; i++) {
				int nr = p.r + dr[i];
				int nc = p.c + dc[i];

				if (nr < 0 || nr >= N || nc < 0 || nc >= M)
					continue;
				if (v[nr][nc])
					continue;
				if (arr[nr][nc] == 'X')
					continue;
				if (arr[nr][nc] == 'D')
					continue;
				map[nr][nc] = p.t + 1;
				v[nr][nc] = true;
				Q.offer(new Point(nr, nc, p.t + 1));
			}
		}
	}

	static void bfs2(int r, int c) {
		Queue<Point> Q = new ArrayDeque<>();
		boolean v[][] = new boolean[N][M];
		Q.offer(new Point(r, c, 0));
		v[r][c] = true;

		while (!Q.isEmpty()) {
			Point p = Q.poll();
			if (p.r == ar && p.c == ac) {
				ans = Math.min(p.t, ans);
			}
			for (int i = 0; i < 4; i++) {
				int nr = p.r + dr[i];
				int nc = p.c + dc[i];

				if (nr < 0 || nr >= N || nc < 0 || nc >= M)
					continue;
				if (v[nr][nc])
					continue;
				if (arr[nr][nc] == 'X')
					continue;
				if (map[nr][nc] != -1 && map[nr][nc] <= p.t + 1)
					continue;
				v[nr][nc] = true;
				Q.offer(new Point(nr, nc, p.t + 1));
			}
		}
	}
}
