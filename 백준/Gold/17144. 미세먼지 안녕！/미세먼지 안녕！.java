
import java.io.*;
import java.util.*;

public class Main {
	static int R, C, T, arr[][], rr, rc, rr1, rc1;
	static int dr1[] = { 0, -1, 0, 1 };
	static int dc1[] = { 1, 0, -1, 0 };
	static int dr2[] = { 0, 1, 0, -1 };
	static int dc2[] = { 1, 0, -1, 0 };

	static class Point {
		int r, c, t;

		Point(int r, int c, int t) {
			this.r = r;
			this.c = c;
			this.t = t;
		}
	}

	static ArrayList<Point> list;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken()); // 작동시간

		arr = new int[R][C];
		int map[][] = new int[2][2];
		int idx = 0;
		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < C; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if (arr[i][j] == -1) {
					map[idx][0] = i;
					map[idx][1] = j;
					idx++;
				}
			}
		}
		// 로봇청소기, 미세먼지 따로
		list = new ArrayList<>();
		rr = map[0][0];
		rc = map[0][1];
		rr1 = map[1][0];
		rc1 = map[1][1];
		for (int i = 0; i < T; i++) {
			spread();
			dfs1(0);
			dfs2(0);
		}
		int sum = 0;
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (arr[i][j] > 0)
					sum += arr[i][j];
			}
		}
		System.out.println(sum);
	}

	static void dfs1(int d) {
		int r = rr;
		int c = rc;
		int tmp = 0;
		while (true) {
			int nr = r + dr1[d];
			int nc = c + dc1[d];
			if (nr < 0 || nr >= R || nc < 0 || nc >= C) {
				d = (d + 1) % 4;
				continue;
			}
			
			if(nr == rr && nc == rc) break;
			
			int tt = arr[nr][nc];
			arr[nr][nc] = tmp;
			tmp	= tt;
			
			r = nr;
			c = nc;
		}
	}

	static void dfs2(int d) {
		int r = rr1;
		int c = rc1;
		int tmp = 0;
		while (true) {
			int nr = r + dr2[d];
			int nc = c + dc2[d];
			if (nr < 0 || nr >= R || nc < 0 || nc >= C) {
				d = (d + 1) % 4;
				continue;
			}
			
			if(nr == rr1 && nc == rc1) break;
			
			int tt = arr[nr][nc];
			arr[nr][nc] = tmp;
			tmp	= tt;
			
			r = nr;
			c = nc;
		}
	}

	static void spread() {
		int temp[][] = new int[R][C];

		for (int r = 0; r < R; r++) {
			for (int c = 0; c < C; c++) {
				if (arr[r][c] > 0) {

					int cnt = 0;

					for (int d = 0; d < 4; d++) {
						int nr = r + dr1[d];
						int nc = c + dc1[d];

						if (nr < 0 || nr >= R || nc < 0 || nc >= C)
							continue;
						if (arr[nr][nc] == -1)
							continue;

						temp[nr][nc] += arr[r][c] / 5;
						cnt++;
					}

					temp[r][c] += arr[r][c] - (arr[r][c] / 5) * cnt;
				}
			}
		}
		temp[rr][0] = -1;
		temp[rr1][0] = -1;
		arr = temp;
	}

}
