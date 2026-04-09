import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int act[] = new int[N+1];
		int memo[] = new int[N+1];
		
		int maxCost = 0;
		
		st = new StringTokenizer(br.readLine());
		for(int i=1; i<=N; i++) {
			act[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		for(int i=1; i<=N; i++) {
			memo[i] = Integer.parseInt(st.nextToken());
			maxCost += memo[i];
		}
		
		long dp[] = new long[maxCost + 1];

		for(int i = 1; i <= N; i++) {
		    for(int j = maxCost; j >= memo[i]; j--) {
		        dp[j] = Math.max(dp[j], dp[j - memo[i]] + act[i]);
		    }
		}
		int ans = 0;
		for(int i=0; i<=maxCost; i++) {
			if(dp[i] >=M) {
				ans = i;
				break;
			}
		}
		System.out.println(ans);
	}

}
