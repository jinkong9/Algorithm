import java.io.*;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int arr[] = new int[N+1];
		
		for(int i=1; i<=N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		int dp[] = new int[N+1];
		
		for(int i=1; i<= N; i++) {
			dp[i] = 1;
			for(int j=1; j<i; j++) {
				if(arr[i] > arr[j]) {
					dp[i] = Math.max(dp[i], dp[j] +1);
				}
			}
		}
		int max = 0;
		for(int i=1; i<=N; i++) {
			max =Math.max(dp[i], max);
		}
		System.out.println(N-max);
	}

}
