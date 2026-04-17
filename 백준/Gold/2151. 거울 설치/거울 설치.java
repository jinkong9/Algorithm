import java.io.*;
import java.util.*;

public class Main {
	static int N, sr, sc, er, ec, ans;
	static char arr[][];
	static int dr[] = { -1, 0, 1, 0 };
	static int dc[] = { 0, -1, 0, 1 };

	static class Point implements Comparable<Point> {
		int r, c, d, cnt;

		Point(int r, int c, int d, int cnt) {
			this.r = r;
			this.c = c;
			this.d = d;
			this.cnt = cnt;
		}

		@Override
		public int compareTo(Point o) {
			return this.cnt - o.cnt;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		arr = new char[N][N];
		ArrayList<Point> list = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			for (int j = 0; j < N; j++) {
				arr[i][j] = s.charAt(j);
				if (arr[i][j] == '#')
					list.add(new Point(i, j, 0, 0));
			}
		}
		sr = list.get(0).r;
		sc = list.get(0).c;
		er = list.get(1).r;
		ec = list.get(1).c;
		
		dikjstra();
		System.out.println(ans);
	}

	static void dikjstra() {
		PriorityQueue<Point> Q = new PriorityQueue<>();
		boolean v[][][] = new boolean[N][N][4];

		for (int i = 0; i < 4; i++) {
			Q.offer(new Point(sr, sc, i, 0));
		}

		while (!Q.isEmpty()) {
			Point p = Q.poll();
			
			if(v[p.r][p.c][p.d]) continue;
			v[p.r][p.c][p.d] = true;
			
			if(p.r == er && p.c == ec) {
				ans = p.cnt;
				return;
			}
			
			int nr = p.r + dr[p.d];
			int nc = p.c + dc[p.d];

			if (nr < 0 || nr >= N || nc < 0 || nc >= N)
				continue;
			if (arr[nr][nc] == '*')
				continue;
			Q.offer(new Point(nr,nc,p.d,p.cnt));
			
			if(arr[nr][nc] == '!' ) {
				int nd = (p.d + 3) %4;
				Q.offer(new Point(nr,nc,nd,p.cnt +1));
				
				nd = (p.d +1) % 4;
				Q.offer(new Point(nr,nc,nd,p.cnt+1));
			} 
		}
	}
}
