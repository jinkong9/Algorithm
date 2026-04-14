import java.io.*;
import java.util.*;

public class Main {
	static int N, M, sr, sc, er, ec, map[][], ans;
	static char arr[][];
	static boolean v[][], t[][];
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

	static Queue<Point> Tree = new ArrayDeque<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		arr = new char[N][M];
		map = new int[N][M];
		t = new boolean[N][M];

		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			for (int j = 0; j < M; j++) {
				arr[i][j] = s.charAt(j);
				if (arr[i][j] == 'V') {
					sr = i;
					sc = j;
				}
				if (arr[i][j] == 'J') {
					er = i;
					ec = j;
				}
				if (arr[i][j] == '+') {
					Tree.offer(new Point(i, j, 1));
					t[i][j] = true;
				}
			}
		}
		ans = 0;
		treebfs();
		bfs();
		System.out.println(ans);
	}

	static void bfs() {
		PriorityQueue<Point> Q = new PriorityQueue<>((a, b) -> b.t - a.t);
		Q.offer(new Point(sr, sc, map[sr][sc]));
		int dist[][] = new int[N][M];
		for (int i = 0; i < N; i++)
			Arrays.fill(dist[i], -1);
		dist[sr][sc] = map[sr][sc];

		while (!Q.isEmpty()) {
			Point p = Q.poll();
			if (dist[p.r][p.c] > p.t)
				continue;
			if (p.r == er && p.c == ec) {
				ans = p.t;
				return;
			}
			for (int i = 0; i < 4; i++) {
				int nr = p.r + dr[i];
				int nc = p.c + dc[i];

				if (nr < 0 || nr >= N || nc < 0 || nc >= M)
					continue;

				int tmp = Math.min(p.t, map[nr][nc]);

				if(dist[nr][nc] < tmp) {
					dist[nr][nc] = tmp;
					Q.offer(new Point(nr,nc,tmp));
				}
			}
		}
	}

	static void treebfs() {
		while (!Tree.isEmpty()) {
			Point p = Tree.poll();

			for (int i = 0; i < 4; i++) {
				int nr = p.r + dr[i];
				int nc = p.c + dc[i];

				if (nr < 0 || nr >= N || nc < 0 || nc >= M)
					continue;
				if (t[nr][nc])
					continue;
				if (arr[nr][nc] == '+')
					continue;

				t[nr][nc] = true;
				map[nr][nc] = p.t;
				Tree.offer(new Point(nr, nc, p.t + 1));
			}
		}
	}
}
