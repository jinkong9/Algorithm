import java.io.*;
import java.util.*;

public class Main {
	static int N, M, arr[][];
	static int dr[] = { -1, 1, 0, 0 };
	static int dc[] = { 0, 0, -1, 1 };
	static boolean v[][];

	static class Point {
		int r, c;

		Point(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		
		int max = 0;
		
		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			for (int j = 0; j < M; j++) {
				arr[i][j] = s.charAt(j) - '0';
				max = Math.max(max, arr[i][j]);
			}
		}
		int ans = 0;
		for (int h = 2; h <= max; h++) {
			v = new boolean[N][M];
			for (int i = 1; i < N-1; i++) {
				for (int j = 1; j < M-1; j++) {
					if (!v[i][j] && arr[i][j] < h) {
						ans += bfs(i, j, h);
					}
				}
			}
		}
		System.out.println(ans);
	}

	static int bfs(int r, int c, int h) {
		Queue<Point> Q = new ArrayDeque<>();
		Q.offer(new Point(r, c));
		v[r][c] = true;
		boolean f = false;
		int cnt = 1;
		while (!Q.isEmpty()) {
			Point p = Q.poll();
			for (int i = 0; i < 4; i++) {
				int nr = p.r + dr[i];
				int nc = p.c + dc[i];

				if (nr < 0 || nr >= N || nc < 0 || nc >= M)
					continue;
				if (v[nr][nc]) continue;

				if (arr[nr][nc] < h) {
				    if (nr == 0 || nr == N - 1 || nc == 0 || nc == M - 1) {
				        f = true;
				    }

				    v[nr][nc] = true;
				    Q.offer(new Point(nr, nc));
				    cnt++;
				}
			}
		}
		if (f)
			return 0;
		else
			return cnt;
	}
}
