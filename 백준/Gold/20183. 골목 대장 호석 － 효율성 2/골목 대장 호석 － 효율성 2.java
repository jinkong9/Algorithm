import java.io.*;
import java.util.*;

public class Main {
	static int N,M,A,B;
	static long C;
	static class Ver implements Comparable<Ver> {
		int to;
		long w;
		Ver(int to, long w) {
			this.to = to;
			this.w =w ;
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
		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		C = Long.parseLong(st.nextToken());
		
		list = new ArrayList[N+1];
		for(int i=1; i<=N; i++) list[i] = new ArrayList<>();
		
		long idx1 = 0;
		long idx2 = 0;
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			long w = Long.parseLong(st.nextToken());
			list[a].add(new Ver(b,w));
			list[b].add(new Ver(a,w));
			idx2 = Math.max(idx2, w);
		}
		long ans = 0;
		while(idx1 <= idx2) {
			long mid = (idx1 + idx2) / 2;
			
			if(dijkstra(mid)) {
				ans = mid;
				idx2 = mid - 1;
			} else {
				idx1 = mid + 1;
			}
		}
		if(ans == 0) System.out.println(-1);
		else System.out.println(ans);
	}

	static boolean dijkstra(long mid) {
		long dist[] = new long[N+1];
		Arrays.fill(dist, Long.MAX_VALUE);
		PriorityQueue<Ver> Q = new PriorityQueue<>();
		Q.offer(new Ver(A,0));
		dist[A] = 0;
		
		while(!Q.isEmpty()) {
			Ver now = Q.poll();
			
			if(dist[now.to] < now.w) continue;
			
			for(Ver next : list[now.to]) {
				if(mid < next.w) continue;
				
				if(dist[next.to] > dist[now.to] + next.w) {
					dist[next.to] = dist[now.to] + next.w;
					Q.offer(new Ver(next.to, dist[next.to]));
				}
			}
		}
		return dist[B] <= C;
	}
}
