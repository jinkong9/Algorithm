
import java.io.*;
import java.util.*;
public class Main {
	static int C,N;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		C = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		int c[] = new int[N];
		int p[] = new int[N];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			c[i] = a;
			p[i] = b;
		}
		
		int max = C +100;
		int INF = 100_000_000;
		
		int dp[] = new int[max];
		Arrays.fill(dp, INF);
		dp[0] = 0;
		
		for(int i=0; i<N; i++) {
			for(int j= p[i]; j<max; j++) {
				dp[j] = Math.min(dp[j], dp[j - p[i]] + c[i]);
			}
		}
		
		int ans = INF;
		for(int i=C; i<max; i++) {
			ans = Math.min(ans, dp[i]);
		}
		System.out.println(ans);
	}

}
