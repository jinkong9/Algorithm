import java.io.*;
import java.util.*;

public class Main {
	static int N, M, parent[];

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
		N = Integer.parseInt(br.readLine());
		parent = new int[N+1];
		for (int i = 0; i <= N; i++)
			parent[i] = i;
		int arr[] = new int[N];
		list = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			int a = Integer.parseInt(br.readLine());
			arr[i] = a;
			list.add(new Ver(0,i+1,arr[i]));
		}
		for (int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j=1; j<=N; j++) {
					int t = Integer.parseInt(st.nextToken());
					if(i == j) continue;
					list.add(new Ver(i, j, t));
				}
		}
		int sum = 0;
		Collections.sort(list, (a, b) -> a.w - b.w);
		for (Ver v : list) {
			if (find(v.from) != find(v.to)) {
				union(v.from, v.to);
				sum += v.w;
			}
		}
		System.out.println(sum);
	}
}
