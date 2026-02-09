
import java.io.*;
import java.util.*;
public class Solution {
	static int arr[][], N, cnt, po;
	static int min;
	static boolean v[][];
	static int dr[] = {-1,1,0,0};
	static int dc[] = {0,0,-1,1};
	static class Point {
		int r,c;
		Point(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
	static Point check;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=T; tc++) {
			N = Integer.parseInt(br.readLine());
			arr = new int[N][N];
			
			for(int i=0; i<N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j=0; j<N; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			int max = 0;
			int po = 0;
			int a=0;
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					v = new boolean[N][N];
					cnt = 0;
					bfs(i,j);
					int b = arr[check.r][check.c];
					if(cnt > max) {
						max = cnt;
						po = arr[check.r][check.c];
					}
					if(cnt == max) {
						po = Math.min(po, b);
					}
				}
			}
			
			System.out.println("#" + tc + " " +po +" " +max);
		}
	}
	
	static void bfs(int r, int c) {
		Queue<Point> Q = new ArrayDeque<>();
		Q.offer(new Point(r,c));
		check = Q.peek();
		
		while(!Q.isEmpty()) {
			Point p = Q.poll();
			int pr = p.r;
			int pc = p.c;
			cnt ++;
			for(int i=0; i<4; i++) {
				
				int nr = pr + dr[i];
				int nc = pc + dc[i];
				if(nr <0 || nr >=N || nc <0 || nc >=N) continue;
				if(arr[nr][nc] - arr[pr][pc] != 1) continue;
				if(v[nr][nc]) continue;
				v[nr][nc] = true;
				Q.offer(new Point(nr,nc));
			}
		}
	}
	
}
