
import java.io.*;
import java.util.*;

public class Main {
	static int dr[] = { 1, 1, 0 };
	static int dc[] = { 0, 1, 1 };
	static int arr[][];
	static boolean v[][];
	static int T, cnt;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		arr = new int[T][T];

		for (int i = 0; i < T; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < T; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		v = new boolean[T][T];
		dfs(0, 1, 2);
		System.out.println(cnt);
	}

	static void dfs(int r, int c, int d) { // 하 우하 우
		if(r == T-1 && c == T-1) {
			cnt ++;
			return;
		}
		for(int i=0; i<3; i++) {
			if(d == 2 && i ==0) continue;
			if(d == 0 && i ==2) continue;
			int nr = r+dr[i];
			int nc = c + dc[i];
			
			if(nr >=0 && nr<T && nc >=0 && nc <T && arr[nr][nc] == 0) {
				if(i == 1) {
					if(arr[r][c+1] == 1 || arr[r+1][c] == 1 || arr[r+1][c+1] == 1) continue;
				}
				if(!v[nr][nc]) {
					v[nr][nc] = true;
					dfs(nr,nc,i);
					v[nr][nc] = false;
				}
			}
		}
		
	}
}
