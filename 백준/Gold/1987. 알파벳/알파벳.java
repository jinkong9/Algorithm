import java.io.*;
import java.util.*;

public class Main {
	static int R, C, max;
	static char arr[][];
	static boolean v[];
	static int dr[] = { -1, 1, 0, 0 };
	static int dc[] = { 0, 0, -1, 1 };

	static class Point {
		int r, c, w;

		Point(int r, int c, int w) {
			this.r = r;
			this.c = c;
			this.w = w;
		}
	}

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
			}
		}
		max = 0;
		v = new boolean[26];
		dfs(0, 0, 0);
		System.out.println(max+1);
	}

	static void dfs(int r, int c, int cnt) {
		max = Math.max(max, cnt);
		v[arr[r][c] - 'A'] = true;
		for (int i = 0; i < 4; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];
			if (nr < 0 || nr >= R || nc < 0 || nc >= C)
				continue;
			if(!v[arr[nr][nc] -'A']) {
				dfs(nr, nc, cnt + 1);
			}
		}
		v[arr[r][c] - 'A'] = false;
	}
}
