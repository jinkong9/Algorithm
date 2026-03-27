import java.io.*;
import java.util.*;

public class Main {
	static int N, M, parent[], arr[];
	static long K;

	static int find(int a) {
		if (a == parent[a])
			return a;
		return parent[a] = find(parent[a]);
	}

	static void union(int a, int b) {
		a = find(a);
		b = find(b);
		if (a != b) {
			parent[a] = b;
		}
	}

	static class Ver implements Comparable<Ver> {
		int from, to;
		long w;

		Ver(int from, int to, long w) {
			this.from = from;
			this.to = to;
			this.w = w;
		}

		@Override
		public int compareTo(Ver o) {
			return Long.compare(this.w, o.w);
		}
	}

	static ArrayList<Ver> list;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Long.parseLong(st.nextToken());

		if (M <= 1) {
			System.out.println("YES");
			return;
		}

		arr = new int[N + 1];
		parent = new int[N + 1];
		list = new ArrayList<>();
		for (int i = 0; i <= N; i++)
			parent[i] = i;

		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++)
			arr[i] = Integer.parseInt(st.nextToken());

		boolean c1[] = new boolean[N + 1];

		for (int i = 1; i <= N; i++) {
			list.add(new Ver(0, i, arr[i]));
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			if (a > b) {
				int tmp = a;
				a = b;
				b = tmp;
			}
			if ((a == 1 && b == N)) {
				c1[N] = true;
			} else {
				c1[a] = true;
			}
		}

		boolean all = true;
		for (int i = 1; i <= N; i++) {
			if (c1[i]) {
				all = false;
				break;
			}
		}
		if (all) {
			System.out.println("YES");
			return;
		}

		for (int i = 1; i < N; i++) {
			if (!c1[i]) {
				list.add(new Ver(i, i + 1, 0));
			}
		}
		if (!c1[N]) {
			list.add(new Ver(N, 1, 0));
		}

		Collections.sort(list);
		long sum = 0;
		int edges = 0;
		for (Ver v : list) {
			if (find(v.from) != find(v.to)) {
				union(v.from, v.to);
				sum += v.w;
				edges++;
			}
		}

		if (sum <= K && edges == N)
			System.out.println("YES");
		else
			System.out.println("NO");
	}
}