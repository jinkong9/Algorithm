
import java.io.*;
import java.util.*;
public class Main {
	static int N,K,max;
	static ArrayList<Ver> list[];
	static class Ver implements Comparable<Ver> {
		int x,t;
		Ver(int x, int t) {
			this.x = x;
			this.t =t;
		}
		@Override
		public int compareTo(Ver o) {
			return this.t - o.t;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		max = 100_000;
		int a = dijkstra(N,K);
		System.out.println(a);
	}

	static int dijkstra(int start, int end) {
		PriorityQueue<Ver> Q = new PriorityQueue<>();
		int dist[] = new int[max +1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[start] = 0;
		Q.offer(new Ver(start,0));
		
		while(!Q.isEmpty()) {
			Ver now = Q.poll();
			int x = now.x;
			int nt = now.t;
			
			if(nt > dist[now.x]) continue;
			
			int nx = 2*x;
			if(nx <= max && dist[nx] > nt) {
				dist[nx] = nt;
				Q.offer(new Ver(nx,nt));
			}
			nx = x+1;
			if(nx <= max && dist[nx] > nt+1) {
				dist[nx] = nt+1;
				Q.offer(new Ver(nx,nt+1));
			}
			nx = x-1;
			if(nx >= 0 && dist[nx] > nt+1) {
				dist[nx] = nt+1;
				Q.offer(new Ver(nx,nt+1));
			}
		}
		return dist[end];
	}
}
