
import java.io.*;
import java.util.*;
public class Main {
	static int N,M, arr[][], sr,sc,sd, ans;
	static int dr[] = {-1,0,1,0};
	static int dc[] = {0,1,0,-1}; // 상 우 하 좌 순
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		st = new StringTokenizer(br.readLine());
		sr = Integer.parseInt(st.nextToken());
		sc = Integer.parseInt(st.nextToken());
		sd = Integer.parseInt(st.nextToken());
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		ans = 0;
		dfs(sr,sc,sd);
		System.out.println(ans);
	}

	static void dfs(int r, int c, int d) { // 상우하좌 반시계 돌리면 
		// 1번 경우 현재 칸 청소
		if(arr[r][c] == 0) {
			ans +=1;
			arr[r][c] = 2;
		}
		
		boolean ok = true;
		for(int i=0; i<4; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];
			
			if(nr <0 || nr >=N || nc <0 || nc >=M) {
				continue;
			}
			if(arr[nr][nc] ==0) {
				ok = false;
			}
		}
		
		if(!ok) { // 3번 경유
			for(int i=0; i<4; i++) {
				d = (d+3) % 4;
				int nr = r + dr[d];
				int nc = c + dc[d];
				if(arr[nr][nc] == 0) {
					dfs(nr,nc,d);
					return;
				}
			}
		} else { // 2번 경우
			int nd = (d +2) % 4;
			int nr = r + dr[nd];
			int nc = c + dc[nd];
			if(arr[nr][nc] == 1) return;
			dfs(nr,nc,d);
		}
		
	}
}
