
import java.io.*;
import java.util.*;

public class Solution {
	static int N, K, cnt;
	static boolean[][] v;
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
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());

			int arr[][] = new int[N][N];
			int max = 0;
			for (int i = 0; i < N; i++) {
				StringTokenizer st1 = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					int a = 0;
					arr[i][j] = Integer.parseInt(st1.nextToken());
					a = arr[i][j];
					max = Math.max(max, a);
				}
			}
			cnt = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (arr[i][j] == max) {
						v = new boolean[N][N];
						if(!v[i][j]) {
							v[i][j] = true;
							boolean check = true;
							dfs(arr, i, j, 1, check);
							v[i][j] =false;
						}
						
					}
				}
			}
			System.out.println("#" + tc +" " +cnt);

		}
	}

	static void dfs(int map[][], int r, int c, int dep, boolean check) {
		cnt = Math.max(cnt, dep);
			for (int i = 0; i < 4; i++) {
				int nr = r + dr[i];
				int nc = c + dc[i];

				if (nr < 0 || nr >= N || nc < 0 || nc >= N) continue;
				if (v[nr][nc]) continue;
				if (map[nr][nc] >= map[r][c]) {
					if (map[nr][nc] - K < map[r][c] && check) {
						int a = map[nr][nc];
						map[nr][nc] = map[r][c] -1;
						check = false;
						v[nr][nc] = true;
						dfs(map, nr, nc, dep + 1, check);
						check = true;
						map[nr][nc] = a;
						v[nr][nc] = false;
					}
				} else {
					v[nr][nc] = true;
					dfs(map, nr, nc, dep + 1, check);
					v[nr][nc] = false;
				}
			}
	}

}
