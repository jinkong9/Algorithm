import java.io.*;
import java.util.StringTokenizer;
public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int coin[] = new int[N+1];
		
		for(int i = 1; i<=N; i++) {
			coin[i] = Integer.parseInt(br.readLine());
		}
		
		int dp[] = new int[K+1];
		dp[0] = 1;
		for(int i=1; i<=N; i++) {
			for(int j=coin[i]; j<= K; j++) {
				dp[j] += dp[j-coin[i]];
			}
		}
		
		System.out.println(dp[K]);
	}

}
