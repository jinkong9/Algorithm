import java.io.*;
import java.util.*;
public class Main {
	static int N,E, s1,s2,ans,ans2;
	static boolean f[];
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
	static ArrayList<Ver> list[];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		list = new ArrayList[N+1];
		for(int i=1; i<= N; i++) list[i] = new ArrayList<>();
		for(int i=0; i<E; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			list[a].add(new Ver(b,w));
			list[b].add(new Ver(a,w));
		}
		st = new StringTokenizer(br.readLine());
		s1 = Integer.parseInt(st.nextToken());
		s2 = Integer.parseInt(st.nextToken());
		ans = ans2 = 0;
		int arr[] = new int[4];
		int arr1[] = new int[4];
		arr[0] = 1; arr[1] = s1; arr[2] = s2; arr[3] = N;
		arr1[0] = 1; arr1[1] = s2; arr1[2] = s1; arr1[3] = N;
		for(int i=1; i<4; i++) {
			dijkstra(arr[i-1], arr[i]);
		}
		for(int i=1; i<4; i++) {
			dijkstra1(arr1[i-1], arr1[i]);
		}
		int res = Math.min(ans, ans2);

		if(res >= Integer.MAX_VALUE) System.out.println(-1);
		else System.out.println(res);
		
	}

	static void dijkstra(int s, int e) {
		PriorityQueue<Ver> Q = new PriorityQueue<>();
		int dist[] = new int[N+1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[s] = 0;
		Q.offer(new Ver(s,0));
		
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
		if(dist[e] == Integer.MAX_VALUE) ans = Integer.MAX_VALUE;
		else ans += dist[e];
		
	}
	static void dijkstra1(int s, int e) {
		PriorityQueue<Ver> Q = new PriorityQueue<>();
		int dist[] = new int[N+1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[s] = 0;
		Q.offer(new Ver(s,0));
		
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
		if(dist[e] == Integer.MAX_VALUE) ans2 = Integer.MAX_VALUE;
		else ans2 += dist[e];
		
	}
}
