import java.io.*;
import java.util.*;

public class Main {
	static int N, arr[][];
	static int dr[] = { -1, 1, 0, 0 };
	static int dc[] = { 0, 0, -1, 1 };

	static class Point implements Comparable<Point> {
		int r, c ,t;

		Point(int r, int c, int t) {
			this.r = r;
			this.c = c;
			this.t = t;
		}

		@Override
		public int compareTo(Point o) {
			return this.t - o.t;
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int idx = 0;
		while(true) {
			idx ++;
			N = Integer.parseInt(br.readLine());
			arr = new int[N][N];
			if(N == 0) System.exit(0);
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			System.out.println("Problem" + " " + idx+ ":" + " " + dijkstra());
		}
	}

	static int dijkstra() {
		PriorityQueue<Point> Q = new PriorityQueue<>();
		Q.offer(new Point(0,0,0));
		int dist[][] = new int [N][N];
		for(int i=0; i<N; i++) Arrays.fill(dist[i], Integer.MAX_VALUE);
		dist[0][0] = 0;
		
		while(!Q.isEmpty()) {
			Point p = Q.poll();
			
			if(dist[p.r][p.c] < p.t) continue;
			
			for(int i=0; i<4; i++) {
				int nr = p.r + dr[i];
				int nc = p.c + dc[i];
				
				if(nr <0 || nr >=N || nc <0 || nc >=N) continue;
				if(dist[nr][nc] > p.t + arr[nr][nc]) {
					dist[nr][nc] = p.t + arr[nr][nc];
					Q.offer(new Point(nr,nc,dist[nr][nc]));
				}
			}
		}
		return dist[N-1][N-1] + arr[0][0];
	}
}
