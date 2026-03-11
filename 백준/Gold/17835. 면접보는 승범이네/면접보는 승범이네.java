
import java.io.*;
import java.util.*;

public class Main {
	static int N, M, K, num, meet[];
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
			return Long.compare(this.w, o.w);
		}
	}

	static ArrayList<Ver> list[];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		list = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++)
			list[i] = new ArrayList<>();

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			list[b].add(new Ver(a, w));
		}

		st = new StringTokenizer(br.readLine());
		meet = new int[K];
		for (int i = 0; i < K; i++) {
			meet[i] = Integer.parseInt(st.nextToken());
		}
		num = 0;
		ans = 0;
		long a[] = dijkstra();
		for (int i = 1; i <= N; i++) {
			if(a[i] > ans) {
				ans = a[i];
				num = i;
			} else if (a[i] == ans) {
				num = Math.min(num, i);
			}
		}
		System.out.println(num);
		System.out.println(ans);
	}

	static long[] dijkstra() {
		PriorityQueue<Ver> Q = new PriorityQueue<>();
		long[] dist = new long[N + 1];
		Arrays.fill(dist, Long.MAX_VALUE);
		for (int i = 0; i < K; i++) {
			Q.offer(new Ver(meet[i], 0));
			dist[meet[i]] = 0;
		}

		while (!Q.isEmpty()) {
			Ver now = Q.poll();

			if (now.w > dist[now.to])
				continue;

			for (Ver next : list[now.to]) {
				if (dist[now.to] != Integer.MAX_VALUE && dist[next.to] > dist[now.to] + next.w) {
					dist[next.to] = dist[now.to] + next.w;
					Q.offer(new Ver(next.to, dist[next.to]));
				}
			}
		}
		return dist;
	}
}
