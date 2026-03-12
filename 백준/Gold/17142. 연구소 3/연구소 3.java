import java.io.*;
import java.util.*;

public class Main {
	static int N, M, arr[][], ans, cnt;
	static boolean[][] v;
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

	static Queue<Point> Q;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N][N];
		cnt = 0;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if (arr[i][j] == 0)
					cnt++;
			}
		}
		if(cnt == 0) {
			System.out.println(0);
			System.exit(0);
		}
		int[][] map = new int[N][N];
		for (int i = 0; i < N; i++)
			map[i] = arr[i].clone();
		ans = Integer.MAX_VALUE;
		comb(0, 0, map);
		if(ans == Integer.MAX_VALUE) System.out.println(-1);
		else System.out.println(ans);
	}

	static void comb(int idx, int start, int map[][]) {
		if (idx == M) {
			bfs(map);
			return;
		}

		for (int i = start; i < N * N; i++) {
			int r = i / N;
			int c = i % N;

			if (arr[r][c] != 2)
				continue;

			map[r][c] = -1;
			comb(idx + 1, i + 1, map);
			map[r][c] = 2; // 복구
		}
	}

	static void bfs(int map[][]) {
		Q = new ArrayDeque<>();
		v = new boolean[N][N];
		int copy[][] = new int[N][N];
		for (int i = 0; i < N; i++)
			copy[i] = map[i].clone();

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (copy[i][j] == -1) {
					Q.offer(new Point(i, j, 0));
					v[i][j] = true;
				}
			}
		}
		int tmp = 0;
		while (!Q.isEmpty()) {
			Point p = Q.poll();
			for (int i = 0; i < 4; i++) {
				int nr = p.r + dr[i];
				int nc = p.c + dc[i];
				if (nr < 0 || nr >= N || nc < 0 || nc >= N)
					continue;
				if (v[nr][nc])
					continue;
				if (copy[nr][nc] == -1 || copy[nr][nc] == 1)
					continue;
				if (copy[nr][nc] == 0) {
					tmp++;
				}
				v[nr][nc] = true;
				Q.offer(new Point(nr, nc, p.t + 1));

				if (tmp == cnt) {
					ans = Math.min(ans, p.t + 1);
					return;
				}
			}
		}
	}
}
