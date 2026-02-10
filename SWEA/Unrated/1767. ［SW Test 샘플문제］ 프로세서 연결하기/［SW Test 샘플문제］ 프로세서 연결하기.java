
import java.io.*;
import java.util.*;

public class Solution {
	static int N, cnt, arr[][];
	static int dr[] = { -1, 1, 0, 0 };
	static int dc[] = { 0, 0, -1, 1 };
	static boolean[][] v;
	static int max, min;

	static class Point {
		int r, c;

		Point(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

	static ArrayList<Point> list;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			arr = new int[N][N];
			v = new boolean[N][N];
			list = new ArrayList<>();

			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			for (int i = 1; i < N - 1; i++) {
				for (int j = 1; j < N - 1; j++) {
					if (arr[i][j] == 1)
						list.add(new Point(i, j));
				}
			}

			max = 0;
			min = Integer.MAX_VALUE;

			dfs(0, 0, 0);

			System.out.println("#" + tc + " " + min);
		}
	}

	static void dfs(int idx, int cnt, int len) {
		if (idx == list.size()) {
			if (cnt > max) {
				max = cnt;
				min = len;
			} else if (cnt == max) {
				min = Math.min(min, len);
			}
			return;
		}

		Point p = list.get(idx);

		for (int d = 0; d < 4; d++) {
			int r = p.r;
			int c = p.c;
			int l = 0;
			boolean ok = true;

			while (true) {
				r += dr[d];
				c += dc[d];
				if (r < 0 || r >= N || c < 0 || c >= N)
					break;
				if (arr[r][c] == 1 || v[r][c]) {
					ok = false;
					break;
				}
				l++;
			}
			if (!ok)
				continue;

			r = p.r;
			c = p.c;
			for (int i = 0; i < l; i++) {
				r += dr[d];
				c += dc[d];
				v[r][c] = true;
			}

			dfs(idx + 1, cnt + 1, len + l);

			r = p.r;
			c = p.c;
			for (int i = 0; i < l; i++) {
				r += dr[d];
				c += dc[d];
				v[r][c] = false;
			}
		}

		dfs(idx +1, cnt, len);
	}
}