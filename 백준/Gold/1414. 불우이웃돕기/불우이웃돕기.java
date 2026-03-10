import java.io.*;
import java.util.*;
public class Main {
	static int N, parent[];
	
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
		N = Integer.parseInt(br.readLine());
		parent = new int[N+1];
		for(int i=1; i<=N; i++) parent[i] = i;
		list = new ArrayList<>();
		boolean check[] = new boolean[N+1];
		int to = 0;
		for(int i=1; i<=N; i++) {
			String s = br.readLine();
			for(int j=1; j<=N; j++) {
				char a = s.charAt(j-1);
				int w = 0;
				if(a >= 'a' && a <= 'z') w = a - 'a' + 1;
				else if(a >= 'A' && a <= 'Z') w = a - 'A' + 27;
				else w = 0;
				if(N == 1) {
					System.out.println(w);
					System.exit(0);
				}
				to += w;
				if(w >0 && i != j) list.add(new Ver(i,j,w));
			}
		}
		
		Collections.sort(list, (a,b) -> a.w - b.w);
		int sum = 0;
		int cnt = 0;
		for(Ver v : list) {
			if(find(v.from) != find(v.to)) {
				check[v.from] = check[v.to] = true;
				union(v.from, v.to);
				sum += v.w;
				cnt ++;
			}
			if(cnt == N-1) break;
		}
		if(cnt != N-1) {
		    System.out.println(-1);
		} else {
		    System.out.println(to-sum);
		}
	
	}

}
