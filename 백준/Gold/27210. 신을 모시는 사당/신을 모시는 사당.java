import java.io.*;
import java.util.*;
public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int arr[] = new int[N];
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int dp[] = new int[N];
		
		if(arr[0] == 1) {
			dp[0] = 1;
		} else {
			dp[0] = -1;
		}
		int max = dp[0];
		for(int i=1; i<N; i++) {
			int tmp = arr[i] == 1 ? 1 : -1;
			dp[i] = Math.max(dp[i-1] + tmp, tmp);
			max = Math.max(max, dp[i]);
		}
		
		if(arr[0] == 1) {
			dp[0] = -1;
		} else {
			dp[0] = 1;
		}
		for(int i=1; i<N; i++) {
			int tmp = arr[i] == 1 ? -1 : 1;
			dp[i] = Math.max(dp[i-1] + tmp, tmp);
			max = Math.max(max, dp[i]);
		}
		
		System.out.println(max);
	}

}
