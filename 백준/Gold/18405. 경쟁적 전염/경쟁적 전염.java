import java.io.*;
import java.util.*;

public class Main {
	static int N, K, arr[][], X, Y, S;
	static int dr[] = { -1, 1, 0, 0 };
	static int dc[] = { 0, 0, -1, 1 };
	static Queue<Point> Q;
	static boolean v[][];
	
	static class Point {
		int r, c, t, num;

		Point(int r, int c, int t, int num) {
			this.r = r;
			this.c = c;
			this.t = t;
			this.num = num;
		}

	}


	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		arr = new int[N][N];
		Q = new ArrayDeque<>();
		v = new boolean [N][N];
		ArrayList<Point> list = new ArrayList<>();
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if (arr[i][j] > 0) {
					list.add(new Point(i,j,0,arr[i][j]));
					v[i][j] = true;
				}
			}
		}

		st = new StringTokenizer(br.readLine());
		S = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken())-1;
		Y = Integer.parseInt(st.nextToken())-1;
		
		Collections.sort(list, (a,b) -> a.num - b.num);
		for(Point p : list) {
			Q.offer(p);
		}
		
		bfs();
//		for(int i=0; i<N; i++) System.out.println(Arrays.toString(arr[i]));
		System.out.println(arr[X][Y]);
	}

	static void bfs() {
		while(!Q.isEmpty()) {
			Point p = Q.poll();
			
			if(p.t == S) continue;
			
			for(int i=0; i<4; i++) {
				int nr = p.r + dr[i];
				int nc = p.c + dc[i];
				if(nr <0 || nr >= N || nc <0 || nc >= N) continue;
				if(v[nr][nc]) continue;
				if(arr[nr][nc] !=0) continue;
				v[nr][nc] = true;
				arr[nr][nc] = p.num;
				Q.offer(new Point(nr,nc,p.t +1, arr[p.r][p.c]));
			}
		}
	}
}
