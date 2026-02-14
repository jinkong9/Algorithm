
import java.io.*;
import java.util.*;

public class Main {
	static int R, C, cnt, sr, sc, endr, endc, map[][];
	static char arr[][];
	static boolean v[][];
	static int dr[] = { -1, 1, 0, 0 };
	static int dc[] = { 0, 0, -1, 1 };

	static class Point {
		int r, c, time;

		Point(int r, int c, int time) {
			this.r = r;
			this.c = c;
			this.time = time;
		}
	}

	static Queue<Point> Q;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		arr = new char[R][C];

		for (int i = 0; i < R; i++) {
			String s = br.readLine();
			for (int j = 0; j < C; j++) {
				arr[i][j] = s.charAt(j);
				if (arr[i][j] == 'J') {
					sr = i;
					sc = j;
				}
			}
		}
		Q = new ArrayDeque<>();
		v = new boolean[R][C];
		Q.offer(new Point(sr, sc, 0));
		v[sr][sc] = true;
		cnt = Integer.MAX_VALUE;
		burn();
		bfs(sr, sc);
		if (cnt == Integer.MAX_VALUE) {
			System.out.println("IMPOSSIBLE");
		} else {
			System.out.println(cnt + 1);
		}
	}

	static void burn() {
		map = new int[R][C];
		for (int i = 0; i < R; i++) {
			Arrays.fill(map[i], -1);
		}
		Queue<Point> F = new ArrayDeque<>();
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (arr[i][j] == 'F') {
					F.offer(new Point(i, j, 0));
					map[i][j] = 0;
				}
			}
		}

		while (!F.isEmpty()) {
			Point p = F.poll();
			int pr = p.r;
			int pc = p.c;
			int pt = p.time;
			for (int i = 0; i < 4; i++) {
				int nr = pr + dr[i];
				int nc = pc + dc[i];

				if (nr < 0 || nr >= R || nc < 0 || nc >= C)
					continue;
				if (arr[nr][nc] == '#')
					continue;
				if (map[nr][nc] != -1) {
					continue;
				}
				map[nr][nc] = pt + 1;
				F.offer(new Point(nr, nc, pt + 1));
			}
		}
	}

	static void bfs(int r, int c) { // F를 어떻게 바꿀지
		while (!Q.isEmpty()) {
			Point p = Q.poll();
			int pr = p.r;
			int pc = p.c;
			int pt = p.time;

			if (pr == 0 || pr == R - 1 || pc == 0 || pc == C - 1) {
				cnt = Math.min(cnt, pt);
				return;
			}

			for (int i = 0; i < 4; i++) {
				int nr = pr + dr[i];
				int nc = pc + dc[i];

				if (nr < 0 || nr >= R || nc < 0 || nc >= C)
					continue;
				if (v[nr][nc])
					continue;
				if (arr[nr][nc] == '#')
					continue;
				if (map[nr][nc] != -1 && map[nr][nc] <= pt + 1) 
					continue;
				v[nr][nc] = true;
				Q.offer(new Point(nr, nc, pt + 1));
			}
		}
	}

}
