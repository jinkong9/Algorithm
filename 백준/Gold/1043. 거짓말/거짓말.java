import java.io.*;
import java.util.*;

public class Main {
	static int N, parent[],M;

	static int find(int a) {
		if (a == parent[a])
			return a;
		return parent[a] = find(parent[a]);
	}

	static void union(int a, int b) {
		a = find(a);
		b = find(b);
		if(a != b) {
			parent[a] = b;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		parent = new int[N+1];
		for(int i =1; i<=N; i++) parent[i] = i;
		
		st = new StringTokenizer(br.readLine());
		int A = Integer.parseInt(st.nextToken());
		if(A == 0) {
			System.out.println(M);
			System.exit(0);
		}
		int arr[] = new int [A];
		ArrayList<Integer> list[] = new ArrayList[M];
		for(int i=0; i<M; i++) list[i] = new ArrayList<>();
		for(int i=0; i<A; i++) {
			int B = Integer.parseInt(st.nextToken());
			arr[i] = B;
		}
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken());
			int first = Integer.parseInt(st.nextToken());
			list[i].add(first);
			if(num>=2) {
				for(int j=1; j<num; j++) {
					int two = Integer.parseInt(st.nextToken());
					list[i].add(two);
					union(first,two);
				}
			}
		}
		int answer = 0;
		for(int i=0; i<M; i++) {
			boolean ok = false;
			for(int a : list[i]) {
				for(int b : arr) {
					if(find(a) == find(b)) {
						ok = true;
						break;
					}
				}
				if(ok) break;
			}
			if(!ok) answer ++;
		}
		System.out.println(answer);
	}

}
