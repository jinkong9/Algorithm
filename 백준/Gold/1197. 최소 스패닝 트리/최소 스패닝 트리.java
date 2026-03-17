
import java.io.*;
import java.util.*;
public class Main {
	static int V,E, parent[];
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
			return Long.compare(this.w, o.w);
		}
	}
	static ArrayList<Ver> list;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		list = new ArrayList<>();
		parent = new int[V+1];
		for(int i=1; i<=V; i++) parent[i] = i;
		for(int i=0; i<E; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			list.add(new Ver(a,b,w));
		}
		
		Collections.sort(list);
		int sum = 0;
		for(Ver v : list) {
			if(find(v.from) != find(v.to)) {
				union(v.from, v.to);
				sum += v.w;
			}
		}
		System.out.println(sum);
	}

}
