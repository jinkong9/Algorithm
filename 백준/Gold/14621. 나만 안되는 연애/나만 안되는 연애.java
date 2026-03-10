
import java.io.*;
import java.util.*;
public class Main {
	static int N,M, parent[];
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
		st = new StringTokenizer(br.readLine());
		String s[] = new String[N];
		for(int i=0; i<N; i++) s[i] = st.nextToken();
		list = new ArrayList<>();
		parent = new int[N+1];
		for(int i=1; i<=N; i++) parent[i] = i;
		boolean vi[] = new boolean [N+1];
		for(int i=0; i<N; i++) {
			if(s[i].equals("M")) {
				vi[i+1] = true;
			}
		}
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			if( (vi[from] && !vi[to]) || (vi[to] && !vi[from]) ) {
				list.add(new Ver(from, to,w));
			}
		}
		boolean v1[] = new boolean [N+1];
		Collections.sort(list, (a,b) -> a.w - b.w);
		int dist = 0;
		for(Ver v : list) {
			if(find(v.from) != find(v.to)) {
				v1[v.from] = v1[v.to] = true;
				union(v.from, v.to);
				dist += v.w;
			}
		}
		
		for(int i=1; i<=N; i++) {
			if(!v1[i]) {
				System.out.println(-1);
				System.exit(0);
			}
		}
		System.out.println(dist);
		
	}

}
