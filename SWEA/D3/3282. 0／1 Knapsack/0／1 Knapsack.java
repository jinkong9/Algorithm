import java.io.*;
import java.util.*;

public class Solution {
	static int N, K, ans, v[], c[];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			v = new int[N + 1];
			c = new int[N + 1];

			for (int i = 1; i <= N; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				v[i] = a;
				c[i] = b;
			}
			ans = 0;
			// 조합
//			comb(1, 0, 0);
//			System.out.println(ans);

			// dp
			int dp[][] = new int[N + 1][K + 1];

			for (int i = 1; i <= N; i++) {
				for (int j = 0; j <= K; j++) {
					dp[i][j] = dp[i - 1][j];

					if (j >= v[i]) {
						dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - v[i]] + c[i]);
					}
				}
			}
			sb.append("#").append(tc).append(" ").append(dp[N][K]).append("\n");
		}
		System.out.println(sb);
	}

	static void comb(int idx, int w, int val) {
		if (idx == N + 1) {
			if(w > K) return;
			ans = Math.max(ans, val);
			return;
		}

		comb(idx + 1, w, val);
		comb(idx + 1, w + v[idx], val + c[idx]);
	}

}
