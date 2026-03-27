import java.io.*;
import java.util.*;
public class Main {
	static int N,M, parent[], s, e;
	static int find(int a) {
		if(a == parent[a]) return a;
		return parent[a] = find(parent[a]);
	}
	static void union(int a, int b) {
		a = find(a);
		b = find(b);
		if(a != b) {
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
			return Long.compare(o.w, this.w);
		}
	}
	static ArrayList<Ver> list;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		s = Integer.parseInt(st.nextToken());
		e = Integer.parseInt(st.nextToken());
		
		list = new ArrayList<>();
		parent = new int[N+1];
		for(int i=1; i<=N; i++) parent[i] = i;
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			list.add(new Ver(a,b,w));
			list.add(new Ver(b,a,w));
		}
		long ans = 0;
		Collections.sort(list);
		
		for(Ver v : list) {
			union(v.from, v.to);
			if(find(s) == find(e)) {
				ans = v.w;
				break;
			}
		}
		
		System.out.println(ans);
	}

}
