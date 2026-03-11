import java.io.*;
import java.util.*;
public class Main {
	static int N,M, arr[][], ans;
	static int dr[] = {-1,1,0,0};
	static int dc[] = {0,0,-1,1};
	static class Point {
		int r,c,len, sum;
		boolean v[][];
		Point(int r, int c, int len, int sum, boolean v[][]) {
			this.r = r;
			this.c = c;
			this.len = len;
			this.sum = sum;
			this.v = v;
		}
	}
	static boolean v[][];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N =Integer.parseInt(st.nextToken());
		M =Integer.parseInt(st.nextToken());
		
		arr = new int[N][M];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		ans = 0;
		boolean v[][] = new boolean[N][M];
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
					v[i][j] = true;
					dfs(0,i,j, arr[i][j], v);
					fuck(i,j);
                    v[i][j] = false;
			}
		}
		System.out.println(ans);
	}

	static void fuck(int r, int c) { // 상하좌우
		for(int i=0; i<4; i++) {
			int sum = 0;
			int cnt = 0;
			sum += arr[r][c];
			int nr = r;
			int nc = c;
			while(true) {
				if(cnt == 2) {
					ans = Math.max(sum, ans);
					break;
				}
				if(cnt == 1) {
					int tmp = 0;
					for(int j=0; j<4; j++) {
						if(i == 0 && (j == 0 || j == 1)) continue;
						if(i == 1 && (j == 0 || j == 1)) continue;
						if(i == 2 && (j == 2 || j == 3)) continue;
						if(i == 3 && (j == 2 || j == 3)) continue;
						int tr = nr + dr[j];
						int tc = nc + dc[j];
						if(tr <0 || tr >= N || tc <0 || tc >=M) continue;
						if(tr == r && tc == c) continue;

						tmp = Math.max(tmp, arr[tr][tc]);
					}
					sum += tmp;
				}
				nr += dr[i];
				nc += dc[i];
				if(nr <0 || nr >= N || nc <0 || nc >=M) break;
//				System.out.println(nr + " " + nc);
				sum += arr[nr][nc];
				cnt ++;
			}
		}
	}
	
	static void dfs(int idx, int r, int c, int sum , boolean v[][]) {
		if(idx == 3) {
			ans = Math.max(ans, sum);
			return;
		}
		for(int i=0; i<4; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];
			
			if(nr <0 || nr >=N || nc <0 || nc >=M) continue;
			if(v[nr][nc]) continue;
			v[nr][nc] = true;
			dfs(idx+1,nr,nc,sum + arr[nr][nc],v);
			v[nr][nc] = false;
		}
	}
}
