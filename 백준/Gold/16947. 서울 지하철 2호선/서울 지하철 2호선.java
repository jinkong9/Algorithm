

import java.io.*;
import java.util.*;
public class Main {
	static int N, dist[];
	static ArrayList<Integer> list[];
	static boolean v[];
	static boolean cycle[];
//	static int find(int a) {
//	    if (a == parent[a]) return a;
//	    return parent[a] = find(parent[a]);
//	}
//
//	static void union(int a, int b) {
//	    a = find(a);
//	    b = find(b);
//
//	    if (a != b) {
//	        parent[a] = b;
//	    }
//	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		list = new ArrayList[N+1];
//		parent = new int[N+1];
//		for(int i=1; i<=N; i++) parent[i] = i;
		
		for(int i=1; i<=N; i++) {
			list[i] = new ArrayList<>();
		}
		
		
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			list[A].add(B);
			list[B].add(A);
		}
		v = new boolean[N+1];
		cycle = new boolean[N+1];
		dist = new int[N+1];
		dfs(1,-1);
		bfs();
		StringBuilder sb = new StringBuilder();
		for(int i=1; i<=N; i++) {
			sb.append(dist[i]).append(" ");
		}
		System.out.println(sb);
	}
	
	static void bfs() {
		Queue <Integer> Q = new ArrayDeque<>();
		Arrays.fill(dist, -1);
		
		for(int i=1; i<=N; i++) {
			if(cycle[i]) {
				Q.offer(i);
				dist[i] = 0;
			}
		}
		
		while(!Q.isEmpty()) {
			int cur = Q.poll();
			for(int next : list[cur]) {
				if(dist[next] == -1) {
					dist[next] = dist[cur] +1;
					Q.offer(next);
				}
			}
		}
	}
	
	static int dfs(int cur, int prev) {
	    v[cur] = true;

	    for (int next : list[cur]) {
	        if (next == prev) continue;

	        if (v[next]) {
	            cycle[cur] = true;
	            return next;
	        }

	        int start = dfs(next, cur);
	        if (start != -1) {
	            cycle[cur] = true;
	            if (cur == start) return -1; 
	            return start;
	        }
	    }
	    return -1;
	}
}
