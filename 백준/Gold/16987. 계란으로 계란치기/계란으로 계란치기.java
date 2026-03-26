import java.io.*;
import java.util.*;
public class Main {
	static int N, ans, arr[][];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N][2];
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			arr[i][0] = a;
			arr[i][1] = b;
 		}
		ans = 0;
		// 계란 치면 서로 무게 만큼 내구도 깎임
		dfs(0);
		System.out.println(ans);
	}

	static void dfs(int idx) {
		if(idx == N) {
			int cnt = 0;
			for(int i=0; i<N; i++) {
				if(arr[i][0] <= 0) cnt++;
			}
			ans = Math.max(ans, cnt);
			return;
		}
		
		if(arr[idx][0] <= 0) {
			dfs(idx+1);
			return;
		}
		
		boolean f = false;
		
		for(int i=0; i<N; i++) {
			if(i == idx) continue;
			
			if(arr[i][0] >0) {
				f = true;
				arr[i][0] -= arr[idx][1];
				arr[idx][0] -= arr[i][1];
				
				dfs(idx+1);
				
				arr[i][0] += arr[idx][1];
				arr[idx][0] += arr[i][1];
			}
		}
		if(!f) {
			dfs(idx+1);
		}
	}
}
