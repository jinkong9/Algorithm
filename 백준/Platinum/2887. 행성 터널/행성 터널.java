
import java.io.*;
import java.util.*;

public class Main {
	static int N,  parent[], arr[][];
	static int find(int a) {
		if(a == parent[a]) return a;
		return parent[a] = find(parent[a]);
	}
	static void union(int a, int b) {
		a = find(a);
		b = find(b);
		if(a != b) parent[a] = b;
	}
	static class Point {
		int i,x,y,z;
		Point(int i,int x, int y, int z) {
			this.i = i;
			this.x = x;
			this.y = y;
			this.z = z;
		}
	}
	static class Ver implements Comparable<Ver> {
		int from,to,w;
		Ver(int from, int to, int w) {
			this.from = from;
			this.to = to;
			this.w = w;
		}
		@Override
		public int compareTo(Ver o) {
			return this.w - o.w;
		}
	}
	static ArrayList<Ver> list;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		parent = new int[N];
		for(int i=0; i<N; i++) parent[i] = i;
		list = new ArrayList<>();
		ArrayList<Point> list2 = new ArrayList<>();
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int z = Integer.parseInt(st.nextToken());
			list2.add(new Point(i,x,y,z));
		}
		
		Collections.sort(list2, (a,b) -> a.x - b.x);

		for(int i=0;i<N-1;i++){
		    Point p1 = list2.get(i);
		    Point p2 = list2.get(i+1);

		    int cost = Math.abs(p1.x - p2.x);
		    list.add(new Ver(p1.i, p2.i, cost));
		}
		
		Collections.sort(list2, (a,b) -> a.y - b.y);

		for(int i=0;i<N-1;i++){
		    Point p1 = list2.get(i);
		    Point p2 = list2.get(i+1);

		    int cost = Math.abs(p1.y - p2.y);
		    list.add(new Ver(p1.i, p2.i, cost));
		}
		
		Collections.sort(list2, (a,b) -> a.z - b.z);

		for(int i=0;i<N-1;i++){
		    Point p1 = list2.get(i);
		    Point p2 = list2.get(i+1);

		    int cost = Math.abs(p1.z - p2.z);
		    list.add(new Ver(p1.i, p2.i, cost));
		}
		
		int ans = 0;
		Collections.sort(list,(a,b) -> a.w - b.w);
		for(Ver v : list) {
			if(find(v.from) != find(v.to)) {
				union(v.from, v.to);
				ans += v.w;
			}
		}
		System.out.println(ans);
	}
}
