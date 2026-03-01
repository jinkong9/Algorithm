
import java.io.*;
import java.util.*;
public class Main {
	static ArrayList<Integer> list[];
	static int ind[],N,M;
	static StringBuilder sb;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new  StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		list = new ArrayList[N+1];
		ind = new int [N+1];
		
		for(int i=1; i<=N; i++) {
			list[i] = new ArrayList<>();
		}
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			list[A].add(B);
			ind[B] ++;
		}
		sb = new StringBuilder();
		bfs();
		System.out.println(sb);
	}
	
	static void bfs() {
		PriorityQueue<Integer> Q = new PriorityQueue<>();
		int res[] = new int[N+1];
		
		for(int i=1; i<=N; i++) {
			if(ind[i] == 0) {
				res[i] = 1;
				Q.offer(i);
			}
		}
		
		while(!Q.isEmpty()) {
			int now = Q.poll();
			sb.append(now).append(" ");
			for(int i : list[now]) {
				ind[i] --;
				res[i] = Math.max(res[i], res[now] +1);
				
				if(ind[i] ==0) {
					Q.offer(i);
				}
			}
		}
	}

}
