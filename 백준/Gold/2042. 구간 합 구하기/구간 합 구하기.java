import java.io.*;
import java.util.*;

public class Main {
	static int N,M,K;
	static long tree[], arr[];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken()); // 변경
		K = Integer.parseInt(st.nextToken()); // 합
		arr = new long[N];
		tree = new long[4*N];
		for(int i=0; i<N; i++) {
			long a = Long.parseLong(br.readLine().trim());
			arr[i] = a;
		}
		build(1,0,N-1);
		for(int i=0; i<M+K; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			long c = Long.parseLong(st.nextToken());
			if(a == 1) { // 변경
				update(1,0,N-1,b-1,c);
			}
			if(a == 2) { // 합
				long sum = query(1,0,N-1,b-1,c-1);
				System.out.println(sum);
			}
		}
	}

	static void build(int node, int start, int end) { // Build
		if(start == end) {
			tree[node] = arr[start]; // 리프노드
			return;
		}
		int mid = (start+end) /2;
		build(2 * node, start,mid); // 왼쪽자식
		build(2 * node+1, mid+1, end); // 오른쪽 자식
		tree[node] = tree[2*node] + tree[2*node+1];
	}
	
	static long query(int node, int start, int end, int L, long R) { // 쿼리합
		if(R < start || end < L) return 0;
		if(L <= start && end <= R) return tree[node];
		int mid = (start + end) / 2;
		return query(2*node, start, mid,L,R) + query(2*node+1, mid+1, end, L, R);
	}
	
	static void update(int node, int start, int end, int idx, long val) { // 값 변경
		if(start == end) {
			tree[node] = val;
			return;
		}
		
		int mid = (start + end) / 2;
		if(idx <= mid) {
			update(2*node, start,mid,idx,val);
		} else {
			update(2*node+1, mid +1, end, idx, val);
		}
		tree[node] = tree[2*node] + tree[2*node+1];
	}
}
