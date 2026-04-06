import java.io.*;
import java.util.*;
public class Main {
	static int N,M, arr[][], ans[][], cnt;
	static boolean v[][];
	static int dr[] = {-1,1,0,0};
	static int dc[] = {0,0,-1,1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new int[N][M];
		ans = new int[N][M];
		v = new boolean[N][M];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				ans[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		cnt = 0;
		boolean f= false;
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(arr[i][j] != ans[i][j] && !v[i][j]) {
					v[i][j] = true;
					dfs(i,j, ans[i][j], arr[i][j]);
					f = true;
					break;
				}
				if(f) break;
			}
			if(f) break;
		}
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(ans[i][j] != arr[i][j]) {
					System.out.println("NO");
					System.exit(0);
				}
			}
		}
		System.out.println("YES");
	}

	static void dfs(int r, int c, int a, int b) {
		arr[r][c] = a;
		for(int i=0; i<4; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];
			if(nr <0 || nr >= N || nc <0 || nc >=M) continue;
			if(v[nr][nc]) continue;
			if(b != arr[nr][nc]) continue;
			v[nr][nc] = true;
			dfs(nr,nc,a,b);
		}
	}
	
}
