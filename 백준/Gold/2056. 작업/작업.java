
import java.io.*;
import java.util.*;
public class Main {
	static int N;
	static ArrayList<Integer> list[];
	static int ind[], time[], res[];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		list = new ArrayList[N+1];
		ind = new int[N+1];
		time = new int[N+1];
		
		for(int i=1; i<=N; i++) {
			list[i] = new ArrayList<>();
		}
		
		for(int i=1; i<=N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int A =Integer.parseInt(st.nextToken());
			time[i] = A;
			int B = Integer.parseInt(st.nextToken());
			for(int j=0; j <B; j++) {
				int a = Integer.parseInt(st.nextToken());
				list[i].add(a);
				ind[a]++;
			}
		}
		int ans = dfs();
		System.out.println(ans);
	}
	
	static int dfs() {
		res = new int[N+1];
		Queue <Integer> Q = new ArrayDeque<>();
		
		for(int i=1; i<=N; i++) {
			if(ind[i] == 0) {
				Q.offer(i);
				res[i] = time[i];
			}
		}
		
		while(!Q.isEmpty()) {
			int now = Q.poll();
			
			for(int i : list[now]) {
				ind[i] --;
				res[i] = Math.max(res[i] , res[now] + time[i]);
				
				if(ind[i] == 0) {
					Q.offer(i);
				}
			}
		}
		int a = 0;
		for(int i=1; i<=N; i++) {
			a = Math.max(a, res[i]);
		}
		return a;
	}

}
