
import java.io.*;
import java.util.*;
public class Main {
	static int N, M, cnt;
	static boolean[][] v;
	static int dr[] = { -1, 1, 0, 0 };
	static int dc[] = { 0, 0, -1, 1 };
	static class Point {
		int r,c;
		Point(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
	static Queue<Point> Q;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int arr[][] = new int[N][M];
		for(int i=0; i<N; i++) {
			StringTokenizer st1 = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				arr[i][j] = Integer.parseInt(st1.nextToken());
			}
		}
		dfs(arr,0,0,3);
		int a = 0;
		cnt = Math.max(a, cnt);
		System.out.println(cnt);
	}
	
	static void dfs(int arr[][], int r, int c, int wall) {
		if(wall == 0) {
			bfs(arr);
			return;
		}
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(arr[i][j] == 0) {
					arr[i][j] =1;
					dfs(arr, i, j, wall-1);
					arr[i][j] = 0;
				}
			}
		}
	}
	
	static void bfs(int arr[][]) {
		boolean va[][] = new boolean[N][M];
		int map[][] = new int [N][M];
		for(int i=0; i<arr.length; i++) {
			map[i] = arr[i].clone();
		}
		Q = new ArrayDeque<>();
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(map[i][j] == 2) {
					Q.offer(new Point(i,j));
				}
			}
		}
		while(!Q.isEmpty()) {
			Point p = Q.poll();
			int pr = p.r;
			int pc = p.c;
			va[pr][pc] = true;
			for(int i=0; i<4; i++) {
				int nr = pr + dr[i];
				int nc = pc + dc[i];
				
				if(nr <0 || nr >=N || nc <0|| nc >=M) continue;
				if(map[nr][nc] != 0) continue;
				if(va[nr][nc]) continue;
				map[nr][nc] = 2;
				va[nr][nc] = true;
				Q.offer(new Point(nr, nc));
			}
		}
		find(map);
	}
	
	static void find(int map[][]) {
		int a = 0;
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(map[i][j] == 0) {
					a++;
				}
			}
		}
		cnt = Math.max(a, cnt);
	}
}
