import java.io.*;
import java.util.*;
public class Main {
	static int N;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int tc=0; tc<T; tc++) {
			N = Integer.parseInt(br.readLine());
			int arr [][] = new int[2][N];
			for(int i=0; i<2; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j=0; j<N; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			int dp[][] = new int[2][N];
			dp[0][0] = arr[0][0];
			dp[1][0] = arr[1][0];
			// 두변을 공유하지 않는 스티커 점수
			if(N > 1) {
				dp[0][1] = arr[1][0] + arr[0][1];
				dp[1][1] = arr[0][0] + arr[1][1];
			}
			
			for(int i = 2; i<N; i++) {
				dp[0][i] = Math.max(dp[1][i-1] , dp[1][i-2])+ arr[0][i];
				dp[1][i] = Math.max(dp[0][i-1] , dp[0][i-2])+ arr[1][i];
			}
			
			System.out.println(Math.max(dp[0][N-1],dp[1][N-1]));
		}
	}
	
}
