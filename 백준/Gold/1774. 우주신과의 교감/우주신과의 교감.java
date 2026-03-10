
import java.io.*;
import java.util.*;

public class Main {
	static int N, M, K, parent[];

	static int find(int a) {
		if (a == parent[a])
			return a;
		return parent[a] = find(parent[a]);
	}

	static void union(int a, int b) {
		a = find(a);
		b = find(b);
		if (a != b) {
			parent[a] = b;
		}
	}

	static class Ver implements Comparable<Ver> {
		int from, to;
		double w;

		Ver(int from, int to, double w) {
			this.from = from;
			this.to = to;
			this.w = w;
		}

		@Override
		public int compareTo(Ver o) {
			return Double.compare(this.w, o.w);
		}
	}
	
	static double dist(int x1,int y1, int x2, int y2) {
		double tmpx =Math.abs(x1 - x2);
        double tmpy =Math.abs(y1 - y2);
        double d = Math.pow(tmpx, 2) + Math.pow(tmpy,2);
        return Math.sqrt(d);
	}
	
	static ArrayList<Ver> list;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		parent = new int[N+1];
		list = new ArrayList<>();
		for(int i=1; i<=N; i++) parent[i] = i;
		int x[] = new int[N+1];
		int y[] = new int[N+1];
		for(int i=1; i<=N; i++) {
			st = new StringTokenizer(br.readLine());
			x[i] = Integer.parseInt(st.nextToken());
			y[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i=1; i<=N; i++) {
			for(int j=i+1; j<=N; j++) {
				double d = dist(x[i],y[i],x[j],y[j]);
				list.add(new Ver(i,j,d));
			}
		}
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int X = Integer.parseInt(st.nextToken());
			int Y = Integer.parseInt(st.nextToken());
			union(X, Y);
		}
		
		Collections.sort(list);
		double sum = 0;
		int cnt = 0;
		for(Ver v : list) {
			if(find(v.from) != find(v.to)) {
				union(v.from, v.to);
				cnt ++;
				sum += v.w;
			}
			if(cnt == N-1) break;
		}
		System.out.printf("%.2f\n", sum);
	}

}
