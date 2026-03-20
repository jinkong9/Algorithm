
import java.io.*;
import java.util.*;
public class Main {
	static int N,K;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		int w[] = new int[N+1];
		int v[] = new int[N+1];
		for(int i=1; i<=N; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			w[i] = a;
			v[i] = b;
		}
		
		int dp[][] = new int[N+1][K+1];
		
		for(int i=1; i<=N; i++) {
			for(int j=0; j<=K; j++) {
				dp[i][j] = dp[i-1][j];
				
				if(j >= w[i]) {
					dp[i][j] = Math.max(dp[i][j], dp[i-1][j-w[i]] + v[i]);
				}
			}
		}
		
		System.out.println(dp[N][K]);
	}

}
