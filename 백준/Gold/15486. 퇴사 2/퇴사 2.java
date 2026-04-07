import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int day[] = new int[N + 1];
		int cost[] = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			day[i] = a;
			cost[i] = b;
		}

		int dp[] = new int[N + 2];
		for (int i = 1; i <= N; i++) {
			dp[i] = Math.max(dp[i], dp[i-1]);
			
			if(i + day[i] <= N+1) {
				dp[i + day[i]] = Math.max(dp[i+day[i]], dp[i] + cost[i]);
			}
		}
		System.out.println(Math.max(dp[N], dp[N+1]));
	}

}
