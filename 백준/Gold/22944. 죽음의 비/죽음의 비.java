import java.io.*;
import java.util.*;

public class Main {
	static int N, H, D, sr, sc, er, ec, ur, uc, ans;
	static char arr[][];
	static boolean v[][];
	static int dr[] = { -1, 1, 0, 0 };
	static int dc[] = { 0, 0, -1, 1 };

	static class Point {
		int r, c, t, hp, df;

		Point(int r, int c, int t, int hp, int df) {
			this.r = r;
			this.c = c;
			this.t = t;
			this.hp = hp;
			this.df = df;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		arr = new char[N][N];

		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			for (int j = 0; j < N; j++) {
				arr[i][j] = s.charAt(j);
				if (arr[i][j] == 'S') {
					sr = i;
					sc = j;
				}
				if (arr[i][j] == 'E') {
					er = i;
					ec = j;
				}
				if (arr[i][j] == 'U') {
					ur = i;
					uc = j;
				}
			}
		}
		ans = bfs(sr, sc);
		System.out.println(ans);
	}

	static int bfs(int r, int c) { // 시간 체력 내구도 순
		Queue<Point> Q = new ArrayDeque<>();
		Q.offer(new Point(r, c, 0, H, 0));
		int dist[][] = new int[N][N];

		for (int i = 0; i < N; i++)
			Arrays.fill(dist[i], -1);
		
		dist[r][c] = H;
		
		while (!Q.isEmpty()) {
			Point p = Q.poll();

			if (p.r == er && p.c == ec) {
				return	p.t;
			}

			for (int i = 0; i < 4; i++) {
				int nr = p.r + dr[i];
				int nc = p.c + dc[i];

				int np = p.hp; // 체력
				int nf = p.df; // 내구도

				if (nr < 0 || nr >= N || nc < 0 || nc >= N)
					continue;


				if (arr[nr][nc] == '.') {
					if (nf > 0) {
						nf--;
					} else {
						np--;
					}
				}
				if (np <= 0)
					continue;

				if (arr[nr][nc] == 'U') {
					nf = D - 1;
				}
				
				if(dist[nr][nc] >= np+nf) continue;
				dist[nr][nc] = np+nf;
				
				Q.offer(new Point(nr, nc, p.t + 1, np, nf));
			}
		}
		return -1;
	}

}
