
import java.io.*;
import java.util.*;
public class Solution {
	static int dr[] = {0,0,-1};
	static int dc[] = {-1,1,0};
	static boolean v[][];
	static int x;
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
		for(int tc=1; tc<=10; tc++) {
			v = new boolean[100][100];
			x = 0;
			int T = Integer.parseInt(br.readLine());
			int arr[][] = new int[100][100];
			for(int i=0; i<100; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j=0; j<100; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			for(int i=0; i<100; i++) {
				if(arr[99][i] == 2) {
					bfs(arr, i);
				}
			}
			System.out.println("#" + T + " " + x);
		}
	}
	
	static void bfs(int arr[][], int col) {
		Queue<Point> q = new ArrayDeque<>();
		v[99][col] = true;
		q.offer(new Point(99,col));
		
		while(!q.isEmpty()) {
			Point p = q.poll();
			int pr = p.r;
			int pc = p.c;
			
			if (pr == 0) {
				x = pc;
				return;
			}
			
			for(int i=0; i<3; i++) {
				int nr = pr + dr[i];
				int nc = pc + dc[i];
				
				
				if(nr >=0 && nr<100 && nc >=0 && nc<100) {
					if(!v[nr][nc] && arr[nr][nc] == 1) {
						v[nr][nc] = true;
						q.offer(new Point(nr,nc));
						break;
					}
				}
			}
		}
	}
}
