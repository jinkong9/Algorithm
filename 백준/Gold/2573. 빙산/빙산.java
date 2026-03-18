import java.io.*;
import java.util.*;
public class Main {
	static int N, M, arr[][], map[][], cnt, sum;
	static boolean v[][];
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
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr= new int[N][M];
		map= new int[N][M];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				map[i][j] = arr[i][j];
			}
		}
		cnt = 0;
		int t = 0;
		while(true) {
			v = new boolean[N][M];
			int tt = 0;
			for(int i=0; i<N; i++) {
				for(int j=0; j<M; j++) {
					if(arr[i][j] >0) {
						check(i,j);
					}
				}
			}
			for(int i=0; i<N; i++) arr[i] = map[i].clone();
			
			for(int i=0; i<N; i++) {
				for(int j=0; j<M; j++) {
					if(arr[i][j] >0 && !v[i][j]) {
						tt += 1;
						bfs(i,j);
					}
				}
			}
			if(tt >= 2) {
				cnt = t;
				break;
			} else if (tt == 0 ) {
				cnt = 0;
				break;
			}
			t ++;
		}
		if(cnt == 0) System.out.println(0);
		else System.out.println(cnt+1);
	}

	static void check(int r, int c) {
		int tmp = 0;
		for(int i=0; i<4; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];
			
			if(nr <0 || nr >=N || nc < 0 || nc >=M) continue;
			if(arr[nr][nc] == 0) tmp ++;
		}
		if(map[r][c] < tmp) {
			map[r][c] = 0;
		} else {
			map[r][c] -= tmp;
		}
	}
	
	static void bfs(int r, int c) {
		Queue <Point> Q= new ArrayDeque<>();
		Q.offer(new Point(r,c));
		v[r][c] = true;
		
		while(!Q.isEmpty()) {
			Point p = Q.poll();
			
			for(int i=0; i <4; i++) {
				int nr = p.r + dr[i];
				int nc = p.c + dc[i];
				
				if(nr <0 || nr >=N || nc < 0 || nc >=M) continue;
				if(v[nr][nc]) continue;
				if(arr[nr][nc] == 0) continue;
				v[nr][nc] = true;
				Q.offer(new Point(nr,nc));
			}
		}
	}
}
