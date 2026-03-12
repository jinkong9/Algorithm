
import java.io.*;
import java.util.*;

public class Solution {
	static int N, H, W, arr[][], ans;
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
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());
			arr = new int[H][W];

			for (int i = 0; i < H; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < W; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			ans = Integer.MAX_VALUE;
			perm(0, new int[N]);
			sb.append("#").append(tc).append(" ").append(ans).append("\n");
		}
		System.out.println(sb);
	}

	static void perm(int idx, int sel[]) { // 순열
		if (idx == N) {
			int r = 0;
			int c = 0;
			int p = 0;
			int map[][] = new int[H][W];
			for (int x = 0; x < H; x++)
				map[x] = arr[x].clone();
			for (int i = 0; i < sel.length; i++) {
			    c = sel[i];
			    r = -1; p = 0;
			    for (int j = 0; j < H; j++) {
			        if (map[j][c] != 0) {
			            r = j;
			            p = map[j][c];
			            break;
			        }
			    } // 한 열에 벽돌이 아예 없을 때 경우 컷
			    if (r == -1) continue;
			    dfs(r, c, p, map);
			    gravity(map);
			}
			bfs(map);
			return;
		}
		for (int i = 0; i < W; i++) {
			sel[idx] = i;
			perm(idx + 1, sel);
		}
	}

	static void dfs(int r, int c, int p, int map[][]) { // 벽돌깨기
		map[r][c] = 0;
		for (int d = 0; d < 4; d++) {
			int nr = r;
			int nc = c;
			for (int x = 0; x < p - 1; x++) {
				nr = nr + dr[d];
				nc = nc + dc[d];
				if (nr < 0 || nr >= H || nc < 0 || nc >= W)
					break;
				if (map[nr][nc] == 1) {
					map[nr][nc] = 0;
				} else if (map[nr][nc] > 1) {
					dfs(nr, nc, map[nr][nc], map);
				}
			}
		}
	}

	static void bfs(int map[][]) { // 벽돌세기
		int tmp = 0;
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				if (map[i][j] != 0)
					tmp++;
			}
		}
		ans = Math.min(ans, tmp);
	}

	static void gravity(int map[][]) {
		for (int c = 0; c < W; c++) {
			int idx = H - 1;
			for (int r = H - 1; r >= 0; r--) {
				if (map[r][c] != 0) {
					int tmp = map[r][c];
					map[r][c] = 0;
					map[idx][c] = tmp;
					idx--;
				}
			}
		}
	}
}
