
import java.io.*;
import java.util.*;
public class Main {
	static int N,arr[][], sum, memo[][];
	static int dr[]  = {-1,1,0,0};
	static int dc[]  = {0,0,-1,1};
	static class Point {
		int r,c,w;
		Point(int r, int c, int w) {
			this.r = r;
			this.c = c;
			this.w = w;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		memo = new int[N][N];
		
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		sum = 0;
		int a = 0;
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				a = Math.max(a, dfs(i,j));
			}
		}
		System.out.println(a+1);
	}

	static int dfs(int r, int c) {
		if(memo[r][c] != 0 ) return memo[r][c];
		else {
			for(int i=0; i<4; i++) {
				int nr = r + dr[i];
				int nc = c + dc[i];
				
				if(nr < 0 || nr >= N || nc < 0 || nc >= N) continue;
				if(arr[nr][nc] <= arr[r][c]) continue;
				memo[r][c] = Math.max(memo[r][c], dfs(nr,nc) +1);
			}
		}
		
		return memo[r][c];
	}
}
