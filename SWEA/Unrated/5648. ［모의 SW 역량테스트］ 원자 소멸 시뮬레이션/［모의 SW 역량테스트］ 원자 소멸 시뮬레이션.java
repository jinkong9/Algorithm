
import java.io.*;
import java.util.*;
public class Solution {
	static int N, ans;
	static int [][] arr = new int[4001][4001];
	static Queue<Point> Q;
	static class Point {
		int r,c,d,e;
		Point(int r, int c, int d, int e) {
			this.r = r;
			this.c = c;
			this.d = d;
			this.e = e;
		}
	}
	static int dr[] = {1,-1,0,0};
	static int dc[] = {0,0,-1,1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=T; tc++) {
			N = Integer.parseInt(br.readLine());
			Q = new ArrayDeque<>();
			for(int i=0; i<N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int sc = (Integer.parseInt(st.nextToken()) +1000)<<1;
				int sr = (Integer.parseInt(st.nextToken()) +1000)<<1;
				int d = Integer.parseInt(st.nextToken());
				int e = Integer.parseInt(st.nextToken());
				Q.offer(new Point(sr,sc,d,e));
			}
			ans = 0;
			bfs();
			StringBuilder sb = new StringBuilder();
			sb.append("#").append(tc).append(" ").append(ans).append("\n");
			System.out.print(sb);
		}
	}
	
	static void bfs() {
	    for(int time = 0; time <= 4000; time++) {
	        if(Q.isEmpty()) break;

	        int size = Q.size();
	        ArrayList<Point> list = new ArrayList<>();

	        while(size-- > 0) {
	            Point p = Q.poll();

	            int nr = p.r + dr[p.d];
	            int nc = p.c + dc[p.d];

	            if(nr < 0 || nr > 4000 || nc < 0 || nc > 4000) continue;

	            arr[nr][nc] += p.e;
	            list.add(new Point(nr, nc, p.d, p.e));
	        }

	        for(Point p : list) {
	            if(arr[p.r][p.c] == 0) continue;

	            if(arr[p.r][p.c] == p.e) {
	                Q.offer(p);
	            } else {
	                ans += arr[p.r][p.c];
	            }
	            arr[p.r][p.c] = 0;
	        }
	    }
	}
}
