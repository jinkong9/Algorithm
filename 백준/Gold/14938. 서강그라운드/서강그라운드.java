
import java.io.*;
import java.util.*;

public class Main {
	static int N, M, R, arr[];

	static class Ver implements Comparable<Ver> {
		int to, w;

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
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		arr = new int[N+1];
		list = new ArrayList[N+1];
		for(int i=1; i<=N; i++) list[i] = new ArrayList<>();
		
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++)
			arr[i] = Integer.parseInt(st.nextToken());

		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			list[a].add(new Ver(b,w));
			list[b].add(new Ver(a,w));
		}
		int ans = 0;
		for(int i=1; i<=N; i++) {
			int tmp = 0;
			tmp += arr[i];
			for(int j=1; j<=N; j++) {
				if(i==j) continue;
				tmp += dijkstra(i,j);
			}
			ans = Math.max(ans, tmp);
		}
		System.out.println(ans);
	}

	static int dijkstra(int start, int end) {
		PriorityQueue<Ver> Q = new PriorityQueue<>();
		int dist[] = new int[N+1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[start] = 0;
		
		Q.offer(new Ver(start,0));
		
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
		if(dist[end] > M) return 0;
		else {
			return arr[end];
		}
	}
}
