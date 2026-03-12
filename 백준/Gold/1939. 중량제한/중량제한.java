import java.io.*;
import java.util.*;

public class Main {
	static int N, M, K, num, meet[], w;
	static long ans;

	static class Ver implements Comparable<Ver> {
		int to;
		long w;

		Ver(int to, long dist) {
			this.to = to;
			this.w = dist;
		}

		@Override
		public int compareTo(Ver o) {
			return Long.compare(o.w, this.w);
		}
	}

	static ArrayList<Ver> list[];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		list = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++)
			list[i] = new ArrayList<>();

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			w = Integer.parseInt(st.nextToken());
			list[a].add(new Ver(b, w));
			list[b].add(new Ver(a, w));
		}

		if (M == 1) {
			System.out.println(w);
			System.exit(0);
		}

		long ans = 0;

		st = new StringTokenizer(br.readLine());

		int f = Integer.parseInt(st.nextToken());
		int s = Integer.parseInt(st.nextToken());

		ans = dijkstra(f,s);
		System.out.println(ans);

	}

	static long dijkstra(int start, int end) {
		PriorityQueue<Ver> Q = new PriorityQueue<>();
		Q.offer(new Ver(start, Integer.MAX_VALUE));
		long dist[] = new long[N + 1];
		Arrays.fill(dist, 0);
		dist[start] = Integer.MAX_VALUE;

		while (!Q.isEmpty()) {
			Ver now = Q.poll();
            if(now.to == end) return now.w;
			if (now.w > dist[now.to])
				continue;

			for (Ver next : list[now.to]) {
				if (dist[next.to] < Math.min(dist[now.to], next.w)) {
					dist[next.to] = Math.min(dist[now.to], next.w);
					Q.offer(new Ver(next.to, Math.min(dist[now.to], next.w)));
				}
			}
		}
		return dist[end];

	}
}
