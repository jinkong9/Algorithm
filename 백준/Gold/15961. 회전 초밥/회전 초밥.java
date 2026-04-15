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
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		int idx1 = 0;
		int idx2 = 0;
		int ans = 0;
		int cnt[] = new int[d+1];
		
		int tt = 0;
		while(tt < k) {
			if(cnt[arr[idx2]] == 0) ans ++;
			cnt[arr[idx2]] ++;
			idx2 = (idx2 + 1) % N;
			tt ++;
		}
		int max = 0;
		int ttt = 0;
		while(ttt < N) {
			int tmp = ans;
			if(cnt[c] == 0) tmp ++;
			max = Math.max(max, tmp);
			
			cnt[arr[idx1]] --;
			if(cnt[arr[idx1]] == 0) ans --;
			idx1 = (idx1 +1) % N;
			
			if(cnt[arr[idx2]] == 0) ans ++;
			cnt[arr[idx2]] ++;
			idx2 = (idx2 + 1) % N;
			
			ttt ++;
		}
		System.out.println(max);
	}

}
