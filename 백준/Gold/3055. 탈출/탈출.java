import java.io.*;
import java.util.*;
public class Main {
	static int N,M,sr,sc,er,ec,map[][], ans;
	static char arr[][];
	static int dr[] = {-1,1,0,0};
	static int dc[] = {0,0,-1,1};
	static class Point {
		int r,c,t;
		Point(int r, int c, int t) {
			this.r = r;
			this.c = c;
			this.t = t;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new char[N][M];
		
		for(int i=0; i<N; i++) {
			String s = br.readLine();
			for(int j=0; j<M; j++) {
				arr[i][j] = s.charAt(j);
				if(arr[i][j] == 'S') {
					sr = i; sc = j;
				}
				if(arr[i][j] == 'D') {
					er = i; ec = j;
				}
			}
		}
		ans = 0;
		// sr -> 고슴도치 / er -> 비버굴
		bfs1();
		bfs(sr,sc);
		if(ans==0) System.out.println("KAKTUS");
		else System.out.println(ans);
	}

	static void bfs(int r, int c) {
		boolean v[][] = new boolean [N][M];
		v[r][c] = true;
		Queue <Point> Q = new ArrayDeque<>();
		Q.offer(new Point(r,c,0));
		
		while(!Q.isEmpty()) {
			Point p = Q.poll();
			if(p.r == er && p.c == ec) {
				ans = p.t;
			}
			
			for(int i=0; i<4; i++) {
				int nr = p.r + dr[i];
				int nc = p.c + dc[i];
				
				if(nr <0 || nr >= N || nc <0 || nc >= M) continue;
				if(v[nr][nc]) continue;
				if(arr[nr][nc] == 'X') continue;
				if(map[nr][nc] != -1 && map[nr][nc] <= p.t +1) continue;
				
				v[nr][nc] = true;
				Q.offer(new Point(nr,nc,p.t+1));
			}
		}
	}
	
	static void bfs1() {
		map = new int[N][M];
		Queue <Point> Q = new ArrayDeque<>();
		for(int i=0; i<N; i++) Arrays.fill(map[i], -1);
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(arr[i][j] == '*') {
					Q.offer(new Point(i,j, 0));
					map[i][j] = 0;
				}
			}
		}
		
		while(!Q.isEmpty()) {
			Point p = Q.poll();
			
			for(int i=0; i<4; i++) {
				int nr = p.r + dr[i];
				int nc = p.c + dc[i];
				
				if(nr <0 || nr >= N || nc <0 || nc >= M) continue;
				if(map[nr][nc] != -1) continue;
				if(arr[nr][nc] == 'X') continue;
				if(arr[nr][nc] == 'D' || arr[nr][nc] == 'S') continue;
				map[nr][nc] = p.t +1;
				Q.offer(new Point(nr,nc,p.t +1));
			}
		}
	}
}
