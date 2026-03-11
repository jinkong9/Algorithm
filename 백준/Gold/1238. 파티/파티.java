
import java.io.*;
import java.util.*;

public class Main {
	static int N,M,X,ans;
	static class Ver implements Comparable<Ver> {
		int to,w;
		Ver(int to, int w) {
			this.to = to;
			this.w = w;
		}
		@Override
		public int compareTo(Ver o) {
			return this.w - o.w;
		}
	}
	static ArrayList<Ver> list[];
	static ArrayList<Ver> rlist[];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		
		list = new ArrayList[N+1];
		rlist = new ArrayList[N+1];
		for(int i=1; i<=N; i++) {
			list[i] = new ArrayList<>();
			rlist[i] = new ArrayList<>();
		}
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int t = Integer.parseInt(st.nextToken());
			list[a].add(new Ver(b,t));
			rlist[b].add(new Ver(a,t));
		}
		ans = 0;
		int a[] = dijkstra1(X);
		int b[] = dijkstra(X);
		for(int i=1; i<=N; i++) {
			ans = Math.max(a[i]+b[i], ans);
		}
		System.out.println(ans);
	}
	
	static int [] dijkstra1(int start) { // X에서 처음으로
		PriorityQueue<Ver> Q = new PriorityQueue<>();
		int dist[] = new int[N+1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[start] = 0;
		
		Q.offer(new Ver(start,0));
		
		while(!Q.isEmpty()) {
			Ver now = Q.poll();
			
			if(now.w > dist[now.to]) continue;
			
			for(Ver next : list[now.to]) {
				if(dist[next.to] > dist[now.to] + next.w) {
					dist[next.to] = dist[now.to] + next.w;
					Q.offer(new Ver(next.to, dist[next.to]));
				}
			}
		}
		return dist;
	}
	
	static int [] dijkstra(int start) { // 처음에서 X로
		PriorityQueue<Ver> Q = new PriorityQueue<>();
		int dist[] = new int[N+1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[start] = 0;
		
		Q.offer(new Ver(start,0));
		
		while(!Q.isEmpty()) {
			Ver now = Q.poll();
			
			if(now.w > dist[now.to]) continue;
			
			for(Ver next : rlist[now.to]) {
				if(dist[next.to] > dist[now.to] + next.w) {
					dist[next.to] = dist[now.to] + next.w;
					Q.offer(new Ver(next.to, dist[next.to]));
				}
			}
		}
		return dist;
	}
}
