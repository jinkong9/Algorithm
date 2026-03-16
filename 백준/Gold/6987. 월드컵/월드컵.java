

import java.io.*;
import java.util.*;

public class Main {
	static StringBuilder sb;
	static ArrayList<Point> list;
	static boolean possible;

	static int[] team1 = new int[15];
	static int[] team2 = new int[15];

	static class Point {
		int w, d, l;

		Point(int w, int d, int l) {
			this.w = w;
			this.d = d;
			this.l = l;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		
		int idx = 0;
		for(int i=0; i<5; i++) {
			for(int j=i+1; j<6; j++) {
				team1[idx] = i;
				team2[idx] = j;
				idx++;
			}
		}
		
		for (int i = 0; i < 4; i++) {
			list = new ArrayList<>();
			int sum = 0;
			boolean f = false;

			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 6; j++) {
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());

				list.add(new Point(a, b, c));
				sum += a + b + c;
				if (a + b + c != 5)
					f = true;
			}

			possible = false;

			if (sum == 30 && !f) {
				dfs(0);
			}

			if (possible) {
				sb.append(1).append(" ");
			} else {
				sb.append(0).append(" ");
			}
		}
		System.out.println(sb);
	}

	static void dfs(int idx) {
		if (possible)
			return;
		if (idx == 15) {
			possible = true;
			return;
		}

		Point p1 = list.get(team1[idx]);
		Point p2 = list.get(team2[idx]);

		if (p1.w > 0 && p2.l > 0) {
			p1.w--;
			p2.l--;
			dfs(idx + 1);
			p1.w++;
			p2.l++;
		}

		if (p1.d > 0 && p2.d > 0) {
			p1.d--;
			p2.d--;
			dfs(idx + 1);
			p1.d++;
			p2.d++;
		}

		if (p1.l > 0 && p2.w > 0) {
			p1.l--;
			p2.w--;
			dfs(idx + 1);
			p1.l++;
			p2.w++;
		}
	}
}