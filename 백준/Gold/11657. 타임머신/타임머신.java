
import java.io.*;
import java.util.*;

public class Main {
	static int N,M;
	static long dist[];
	static class Ver {
		int from, to, w;
		Ver(int from, int to, int w) {
			this.from = from;
			this.to = to;
			this.w = w;
		}
	}
	static ArrayList <Ver> list;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		list = new ArrayList<>();
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		dist = new long[N+1];
		Arrays.fill(dist, Long.MAX_VALUE);
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			list.add(new Ver(a,b,w));
		}
		boolean f = bellman(1);
		if(f) {
			System.out.println(-1);
			return;
		}
		for(int i=2; i<=N; i++) {
			if(dist[i] == Long.MAX_VALUE) {
				System.out.println(-1);
			}
			else System.out.println(dist[i]);
		}
		
	}

	static boolean bellman(int start) {
		dist[start] = 0;
		
		for(int i=1; i<=N; i++) {
			for(Ver v : list) {
				if(dist[v.from] != Long.MAX_VALUE && dist[v.to] > dist[v.from] + v.w) {
					dist[v.to] = dist[v.from] + v.w;
				}
			}
		}
		for(Ver v : list) {
			if(dist[v.from] != Long.MAX_VALUE && dist[v.to] > dist[v.from] + v.w) {
				return true;
			}
		}
		return false;
	}
}
