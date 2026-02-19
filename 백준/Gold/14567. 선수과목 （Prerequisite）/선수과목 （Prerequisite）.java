
import java.io.*;
import java.util.*;

public class Main {
	static int N, M;
	static ArrayList<Integer> list[];
	static int ind[];
	static StringBuilder sb;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		list = new ArrayList[N + 1];
		ind = new int[N + 1];

		for (int i = 1; i <= N; i++) {
			list[i] = new ArrayList<>();
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			list[A].add(B);
			ind[B]++;
		}
		sb = new StringBuilder();
		dfs();
		System.out.println(sb);
	}

	static void dfs() {
		int res[] = new int[N + 1];
		Queue<Integer> Q = new ArrayDeque<>();

		for (int i = 1; i <= N; i++) {
			if (ind[i] == 0) {
				res[i] = 1;
				Q.offer(i);
			}
		}
		while (!Q.isEmpty()) {
			int now = Q.poll();

			for (int i : list[now]) {
				ind[i]--;
				res[i] = Math.max(res[i], res[now] + 1);

				if (ind[i] == 0) {
					Q.offer(i);
				}
			}
		}
		for (int i = 1; i <= N; i++) {
			sb.append(res[i]).append(" ");
		}
	}
}
