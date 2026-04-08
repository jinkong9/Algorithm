import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int arr[] = new int[N+1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=1; i<=N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int dp[] = new int[N+1];
		int pre[] = new int[N+1];
		for(int i=1; i<= N; i++) {
			dp[i] = 1;
			pre[i] = -1;
			for(int j=1; j<i; j++) {
				if(arr[i] > arr[j] && dp[i] < dp[j] +1) {
					dp[i] = dp[j] +1;
					pre[i] = j;
				}
			}
		}
		int max = 0;
		int idx = 0;
		for(int i=1; i<=N; i++) {
			if(dp[i] > max) {
				max = dp[i];
				idx = i;
			}
		}
		ArrayList<Integer> list = new ArrayList<>();
		while(idx != -1) {
			list.add(arr[idx]);
			idx = pre[idx];
		}
		Collections.reverse(list);
		
		System.out.println(max);
		for(int i : list) {
			System.out.print(i + " ");
		}
		
	}

}
