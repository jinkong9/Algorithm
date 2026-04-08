
import java.io.*;
import java.util.*;
public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		boolean vR[][] = new boolean[N+1][M+1];
		boolean vC[][] = new boolean[N+1][M+1];
		int K = Integer.parseInt(br.readLine());
		for(int i=0; i<K; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			if(a==c) {
				int tc = Math.max(b, d);
				vC[a][tc] = true;
			} else {
				int tr = Math.max(a, c);
				vR[tr][b] = true;
			}
		}
		long dp[][] = new long[N+1][M+1];
		dp[0][0] = 1;
		for(int r = 0; r <= N; r++) {
			for(int c= 0; c<= M; c++) {
				if(r >0 && !vR[r][c]) {
					dp[r][c] += dp[r-1][c];
				}
				if(c > 0 && !vC[r][c]) {
					dp[r][c] += dp[r][c-1];
				}
			}
		}
		
		System.out.println(dp[N][M]);
	}

}
