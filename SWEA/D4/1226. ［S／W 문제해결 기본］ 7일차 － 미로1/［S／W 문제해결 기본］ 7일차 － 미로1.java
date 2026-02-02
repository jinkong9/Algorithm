
import java.io.*;
import java.util.*;
public class Solution {
	static int arr[][] = new int[16][16];
	static int dr[] = {-1,1,0,0};
	static int dc[] = {0,0,-1,1};
	static int r, c;
	static int endr, endc;
	static int res;
	
	static class Point{
		int r, c;
		Point(int r, int c){
			this.r = r;
			this.c = c;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		for(int tc =1; tc<=10; tc++) {
			int T = Integer.parseInt(br.readLine());
			for(int i=0; i<16; i++) {
				String s = br.readLine();
				for(int j=0; j<16; j++) {
					arr[i][j] = s.charAt(j) - '0';
				}
			}
			for(int i=0; i<16; i++) {
				for(int j=0; j<16; j++) {
					if(arr[i][j] == 2) {
						r = i;
						c = j;
					}
					if(arr[i][j] == 3) {
						endr = i;
						endc = j;
					}
				}
			}
			
			bfs(arr);
			sb.append("#").append(T).append(" ").append(res).append('\n');
		}
		System.out.print(sb);
	}
	
	static void bfs(int[][] map) {
		Queue<Point> Q = new ArrayDeque<>();
		boolean v[][] = new boolean[16][16];
		v[r][c] = true;
		Q.offer(new Point(r,c));
		
		while(!Q.isEmpty()) {
				Point p = Q.poll();
				int pr = p.r;
				int pc = p.c;
				if(pr == endr && pc == endc) {
					res =1;
					break;
				} else {
					res = 0;
				}
				
				for(int i=0; i<4; i++) {
					int nr = pr + dr[i];
					int nc = pc + dc[i];
					
					if(nr >=0 && nr<16 && nc >=0 && nc <16 && !v[nr][nc] && arr[nr][nc] != 1) {
						v[nr][nc] = true;
						Q.offer(new Point(nr, nc));
					} 
				}
		}
	}

}
