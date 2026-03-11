
import java.io.*;
import java.util.*;
public class Main {
	static int V,E,K;
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
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(br.readLine());
		
		list = new ArrayList[V+1];
		for(int i=1; i<=V; i++) list[i] = new ArrayList<>();
		
		for(int i=0; i<E; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			
			list[a].add(new Ver(b,w));
		}
		dijkstra(V,K);
	}
	
	static void dijkstra(int n , int start) {
		PriorityQueue<Ver> Q = new PriorityQueue<>();
		boolean check[] = new boolean[n+1];
		int dist[] = new int[n+1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[start] = 0;
		
		Q.offer(new Ver(start,0));
		
		while(!Q.isEmpty()) {
			Ver v = Q.poll();
			if(check[v.to]) continue;
			check[v.to] = true;
			
			for(Ver next : list[v.to]) {
				if(dist[next.to] > dist[v.to] + next.w) {
					dist[next.to] = dist[v.to] + next.w;
					Q.offer(new Ver(next.to, dist[next.to]));
				}
			}
		}
		for(int i=1; i<=n; i++) {
			if(dist[i] == Integer.MAX_VALUE) System.out.println("INF");
			else System.out.println(dist[i]);
		}
	}
}
