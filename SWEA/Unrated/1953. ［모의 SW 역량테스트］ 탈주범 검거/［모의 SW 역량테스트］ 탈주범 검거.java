
import java.io.*;
import java.util.*;
public class Solution {
	static int arr[][], N, M, R, C, L;
	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,1,0,-1};
	static boolean v[][];
	static class Point{
		int r,c,t;
		Point(int r, int c, int t) {
			this.r = r;
			this.c = c;
			this.t = t;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=T; tc++) {
			StringTokenizer st1 = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st1.nextToken());
			M = Integer.parseInt(st1.nextToken());
			R = Integer.parseInt(st1.nextToken()); // 맨홀 r
			C = Integer.parseInt(st1.nextToken()); // 맨홀 c
			L = Integer.parseInt(st1.nextToken()); // 시간
			
			arr = new int[N][M];
			v = new boolean[N][M];
			for(int i=0; i<N; i++) {
				StringTokenizer st2 = new StringTokenizer(br.readLine());
				for(int j=0; j<M; j++) {
					arr[i][j] = Integer.parseInt(st2.nextToken());
				}
			}
			bfs();
			int cnt = 0;
			for(int i=0; i<N; i++) {
				for(int j=0; j<M; j++) {
					if(v[i][j]) cnt ++;
				}
			}
			System.out.println("#" + tc +" " + cnt);
		}
	}
	
	static void bfs() {
		Queue<Point> Q = new ArrayDeque<>();
		v[R][C] = true;
		Q.offer(new Point(R,C,1));
		
		while(!Q.isEmpty()) {
			Point p = Q.poll();
			int pr = p.r;
			int pc = p.c;
			int pt = p.t;
			if(pt == L) continue;
			
			for(int i=0; i<4; i++) {
				if(!check(arr[pr][pc],i )) continue;
				int nr = pr + dr[i];
				int nc = pc + dc[i];
				// 1 : 4방 / 2 : 상하 / 3 : 죄우 / 4 : 우상 / 5 : 우하 / 6 : 좌하 / 7 : 좌상
				if(nr >= 0 && nr < N && nc >=0 && nc <M && !v[nr][nc] && arr[nr][nc] != 0) {
						if(!check(arr[nr][nc], revCheck(i))) continue;
						v[nr][nc] = true;
						Q.offer(new Point(nr,nc,pt+1));
				}
			}
		}
	}
	
	static boolean check(int i, int d) {
		if(i == 1) return true;
	    if(i == 2 && (d == 0 || d == 2)) return true;
	    if(i == 3 && (d == 1 || d == 3)) return true;
	    if(i == 4 && (d == 0 || d == 1)) return true;
	    if(i == 5 && (d == 1 || d == 2)) return true;
	    if(i == 6 && (d == 2 || d == 3)) return true;
	    if(i == 7 && (d == 0 || d == 3)) return true;
	    return false;
	}
	
	static int revCheck(int d) {
		if(d == 2) return 0;
		if(d == 0) return 2;
		if(d == 1) return 3;
		return 1;
	}
}
