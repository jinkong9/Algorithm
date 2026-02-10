
import java.io.*;
import java.util.*;

public class Main {
	static int arr[][], N, M, cnt;
	static int dr[] = { -1, 1, 0, 0 };
	static int dc[] = { 0, 0, -1, 1 };
	static boolean v[][][];

	static class Point {
		int r, c, broke, dist;

		Point(int r, int c, int broke, int dist) {
			this.r = r;
			this.c = c;
			this.broke = broke;
			this.dist = dist;
		}
	}


	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			for (int j = 0; j < M; j++) {
				arr[i][j] = s.charAt(j) - '0';
			}
		}
		System.out.println(bfs());
	}

	static int bfs() {
		v = new boolean[N][M][2];
		v[0][0][arr[0][0]] = true;
		Queue<Point> Q = new ArrayDeque<>();
		Q.offer(new Point(0, 0,0,0));
		while (!Q.isEmpty()) {
			Point p = Q.poll();
			int pr = p.r;
			int pc = p.c;
			int pbroke = p.broke;
			int pdist = p.dist;
			if (pr == N - 1 && pc == M - 1)
				return pdist +1;
			for (int i = 0; i < 4; i++) {
				int nr = pr + dr[i];
				int nc = pc + dc[i];

				if (nr < 0 || nr >= N || nc < 0 || nc >= M)
					continue;
				if(!v[nr][nc][pbroke] && arr[nr][nc] == 1 && pbroke == 0) {
					v[nr][nc][1] = true;
					Q.offer(new Point(nr,nc,1, pdist +1));
				}
				if(!v[nr][nc][pbroke] && arr[nr][nc] == 0) {
					v[nr][nc][pbroke] = true;
					Q.offer(new Point(nr,nc,pbroke, pdist +1));
				}
			}
		}
		return -1;
	}
}
