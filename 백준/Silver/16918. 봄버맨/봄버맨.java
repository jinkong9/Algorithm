
import java.io.*;
import java.util.*;

public class Main {
	static int R, C, N;
	static char arr[][];
	static int dr[] = { -1, 1, 0, 0 };
	static int dc[] = { 0, 0, -1, 1 };

	static class Point {
		int r, c;

		Point(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

	static Queue<Point> Q;
	static StringBuilder sb;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		arr = new char[R][C];
		Q = new ArrayDeque<>();
		for (int i = 0; i < R; i++) {
			String s = br.readLine();
			for (int j = 0; j < C; j++) {
				arr[i][j] = s.charAt(j);
				if (arr[i][j] == 'O')
					Q.offer(new Point(i, j));
			}
		}
		for (int i = 2; i <= N; i++) {
			if (i % 2 == 0) {
				install();
			} else {
				bfs();
			}
		}
		print();
		System.out.println(sb);
	}

	static void install() {
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (arr[i][j] == '.') {
					arr[i][j] = 'O';
				}
			}
		}
	}

	static void bfs() {

		int size = Q.size();
		boolean[][] bomb = new boolean[R][C];

		for (int i = 0; i < size; i++) {
			Point p = Q.poll();
			bomb[p.r][p.c] = true;
		}

		for (int r = 0; r < R; r++) {
			for (int c = 0; c < C; c++) {

				if (!bomb[r][c])
					continue;

				arr[r][c] = '.';

				for (int d = 0; d < 4; d++) {
					int nr = r + dr[d];
					int nc = c + dc[d];

					if (nr < 0 || nr >= R || nc < 0 || nc >= C)
						continue;

					arr[nr][nc] = '.';
				}

			}
		}

		Q.clear();

		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (arr[i][j] == 'O')
					Q.offer(new Point(i, j));
			}
		}

	}

	static void print() {
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				sb.append(arr[i][j]);
			}
			sb.append("\n");
		}
	}
}
