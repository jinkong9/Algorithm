
import java.io.*;
import java.util.*;
public class Main {
	static int N,M,start,end;
	static ArrayList<Ver> list[];
	static class Ver implements Comparable<Ver> {
		int to,w;
		Ver(int to, int w) {
			this.to = to;
			this.w =w ;
		}
		@Override
		public int compareTo(Ver o) {
			return this.w - o.w;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		list = new ArrayList[N+1];
		for(int i=1; i<=N; i++) list[i] = new ArrayList<>();
		for(int i=0; i<M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			list[a].add(new Ver(b,w));
		}
		StringTokenizer st = new StringTokenizer(br.readLine());
		start = Integer.parseInt(st.nextToken());
		end = Integer.parseInt(st.nextToken());
		int ans = dijkstra(start, end);
		System.out.println(ans);
	}
	
	static int dijkstra(int start, int end) {
		PriorityQueue<Ver> Q = new PriorityQueue<>();
		Q.offer(new Ver(start,0));
		int dist[] = new int[N+1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[start] = 0;
		
		while(!Q.isEmpty()) {
			Ver now = Q.poll();
			
			if(dist[now.to] < now.w) continue;
			
			for(Ver next : list[now.to]) {
				if(dist[next.to] > dist[now.to] + next.w) {
					dist[next.to] = dist[now.to] + next.w;
					Q.offer(new Ver(next.to, dist[next.to]));
				}
			}
		}
		return dist[end];
	}
}
