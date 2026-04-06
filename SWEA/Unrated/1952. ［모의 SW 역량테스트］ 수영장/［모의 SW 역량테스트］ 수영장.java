import java.io.*;
import java.util.*;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			int price[] = new int[4];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 4; i++)
				price[i] = Integer.parseInt(st.nextToken());
			int arr[] = new int[13];
			st = new StringTokenizer(br.readLine());
			for (int i = 1; i <= 12; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}

			int dp[] = new int[13];


			for (int i = 1; i <= 12; i++) {
				if(i >=3) {
					dp[i] = Math.min(dp[i-1] +Math.min(arr[i] * price[0], price[1]), dp[i-3] + price[2]);
				} else {
					dp[i] = dp[i-1] + Math.min(arr[i] * price[0], price[1]);
				}
			}
			
			
			dp[12] = Math.min(dp[12], price[3]);
			
			sb.append("#").append(tc).append(" ").append(dp[12]).append("\n");
		}
		System.out.println(sb);
	}

}
