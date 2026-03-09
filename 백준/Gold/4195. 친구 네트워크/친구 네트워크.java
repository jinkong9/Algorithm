
import java.io.*;
import java.util.*;

public class Main {
	static int N, parent[], size[];

	static int find(int a) {
		if (a == parent[a])
			return a;
		return parent[a] = find(parent[a]);
	}

	static int union(int a, int b) {
		a = find(a);
		b = find(b);
		if(a != b) {
			parent[b] = a;
			size[a] += size[b];
		}
		return size[a];
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			int idx = 0;
			parent = new int[2 * N + 1];
			size = new int[2 * N +1];
			for (int i = 0; i < 2 * N; i++) {
				parent[i] = i;
				size[i] = 1;
			}
			HashMap<String, Integer> map = new HashMap<>();
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				String a = st.nextToken();
				String b = st.nextToken();
				if(!map.containsKey(a)) map.put(a, idx++);
				if(!map.containsKey(b)) map.put(b, idx++);
				
				int x = map.get(a);
				int y = map.get(b);
				int A = union(x,y);
				sb.append(A).append("\n");
			}
			System.out.print(sb);
		}
	}

	static void check() {
		int cnt = 0;
		for (int i = 0; i < 2 * N + 1; i++) {
			if (parent[i] != i)
				cnt++;
		}
		System.out.println(cnt);
	}
}
