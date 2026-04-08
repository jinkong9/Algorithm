import java.io.*;
import java.util.*;
public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int coin[] = new int[n+1];
		for(int i=1; i<=n; i++) {
			int a = Integer.parseInt(br.readLine());
			coin[i] = a;
		}
		
		int dp[] = new int[k+1];
		Arrays.fill(dp, 121212);
		dp[0] = 0;
		for(int i=1; i<=n; i++) {
			for(int j=coin[i]; j<=k; j++) {
				dp[j] = Math.min(dp[j], dp[j -coin[i]] +1);
			}
		}
		if(dp[k] == 121212) System.out.println(-1);
		else System.out.println(dp[k]);
	}

}
