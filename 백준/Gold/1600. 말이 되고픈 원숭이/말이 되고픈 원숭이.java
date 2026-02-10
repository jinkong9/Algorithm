
import java.io.*;
import java.util.*;

public class Main {
	static int arr[][], N, M, K, a;
	static int cnt = Integer.MAX_VALUE;
	static int dr[] = { -1,1,0,0,-2,-2,2,2,-1,-1,1,1 };
	static int dc[] = { 0,0,-1,1,-1,1,-1,1,-2,2,-2,2 };
	static boolean v[][][];

	static class Point {
		int r, c, w, k;

		Point(int r, int c, int w, int k) {
			this.r = r;
			this.c = c;
			this.w = w;
			this.k = k;
		}
	}


	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		K = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[M][N];
		for (int i = 0; i < M; i++) {
			StringTokenizer st1 = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st1.nextToken());
			}
		}
		bfs(K);
		if(cnt == Integer.MAX_VALUE) {
			System.out.println(-1);
		} else {
			System.out.println(cnt);
		}
	}

	static void bfs(int A) {
		v = new boolean[M][N][A+1];
		v[0][0][A] = true;
		Queue<Point> Q = new ArrayDeque<>();
		Q.offer(new Point(0, 0, 0, K));
		while (!Q.isEmpty()) {
			Point p = Q.poll();
			int pr = p.r;
			int pc = p.c;
			int pw = p.w;
			int pk = p.k;

			if (pr == M-1 && pc == N-1) {
				cnt = pw;
				return;
			}

			int a = (pk > 0) ? 12 : 4;

			for (int i = 0; i < a; i++) {
				int nr = pr + dr[i];
				int nc = pc + dc[i];

				if (nr < 0 || nr >= M || nc < 0 || nc >= N) continue;
				if (arr[nr][nc] == 1) continue;

				if (i >= 4) { 
					if (pk == 0) continue;
					if (v[nr][nc][pk-1]) continue;
					v[nr][nc][pk-1] = true;
					Q.offer(new Point(nr, nc, pw+1, pk-1));
				} else {
					if (v[nr][nc][pk]) continue;
					v[nr][nc][pk] = true;
					Q.offer(new Point(nr, nc, pw+1, pk));
				}
			}
		}

	}
}
