import java.io.*;
import java.util.*;
public class Main {
	static int N,d,k,c;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		
		int arr[] = new int[N];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int cnt[] = new int[d+1];
		int ans = 0;
		
		for(int i=0; i<k; i++) {
			if(cnt[arr[i]] ==0) ans ++;
			cnt[arr[i]] ++;
		}
		
		int idx1 = 0;
		int idx2 = k;
		
		int max = 0;
		
		while(idx1 < N) {
			int tmp = ans;
			if(cnt[c] == 0) tmp ++;
			max = Math.max(max, tmp);
			
			// if(max == k+1) break; 최적화
			
			cnt[arr[idx1]] --;
			if(cnt[arr[idx1]] == 0) ans --;
			idx1 ++;
			
			if(cnt[arr[idx2 % N]] == 0) ans ++;
			cnt[arr[idx2 % N]] ++;
			idx2 ++;
			
		}
		System.out.println(max);
	}

}
