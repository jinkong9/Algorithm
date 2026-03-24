import java.io.*;
import java.util.*;

public class Main {
	static int N, M, K;
	static long tree[], arr[], tree1[];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken()); // 변경
		arr = new long[N];
		tree = new long[4 * N];
		tree1 = new long[4 * N];
		for (int i = 0; i < N; i++) {
			long a = Long.parseLong(br.readLine().trim());
			arr[i] = a;
		}
		build(1, 0, N - 1);

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			long max = query(1, 0, N - 1, a - 1, b - 1);
			long min = query1(1, 0, N - 1, a - 1, b - 1);
			System.out.print(min + " ");
			System.out.println(max);
		}
	}

	static void build(int node, int start, int end) { // Build
		if (start == end) {
			tree[node] = arr[start];
			tree1[node] = arr[start];// 리프노드
			return;
		}
		int mid = (start + end) / 2;
		build(2 * node, start, mid); // 왼쪽자식
		build(2 * node + 1, mid + 1, end); // 오른쪽 자식
		tree[node] = Math.max(tree[2 * node], tree[2 * node + 1]);
		tree1[node] = Math.min(tree1[2 * node], tree1[2 * node + 1]);
	}

	static long query(int node, int start, int end, int L, long R) { // 쿼리합
		if (R < start || end < L)
			return Long.MIN_VALUE;
		if (L <= start && end <= R)
			return tree[node];
		int mid = (start + end) / 2;
		return Math.max(query(2 * node, start, mid, L, R), query(2 * node + 1, mid + 1, end, L, R));
	}

	static long query1(int node, int start, int end, int L, long R) { // 쿼리합
		if (R < start || end < L)
			return Long.MAX_VALUE;
		if (L <= start && end <= R)
			return tree1[node];
		int mid = (start + end) / 2;
		return Math.min(query1(2 * node, start, mid, L, R), query1(2 * node + 1, mid + 1, end, L, R));
	}

}
