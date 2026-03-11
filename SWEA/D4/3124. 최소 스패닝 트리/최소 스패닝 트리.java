
import java.io.*;
import java.util.*;

public class Solution {
	static int N, M;
	static ArrayList<Ver> list[];
	static boolean v[];
	static class Ver implements Comparable<Ver> {
		int to;
		long w;
		Ver(int to, long w) {
			this.to = to;
			this.w = w;
		}
		@Override
		public int compareTo(Ver o) {
			return Long.compare(this.w, o.w);
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			v = new boolean[N+1];
			list = new ArrayList[N+1];
			
			for(int i=1; i<=N; i++) list[i] = new ArrayList<>();
			
			for(int i=0; i<M; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				long w = Integer.parseInt(st.nextToken());
				
				list[a].add(new Ver(b,w));
				list[b].add(new Ver(a,w));
			}
			
			long ans = prim();
			sb.append("#").append(tc).append(" ").append(ans).append("\n");
		}
		System.out.println(sb);
	}
	
	static long prim() {
		PriorityQueue<Ver> Q = new PriorityQueue<>();
		Q.offer(new Ver(1,0));
		
		long res = 0;
		int cnt = 0;
		
		while(!Q.isEmpty()) {
			Ver V = Q.poll();
			
			if(v[V.to]) continue;
			v[V.to] = true;
			res += V.w;
			cnt ++; 
			
			if(cnt == N) break;
			
			for(Ver next : list[V.to]) {
				if(!v[next.to]) {
					Q.offer(next);
				}
			}
		}
		return res;
	}

}
