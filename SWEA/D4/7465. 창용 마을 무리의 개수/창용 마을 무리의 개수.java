

import java.io.*;
import java.util.*;

public class Solution {
	static int N, M, parent[], arr[][];

	static int find(int a) {
		if (a == parent[a])
			return a;
		return parent[a] = find(parent[a]);
	}

	static void union(int a, int b) {
		a = find(a);
		b = find(b);
		if(a != b) parent[a] = b;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			parent = new int[N+1];
			for(int i=1; i<=N; i++) parent[i] = i;
			for(int i=0; i<M; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				if(find(a) != find(b)) {
					union(a,b);
				}
			}
			int ans = 0;
			for(int i=1; i<=N; i++) {
				if(parent[i] == i) ans ++;
			}
			StringBuilder sb = new StringBuilder();
			sb.append("#").append(tc).append(" ").append(ans).append("\n");
			System.out.print(sb);
		}
	}

}
