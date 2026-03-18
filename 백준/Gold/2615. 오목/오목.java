
import java.io.*;
import java.util.*;

public class Main {
	static int arr[][], cnt, sr, sc;
	static int dr[] = { 0, 1, 1, 1 };
	static int dc[] = { 1, 0, 1, -1 };
	static boolean v[][];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		arr = new int[19][19];
		v = new boolean[19][19];
		for (int i = 0; i < 19; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 19; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		cnt = 0;
		for (int i = 0; i < 19; i++) {
			for (int j = 0; j < 19; j++) {
					if (arr[i][j] == 0) continue;
						if (dfs(i, j, arr[i][j])) {
							System.out.println(cnt);
							System.out.println(sr + " " + sc);
							return;
					} 
				}
			}
		System.out.println(0);
	}

	static boolean dfs(int r, int c, int t) {
		for (int i = 0; i < 4; i++) {
			int tmp = 1;
			int tr = r - dr[i];
			int tc = c - dc[i];
			if (tr >= 0 && tr < 19 && tc >= 0 && tc < 19 && arr[tr][tc] == arr[r][c])
				continue;
			int nr = r;
			int nc = c;

			while (true) {
				nr += dr[i];
				nc += dc[i];
				if (nr < 0 || nr >= 19 || nc < 0 || nc >= 19)
					break;
				if (arr[nr][nc] != arr[r][c])
					break;
				tmp++;
			}
			
			
			if (tmp == 5) {
				int nr2 = r + dr[i] * 5;
				int nc2 = c + dc[i] * 5;

				if (nr2 >= 0 && nr2 < 19 && nc2 >= 0 && nc2 < 19 && arr[nr2][nc2] == arr[r][c])
					continue;
				
				if(i == 3) {
					cnt = arr[r][c];
					sr = r + 5;
					sc = c - 3;
				} else {
					cnt = arr[r][c];
					sr = r + 1;
					sc = c + 1;
				}
				return true;
			}
		}
		return false;
	}
}
