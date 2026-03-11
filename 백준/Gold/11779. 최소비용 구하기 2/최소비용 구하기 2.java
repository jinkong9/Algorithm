
import java.io.*;
import java.util.*;

public class Main {
	static int N,M;
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
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		
		list = new ArrayList[N+1];
		for(int i=1; i<=N; i++) list[i] = new ArrayList<>();
		
		for(int i=0; i<M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			
			list[A].add(new Ver(B,w));
		}
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());
		
		dijkstra(start, end);
	}

	static void dijkstra(int start, int end) {
		PriorityQueue<Ver> Q = new PriorityQueue<>();
		boolean check[] = new boolean[N+1];
		int dist [] = new int[N+1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[start] = 0;
		int arr [] = new int[N+1];
		Q.offer(new Ver(start,0));
		
		while(!Q.isEmpty()) {
			Ver now = Q.poll();
			if(check[now.to]) continue;
			check[now.to] = true;
			for(Ver next : list[now.to]) {
				if(dist[next.to] > dist[now.to] + next.w) {
					dist[next.to] = dist[now.to] + next.w;
					Q.offer(new Ver(next.to, dist[next.to]));
					arr[next.to] = now.to;
				}
			}
		}
		System.out.println(dist[end]);
		ArrayList<Integer> a = new ArrayList<>();
		int cur = end;
		while(cur !=0) {
			a.add(cur);
			cur = arr[cur];
		}
		System.out.println(a.size());
		Collections.reverse(a);
		for(int i : a) {
			System.out.print(i + " ");
		}
	}
}
