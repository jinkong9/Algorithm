

import java.io.*;
import java.util.*;

public class Main {
	static int N, M, arr[][], cnt;
	static int dr[] = { -1, 0, 1, 0 }; 
	static int dc[] = { 0, 1, 0, -1 };
	static class Point {
		int r, c, ca;

		Point(int r, int c, int ca) {
			this.r = r;
			this.c = c;
			this.ca = ca;
		}
	}

	static ArrayList<Point> list;
	static boolean v[];
	static int dir[][] = {{}, {1}, {1,3}, {0,1}, {3,0,1}, {0,1,2,3}};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		list = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			StringTokenizer st1 = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st1.nextToken());
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (arr[i][j] >=1 && arr[i][j] <=5) {
					list.add(new Point(i, j, arr[i][j]));
				}
			}
		}
		cnt = Integer.MAX_VALUE;
		v = new boolean[4];
		int aaa[] = {0,1,2,3};
		perm(0, aaa, new int[list.size()]);
		System.out.println(cnt);
	}
	
	static void perm(int idx, int aaa[], int sel[]) {
		if(idx == sel.length) {
			dfs(sel);
			return;
		}
		for(int i=0; i<4; i++) {
				sel[idx] = aaa[i];
				perm(idx+1, aaa, sel);
		}
		
	}
	
	static void dfs(int sel[]) { // 좌표들을 4방향으로 어떻게 바꿀건지만 하면된다.
		int map[][] = new int[N][M];
		for(int i=0; i<arr.length; i++) {
			map[i] = arr[i].clone();
		}
		int size = list.size();
		for (int i = 0; i < size; i++) {
			Point p = list.get(i);
			int nr = p.r;
			int nc = p.c;
			int ca = p.ca;
			int tmp = sel[i];
			for(int j=0; j<dir[ca].length; j++) {
				nr = p.r;
				nc = p.c;
				while (true) {
					int tmpd = (dir[ca][j] + tmp) %4;
					nr += dr[tmpd];
					nc += dc[tmpd];
					if (nr < 0 || nr >= N || nc < 0 || nc >= M)
						break;
					if (map[nr][nc] == 6)
						break;
					if(map[nr][nc] == 0) map[nr][nc] = -1;
				}
			}
		}
		check(map);
	}

	static void check(int map[][]) {
		int a = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 0)
					a++;
			}
		}
		cnt =  Math.min(cnt, a);
	}

}
