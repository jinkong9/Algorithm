
import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class Solution {
	static int dr[] = {-1,1,0,0};
	static int dc[] = {0,0,-1,1};
	static int N;
	static int a, b;
	static boolean v[][];
	static int arr[][];
	
	static class Point{
		int r;
		int c;
		Point(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=T; tc++) {
			N = Integer.parseInt(br.readLine());
			arr = new int[N][N];
			for(int i=0; i<N; i++) {
				StringTokenizer st1 = new StringTokenizer(br.readLine());
				for(int j=0; j<N; j++) {
					arr[i][j] = Integer.parseInt(st1.nextToken());
				}
			}
				int max = 0;
				for(int i=0; i<=100; i++) {
					v = new boolean[N][N];
					int cnt = 0;
					
					for(int j=0; j<N; j++) {
						for(int k=0; k<N; k++) {
							if(arr[j][k] > i && !v[j][k]) {
								bfs(i, j, k);
								cnt++;
							}
						}
					}
					max = Math.max(max, cnt);
				}
				System.out.println("#" + tc + " " +max);
		}
	}
	
	static void bfs(int day, int r, int c) {
		Queue<Point> Q = new ArrayDeque<>();
		v[r][c] = true;
		Q.offer(new Point(r,c));
		while(!Q.isEmpty()) {
			Point p = Q.poll();
			int pr = p.r;
			int pc = p.c;
			for(int i=0; i<4; i++) {
				int nr = pr + dr[i];
				int nc = pc + dc[i];
				if(nr >=0 && nr < N && nc >=0 && nc < N) {
					if(arr[nr][nc] > day && !v[nr][nc]) {
						v[nr][nc] = true;
						Q.offer(new Point(nr,nc));
					}
				}
			}
		}
	}
	

}
