
import java.io.*;
import java.util.*;

public class Main {
	static int cnt = 0;
	static int dr[] = {-1,1,0,0,-1,-1,1,1};
	static int dc[] = {0,0,-1,1,-1,1,-1,1};
	static int H,W;
	static int tmp = 0;
	static int a, b;
	static boolean v[][];
	
	static class Point{
		int r;
		int c;
		Point(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
	static boolean g = true;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			W = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());
			if(H == 0 && W == 0) {
				return;
			}
			int arr[][] = new int[H][W];
			for(int i=0; i<H; i++) {
				StringTokenizer st1 = new StringTokenizer(br.readLine());
				for(int j=0; j<W; j++) {
					arr[i][j] = Integer.parseInt(st1.nextToken());
					if(arr[i][j] == 1) {
						a = i;
						b = j;
					}
				}
			}
			v = new boolean[H][W];
			check(arr);
		}
	}
	
	static void bfs(int [][] arr, int r, int c) {
		Queue<Point> Q = new ArrayDeque<>();
		v[r][c] = true;
		Q.offer(new Point(r,c));
		while(!Q.isEmpty()) {
			Point p = Q.poll();
			int pr = p.r;
			int pc = p.c;
			for(int i=0; i<8; i++) {
				int nr = pr + dr[i];
				int nc = pc + dc[i];
				if(nr >=0 && nr < H && nc >=0 && nc < W && !v[nr][nc] && arr[nr][nc] == 1) {
					v[nr][nc] = true;
					Q.offer(new Point(nr,nc));
					tmp ++;
				}
			}
		}
		cnt ++;
	}
	
	static void check (int arr[][]) {
		for(int i=0; i<H; i++) {
			for(int j=0; j<W; j++) {
				if(arr[i][j] == 1 && !v[i][j]) {
					bfs(arr, i, j);
				}
			}
		}
		System.out.println(cnt);
		cnt = 0;
	}

}
