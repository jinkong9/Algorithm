
import java.io.*;
import java.util.*;

public class Main {
	static int N, M, K, parent[];

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

	static class Ver {
		int from, to, w;

		Ver(int from, int to, int w) {
			this.from = from;
			this.to = to;
			this.w = w;
		}
	}

	static ArrayList<Ver> list;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		parent = new int[N + 1];
		for (int i = 1; i <= N; i++)
			parent[i] = i;
		list = new ArrayList<>();
		int arr[] = new int[K];
		st = new StringTokenizer(br.readLine()); // 발전소
		for (int i = 0; i < K; i++) {
			int elec = Integer.parseInt(st.nextToken());
			arr[i] = elec;
		}

		for (int i = 1; i < K; i++) {
			union(arr[0], arr[i]);
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			list.add(new Ver(a, b, w));
		}

		Collections.sort(list, (a, b) -> a.w - b.w);

		int sum = 0;
		for (Ver v : list) {
			if (find(v.from) != find(v.to)) {
				union(v.from, v.to);
				sum += v.w;
			}
		}
		System.out.println(sum);
	}

}
