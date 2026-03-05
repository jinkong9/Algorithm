
import java.io.*;
import java.util.*;
public class Main {
	static int N, M, parent[], arr[][];
	static int find(int a) {
		if(a == parent[a]) return a;
		return parent[a] = find(parent[a]);
	}
	static void union(int a, int b) {
		a = find(a);
		b = find(b);
		if(a != b) parent[a] = b;
	}
	static class Ver {
		int from,to,w;
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
		
		parent = new int[N+1];
		for(int i=1; i<=N; i++) parent[i] = i;
		list = new ArrayList<>();
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());
			list.add(new Ver(A,B,C));
		}
		
		int sum = 0;
		int max = 0;
		Collections.sort(list,(a,b) -> a.w - b.w);
		for(Ver v : list) {
			if(find(v.from) != find(v.to)) {
				union(v.from, v.to);
				max = Math.max(max, v.w);
				sum += v.w;
			}
		}
		System.out.println(sum-max);
	}
 
}
