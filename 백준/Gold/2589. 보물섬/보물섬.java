
import java.io.*;
import java.util.*;
public class Main {
	static int N,M,cnt;;
	static int dr[] = {-1,1,0,0};
	static int dc[] = {0,0,-1,1};
	static char arr[][];
	static boolean v[][];
	static class Point {
		int r,c,cnt;
		Point(int r, int c, int cnt) {
			this.r = r;
			this.c = c;
			this.cnt = cnt;
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
			}
		}
		cnt = 0;
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(arr[i][j] == 'L') {
					bfs(i,j);
				}
			}
		}
		System.out.println(cnt);
	}

	static void bfs(int r, int c) {
		Queue <Point> Q = new ArrayDeque<>();
		v = new boolean [N][M];
		Q.offer(new Point(r,c,0));
		v[r][c] = true;
		while(!Q.isEmpty()) {
			Point p = Q.poll();
			cnt = Math.max(cnt, p.cnt);
			for(int i=0; i<4; i++) {
				int nr = p.r + dr[i];
				int nc = p.c + dc[i];
				
				if(nr <0 || nr >=N || nc <0 || nc >=M) continue;
				if(v[nr][nc]) continue;
				if(arr[nr][nc] == 'W') continue;
				v[nr][nc] = true;
				Q.offer(new Point(nr,nc,p.cnt+1));
			}
		}
	}
}
