import java.io.*;
import java.util.*;

public class Main {
	static int N, M, arr[][], copy[][], cnt, sum;
	static boolean v[][];
	static int dr[] = { -1, 1, 0, 0 };
	static int dc[] = { 0, 0, -1, 1 };

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
		copy = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				copy[i][j] = arr[i][j];
			}
		}
		sum = cnt = 0;
		while (true) {
			v = new boolean[N][M];
			int tt = 0;
			for(int i=0; i<N; i++) {
				copy[i] = arr[i].clone();
			}
			bfs(0,0); // 외부공기 -1로 마스킹
			
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (copy[i][j] == 1) {
						if(check(i, j)) {
							tt ++;
						}
					}
				}
			} 
			if (tt == 0) break;
			
			for (int i = 0; i < N; i++) {
			    arr[i] = copy[i].clone();
			}
			
			cnt ++;
		}
		System.out.println(cnt);
	}

	static boolean check(int r, int c) {
		int count = 0;
		for (int i = 0; i < 4; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];
			if (nr < 0 || nr >= N || nc < 0 || nc >= M)
				continue;
			if (copy[nr][nc] == -1) {
				count ++;
			}
		}
		if(count >= 2) {
			copy[r][c] = 0;
			return true;
		}
		return false;
	}


	static void bfs(int r, int c) {
		Queue<Point> Q = new ArrayDeque<>();
		v[r][c] = true;
		Q.offer(new Point(r, c));
		copy[r][c] = -1;
		while (!Q.isEmpty()) {
			Point p = Q.poll();
			for (int i = 0; i < 4; i++) {
				int nr = p.r + dr[i];
				int nc = p.c + dc[i];

				if (nr < 0 || nr >= N || nc < 0 || nc >= M)
					continue;
				if (v[nr][nc])
					continue;
				if (arr[nr][nc] == 1)
					continue;
				copy[nr][nc] = -1;
				v[nr][nc] = true;
				Q.offer(new Point(nr, nc));
			}
		}
	}
}
