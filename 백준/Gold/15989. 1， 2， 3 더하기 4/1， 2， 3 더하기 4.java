import java.io.*;
import java.util.*;
public class Main {
	static int T;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		T = Integer.parseInt(br.readLine());
		
		for(int i=0; i<T; i++) {
			int N = Integer.parseInt(br.readLine());
			int dp[] = new int[N+1];
			
			dp[0] = 1;
			for(int num =1; num <=3; num ++) {
				for(int x = num; x<=N; x++) {
					dp[x] += dp[x - num];
				}
			}
			sb.append(dp[N]).append("\n");
		}
		System.out.println(sb);
	}

}
