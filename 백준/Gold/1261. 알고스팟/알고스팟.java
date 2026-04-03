import java.io.*;
import java.util.*;
public class Main {
	static int N,M, arr[][];
	static int dr[] = {-1,1,0,0};
	static int dc[] = {0,0,-1,1};
	static class Point implements Comparable<Point> {
		int r,c,t;
		Point (int r, int c , int t) {
			this.r = r;
			this.c = c;
			this.t =t;
		}
		@Override
		public int compareTo(Point o) {
			return this.t -o.t;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		arr = new int [N][M];
		
		for(int i=0; i<N; i++) {
			String s = br.readLine();
			for(int j=0; j<M; j++) {
				arr[i][j] = s.charAt(j) - '0';
			}
		}
		
		System.out.println(dijksra());
	}

	static int dijksra() {
		int dist[][] = new int[N][M];
		for(int i=0; i<N; i++) Arrays.fill(dist[i], Integer.MAX_VALUE);
		PriorityQueue<Point> Q = new PriorityQueue<>();
		Q.offer(new Point(0,0,0));
		dist[0][0] = 0;
		
		while(!Q.isEmpty()) {
			Point p = Q.poll();
			if(dist[p.r][p.c] < p.t) continue;
			
			for(int i=0; i<4; i++) {
				int nr = p.r + dr[i];
				int nc = p.c + dc[i];
				
				if(nr <0 || nr >= N || nc < 0 || nc >=M) continue;
				if(dist[nr][nc] > p.t + arr[nr][nc]) {
					dist[nr][nc] = p.t + arr[nr][nc];
					Q.offer(new Point(nr,nc,dist[nr][nc]));
				}
			}
		}
		return dist[N-1][M-1] + arr[0][0];
	}
}
