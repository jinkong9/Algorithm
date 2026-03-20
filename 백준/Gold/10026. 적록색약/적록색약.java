
import java.io.*;
import java.util.*;
public class Main {
	static int N;
	static char arr[][];
	static int ans, ans1;
	static int a[] = new int[2];
	static boolean v[][], v1[][];
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
		N = Integer.parseInt(br.readLine());
		arr = new char[N][N];
		
		for(int i=0; i<N; i++) {
			String s = br.readLine();
			for(int j=0; j<N; j++) {
				arr[i][j] = s.charAt(j);
			}
		}
		v = new boolean[N][N];
		v1 = new boolean[N][N];
		ans = 0;
		ans1 = 0;
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(!v[i][j]) {
					bfs(i,j);
				}
			}
		}
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(!v1[i][j]) {
					bfs1(i,j);
				}
			}
		}
		System.out.println(ans);
		System.out.println(ans1);
	}
	
	static void bfs(int r , int c) { // 일반
		Queue <Point> Q = new ArrayDeque<>();
		Q.offer(new Point(r,c));
		v[r][c] = true;
		
		while(!Q.isEmpty()) {
			Point p = Q.poll();
			
			for(int i=0; i<4; i++) {
				int nr = p.r + dr[i];
				int nc = p.c + dc[i];
				
				if(nr <0 || nr >=N || nc <0 || nc >=N) continue;
				if(v[nr][nc]) continue;
				if(arr[r][c] != arr[nr][nc]) continue;
				v[nr][nc] = true;
				Q.offer(new Point(nr,nc));
			}
		}
		ans ++;
	}
	
	static void bfs1(int r , int c) { // 색맹
		Queue <Point> Q = new ArrayDeque<>();
		Q.offer(new Point(r,c));
		v1[r][c] = true;
		char a = arr[r][c];
		while(!Q.isEmpty()) {
			Point p = Q.poll();
			
			for(int i=0; i<4; i++) {
				int nr = p.r + dr[i];
				int nc = p.c + dc[i];
				
				if(nr <0 || nr >=N || nc <0 || nc >=N) continue;
				if(v1[nr][nc]) continue;
				if(a == 'B') {
					if(arr[nr][nc] != 'B') continue;
				} else {
					if(arr[nr][nc] == 'B') continue;
				}
				
				v1[nr][nc] = true;
				Q.offer(new Point(nr,nc));
			}
		}
		ans1 ++;
	}
}
