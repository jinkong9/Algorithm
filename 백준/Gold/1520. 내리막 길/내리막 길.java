import java.io.*;
import java.util.*;

public class Main {
	static int dr[] = { -1, 1, 0, 0 };
	static int dc[] = { 0, 0, -1, 1 };
	static int N, M, arr[][], ans, memo[][];
	static boolean v[][];
	static boolean ch[][];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		memo = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				memo[i][j] = -1;
			}
		}

		int a = dfs(0, 0);
		System.out.println(a);
	}

	static int dfs(int r, int c) {
		if (r == N - 1 && c == M - 1) {
			return 1;
		}

		if (memo[r][c] == -1) {
			memo[r][c] = 0;
			for (int i = 0; i < 4; i++) {
				int nr = r + dr[i];
				int nc = c + dc[i];
				if (nr < 0 || nr >= N || nc < 0 || nc >= M)
					continue;
				if (arr[nr][nc] < arr[r][c]) {
					memo[r][c] += dfs(nr,nc);
				}
			}
		}
		return memo[r][c];
	}
}
