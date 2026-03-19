import java.io.*;
import java.util.*;

public class Main {
	static int N,M,K,parent[];
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
		K = Integer.parseInt(st.nextToken());
		parent = new int[N+1];
		list = new ArrayList<>();
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			list.add(new Ver(a,b,w));
		}
		Collections.sort(list);
		ArrayList<Ver> mst = new ArrayList<>();
        for(int d=1; d<=N; d++) parent[d] = d;
        for(Ver v : list) {
            if(find(v.from) != find(v.to)) {
                union(v.from, v.to);
                mst.add(v);
            }
        }
        
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<K; i++) {
            for(int d=1; d<=N; d++) parent[d] = d;
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            
            for(Ver v : mst) {
                union(v.from, v.to);
                
                if(find(a) == find(b)) {
                    sb.append(v.w).append("\n");
                    break;
                }
            }
        }
        System.out.print(sb);
    }
}