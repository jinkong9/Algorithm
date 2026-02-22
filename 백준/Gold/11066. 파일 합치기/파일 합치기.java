

import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=T; tc++) {
			int N = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			int arr[] = new int[N+1];
			int sum[] = new int[N+1];
			int dp[][] = new int[N+1][N+1];
			for(int i=1; i<=N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
				sum[i] = sum[i-1] + arr[i];
			}
			
			for(int i=1; i<=N; i++) {
				for(int j=1; j+i <=N; j++) {
					int k = j+i;
					dp[j][k] = Integer.MAX_VALUE;
					for(int x = j; x<k; x++) {
						dp[j][k] = Math.min(dp[j][k], dp[j][x] + dp[x+1][k] + sum[k] - sum[j-1]);
					}
				}
			}
			System.out.println(dp[1][N]);
		}
	}

}
