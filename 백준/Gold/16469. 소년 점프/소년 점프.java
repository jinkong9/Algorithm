import java.io.*;
import java.util.*;

public class Main {
	static int R, C, arr[][], r1, r2, r3, c1, c2, c3;
	static int dr[] = { -1, 1, 0, 0 };
	static int dc[] = { 0, 0, -1, 1 };

	static class Point {
		int r, c, t, num;

		Point(int r, int c, int t, int num) {
			this.r = r;
			this.c = c;
			this.t = t;
			this.num = num;
		}
	}

	static int v[][][] = new int[R][C][3];
	static ArrayList<Integer> list;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		arr = new int[R][C];

		for (int i = 0; i < R; i++) {
			String s = br.readLine();
			for (int j = 0; j < C; j++) {
				arr[i][j] = s.charAt(j) - '0';
			}
		}

		st = new StringTokenizer(br.readLine());
		r1 = Integer.parseInt(st.nextToken()) - 1;
		c1 = Integer.parseInt(st.nextToken()) - 1;
		st = new StringTokenizer(br.readLine());
		r2 = Integer.parseInt(st.nextToken()) - 1;
		c2 = Integer.parseInt(st.nextToken()) - 1;
		st = new StringTokenizer(br.readLine());
		r3 = Integer.parseInt(st.nextToken()) - 1;
		c3 = Integer.parseInt(st.nextToken()) - 1;

		v = new int[R][C][3];
		list = new ArrayList<>();
		bfs();
		check();
		Collections.sort(list);
		if (list.size() == 0) {
			System.out.println(-1);
		} else {
			int cnt = 0;
			int a = list.get(0);
			for (int i = 0; i < list.size(); i++) {
				if (list.get(i) == a)
					cnt++;
				else break;
			}
			System.out.println(a);
			System.out.println(cnt);
		}
	}

	static void bfs() {
		Queue<Point> Q = new ArrayDeque<>();
		Q.offer(new Point(r1, c1, 0, 0));
		Q.offer(new Point(r2, c2, 0, 1));
		Q.offer(new Point(r3, c3, 0, 2));
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++)
				Arrays.fill(v[i][j], -1);
		}
		v[r1][c1][0] = 0;
		v[r2][c2][1] = 0;
		v[r3][c3][2] = 0;
		while (!Q.isEmpty()) {
			Point p = Q.poll();
			int num = p.num;

			for (int i = 0; i < 4; i++) {
				int nr = p.r + dr[i];
				int nc = p.c + dc[i];

				if (nr < 0 || nr >= R || nc < 0 || nc >= C)
					continue;
				if (v[nr][nc][num] != -1)
					continue;
				if (arr[nr][nc] == 1)
					continue;
				v[nr][nc][num] = p.t + 1;
				Q.offer(new Point(nr, nc, p.t + 1, num));
			}
		}
	}

	static void check() {
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (v[i][j][0] != -1 && v[i][j][1] != -1 && v[i][j][2] != -1) {
					int maxT = Math.max(v[i][j][0], Math.max(v[i][j][1], v[i][j][2]));
					list.add(maxT);
				}
			}
		}
	}
}
