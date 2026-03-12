import java.io.*;
import java.util.*;

public class Main {
	static int N, M, D, E;
	static long ans, arr[];

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
		N = Integer.parseInt(st.nextToken()); // 지도 지점 개수
		M = Integer.parseInt(st.nextToken()); // 지점 잇는 경로개수
		D = Integer.parseInt(st.nextToken()); // 거리 비례 체력 소모량
		E = Integer.parseInt(st.nextToken()); // 높이 비례 성취감 획득
		// 가치 -> 얻은 성취감 - 소모한 체력
		list = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++)
			list[i] = new ArrayList<>();
		arr = new long[N + 1];
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			list[a].add(new Ver(b, w));
			list[b].add(new Ver(a, w));
		}
		ans = Long.MIN_VALUE;
		long a[] = dijkstra(1);
		long b[] = dijkstra(N);

		for (int i = 2; i < N; i++) {
			if (a[i] == Long.MAX_VALUE || b[i] == Long.MAX_VALUE)
				continue;
			long tmp = (arr[i] * E) - (a[i] + b[i]) * D;
			ans = Math.max(ans, tmp);
		}

		if (ans == Long.MIN_VALUE) {
			System.out.println("Impossible");
		} else {
			System.out.println(ans);
		}
		// 경유지를 갈 때에는 높아야하고
		// 고려대를 갈 때에는 낮아야함
		// 체력소모는 w * D
		// 성취감은 h * E
		// 가치는 h * E - w * D
	}

	static long[] dijkstra(int start) {

		PriorityQueue<Ver> pq = new PriorityQueue<>();
		long dist[] = new long[N + 1];
		Arrays.fill(dist, Long.MAX_VALUE);

		dist[start] = 0;
		pq.add(new Ver(start, 0));

		while (!pq.isEmpty()) {

			Ver now = pq.poll();

			if (dist[now.to] < now.w)
				continue;

			for (Ver next : list[now.to]) {

				if (arr[next.to] <= arr[now.to])
					continue;

				if (dist[next.to] > dist[now.to] + next.w) {

					dist[next.to] = dist[now.to] + next.w;
					pq.add(new Ver(next.to, dist[next.to]));
				}
			}
		}

		return dist;
	}

}
