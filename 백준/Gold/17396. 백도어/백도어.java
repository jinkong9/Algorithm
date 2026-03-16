
import java.io.*;
import java.util.*;

public class Main {
	static int N,M, arr[];
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
	static ArrayList<Ver> list[];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N];
		list = new ArrayList[N];
		for(int i=0; i<N; i++) {
			list[i] = new ArrayList<>();
		}
		// 기본 arr, list 선언
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) arr[i] = Integer.parseInt(st.nextToken());
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			list[a].add(new Ver(b,w));
			list[b].add(new Ver(a,w));
		}
		long ans = dijkstra();
		if(ans == Long.MAX_VALUE) System.out.println(-1);
		else System.out.println(ans);
	}

	static long dijkstra() { // 0번 부터 N-1 까지 거리
		long[] dist = new long[N+1];
		PriorityQueue<Ver> Q = new PriorityQueue<>();
		Arrays.fill(dist, Long.MAX_VALUE);
		Q.offer(new Ver(0,0));
		dist[0] = 0;
		
		while(!Q.isEmpty()) {
			Ver now = Q.poll();
			
			if(dist[now.to] < now.w) continue;
			
			for(Ver next : list[now.to]) {
				
				if(arr[next.to] == 1 && next.to != N-1) continue;
				
				if(dist[next.to] > dist[now.to] + next.w) {
					dist[next.to] = dist[now.to] + next.w;
					Q.offer(new Ver(next.to, dist[next.to]));
				}
			}
		}
		return dist[N-1];
	}
}
