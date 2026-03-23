import java.io.*;
import java.util.*;
public class Main {
	static int N,X, ans;
	static long max,min;
	static long L,R, arr[];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N  =Integer.parseInt(st.nextToken());
		L  =Integer.parseInt(st.nextToken());
		R  =Integer.parseInt(st.nextToken());
		X  =Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		arr = new long[N];
		for(int i=0; i<N; i++) {
			arr[i] = Long.parseLong(st.nextToken());
		}
		max = 0;
		min = Long.MAX_VALUE;
		dfs(0,0,0,min,max);
		System.out.println(ans);
	}

	static void dfs(int idx, int cnt, long sum, long min, long max) {
		if(sum > R) return;
		
		if(idx == N) {
			if(cnt >=2 && sum >= L && sum <= R && max - min >= X) {
				ans ++;
			}
			return;
		}
		
		// 선택
		dfs(idx+1, cnt +1, sum + arr[idx], Math.min(min, arr[idx]), Math.max(max, arr[idx]));
		// 미선택
		dfs(idx+1,cnt,sum,min,max);
	}
}
