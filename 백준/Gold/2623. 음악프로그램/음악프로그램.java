import java.io.*;
import java.util.*;
public class Main {
	static ArrayList<Integer> list[];
	static int ind[],N,M;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		list = new ArrayList[N+1];
		ind = new int[N+1];
		for(int i=1; i<=N; i++) {
			list[i] = new ArrayList<>();
		}
		
		for(int i=1; i<=M; i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			for(int j=1; j<A; j++) {
				int C = Integer.parseInt(st.nextToken());
				list[B].add(C);
				ind[C] ++;
                B = C;
			}
		}
		dfs();
	}
	
	static void dfs() {
		ArrayList<Integer> res = new ArrayList<>();
		Queue <Integer> Q = new ArrayDeque<>();
		
		for(int i=1; i<=N; i++) {
			if(ind[i] == 0) {
				Q.offer(i);
			}
		}
		
		while(!Q.isEmpty()) {
			int now = Q.poll();
			res.add(now);
			for(int i : list[now]) {
				ind[i] --;
				
				if(ind[i] == 0) {
					Q.offer(i);
				}
			}
		}
		if(res.size() != N) {
			System.out.println(0);
			return ;
		}
		for(int i : res) {
			System.out.println(i);
		}
	}
}
