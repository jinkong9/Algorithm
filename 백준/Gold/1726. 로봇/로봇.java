import java.io.*;
import java.util.*;

public class Main {
	static int N, M, arr[][], cnt, sr, sc, sd, er, ec, ed, ans;
	static int dr[] = { 0, 0, 1, -1 };
	static int dc[] = { 1, -1, 0, 0 };
	static int[] left = { 3, 2, 0, 1 };
	static int[] right = { 2, 3, 1, 0 };

	static class Point {
		int r, c, d, cnt;

		Point(int r, int c, int d, int cnt) {
			this.r = r;
			this.c = c;
			this.d = d;
			this.cnt = cnt;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		st = new StringTokenizer(br.readLine());
		sr = Integer.parseInt(st.nextToken())-1;
		sc = Integer.parseInt(st.nextToken())-1;
		sd = Integer.parseInt(st.nextToken())-1;
		st = new StringTokenizer(br.readLine());
		er = Integer.parseInt(st.nextToken())-1;
		ec = Integer.parseInt(st.nextToken())-1;
		ed = Integer.parseInt(st.nextToken())-1;

		ans = 0;
		bfs();
		System.out.println(ans);
	}

	static void bfs() {
		Queue<Point> Q = new ArrayDeque<>();
		boolean v[][][] = new boolean[N][M][4];
		Q.offer(new Point(sr, sc, sd, 0));
		v[sr][sc][sd] = true;

		while (!Q.isEmpty()) {
			Point p = Q.poll();

			if (p.r == er && p.c == ec) {
				if (p.d == ed) {
					ans = p.cnt;
					return;
				} 
			}

			int nd = p.d;
			for (int i = 1; i <= 3; i++) { // 직진
				int nr = p.r + dr[nd] * i;
				int nc = p.c + dc[nd] * i;
				if (nr < 0 || nr >= N || nc < 0 || nc >= M) {
					break;
				}
				if (arr[nr][nc] == 1) {
					break;
				}

				if (!v[nr][nc][nd]) {
					v[nr][nc][nd] = true;
					Q.offer(new Point(nr, nc, p.d, p.cnt + 1));
				}
			}

			// 좌회전
			nd = left[p.d];
			if (!v[p.r][p.c][nd]) {
				v[p.r][p.c][nd] = true;
				Q.offer(new Point(p.r, p.c, nd, p.cnt + 1));
			}

			// 우회전
			nd = right[p.d];
			if (!v[p.r][p.c][nd]) {
				v[p.r][p.c][nd] = true;
				Q.offer(new Point(p.r, p.c, nd, p.cnt + 1));
			}
		}
	}
}
