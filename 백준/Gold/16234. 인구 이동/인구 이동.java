
import java.awt.List;
import java.io.*;
import java.util.*;
public class Main {
	static int N,L,R, arr[][], ans;
	static int dr[] = {-1,1,0,0};
	static int dc[] = {0,0,-1,1};
	static class Point {
		int r,c,t;
		Point(int r , int c, int t) {
			this.r = r;
			this.c = c;
			this.t = t;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		
		arr = new int[N][N];
		for(int i=0; i<N; i++ ) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		ans = 0;
		while(true) {
			boolean f = bfs();
			if(f) {
				ans ++;
			} else {
				break;
			}
		}
		System.out.println(ans);
//		for(int i=0; i<N; i++) System.out.println(Arrays.toString(arr[i]));
	}

	static boolean bfs() {
		boolean v[][] = new boolean[N][N];
		boolean f = false;
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
              if(v[i][j]) continue;
				Queue <Point> Q = new ArrayDeque<>();
				Q.offer(new Point(i,j,0));
				v[i][j] = true;
				ArrayList<Point> list = new ArrayList<>();
				list.add(new Point(i,j,0));
				int sum = arr[i][j];
				while(!Q.isEmpty()) {
					Point p = Q.poll();
					for(int k=0; k<4; k++) {
						int nr = p.r + dr[k];
						int nc = p.c + dc[k];
						
						if(nr < 0 || nr >= N || nc < 0 || nc >= N) continue;
						if(v[nr][nc]) continue;
						if(Math.abs(arr[p.r][p.c] - arr[nr][nc]) >=L && Math.abs(arr[p.r][p.c] - arr[nr][nc]) <=R) {
							Q.offer(new Point(nr,nc, p.t+1));
							list.add(new Point(nr,nc,p.t+1));
							v[nr][nc] = true;
							sum += arr[nr][nc];
						}
					}
				}
				if(list.size() >1) {
					int a = sum / list.size();
					f= true;
					for(Point p : list) {
						arr[p.r][p.c] = a;
					}
				} 
			}
		}
		return f;
	}
	
}
