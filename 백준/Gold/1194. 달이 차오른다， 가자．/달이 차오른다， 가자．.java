
import java.io.*;
import java.util.*;

public class Main {
	static int sr, sc, N, M;
	static int sum = Integer.MAX_VALUE;
	static int dr[] = { -1, 1, 0, 0 };
	static int dc[] = { 0, 0, -1, 1 };
	static boolean v[][][];
	static boolean check = false;

	static class Point {
		int r, c, key, cnt;

		Point(int r, int c, int key, int cnt) {
			this.r = r;
			this.c = c;
			this.key = key;
			this.cnt = cnt;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		char arr[][] = new char[N][M];

		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			for (int j = 0; j < M; j++) {
				arr[i][j] = s.charAt(j);
				if (arr[i][j] == '0') {
					sr = i;
					sc = j;
				}
			}
		}
		bfs(arr, sr, sc);
		// . 이동 가능 / # 이동 불가능 / 소문자 열쇠 집기, 이동가능 / 대문자 열쇠 있을 때 이동가능
		// 0은 시작 1이 끝
		if(check) {
			System.out.println(sum);
		} else {
			System.out.println(-1);
		}
	}

	static void bfs(char arr[][], int r, int c) {
		// 알파벳
		v = new boolean[N][M][1 << 6];
		Queue<Point> Q = new ArrayDeque<>();
		Q.offer(new Point(sr, sc, 0, 0));
		while (!Q.isEmpty()) {
			Point p = Q.poll();
			int pr = p.r;
			int pc = p.c;
			int pkey = p.key;
			int pcnt = p.cnt;
			v[pr][pc][pkey] = true;

			if (arr[pr][pc] == '1') {
				check = true;
				sum = Math.min(sum, pcnt);
				return;
			}

			for (int i = 0; i < 4; i++) {
				int nr = pr + dr[i];
				int nc = pc + dc[i];

				if (nr < 0 || nr >= N || nc < 0 || nc >= M)
					continue;
				if (arr[nr][nc] == '#')
					continue;

				int mask = pkey;
				char next = arr[nr][nc];

				if (next >= 'a' && next <= 'f') {
					mask |= (1 << (next - 'a'));
				}

				if (next >= 'A' && next <= 'F') {
					if ((mask & (1 << (next - 'A'))) == 0)
						continue;
				}
				if (v[nr][nc][mask])
					continue;
				v[nr][nc][mask] = true;
				Q.offer(new Point(nr, nc, mask, pcnt + 1));
			}
		}
	}
}
