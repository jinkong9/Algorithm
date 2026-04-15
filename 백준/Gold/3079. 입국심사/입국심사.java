import java.io.*;
import java.util.*;
public class Main {
	static int N, M;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		long []arr = new long[N];
		long max = 0;
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			arr[i] = Long.parseLong(st.nextToken());
			max = Math.max(max, arr[i]);
		}
		Arrays.sort(arr);
		
		
		long idx1 = 0;
		long idx2 = max * M;
		long ans = Long.MAX_VALUE;
		
		while(idx1 <= idx2) {
			long mid = (idx1 + idx2) /2;
			long sum = 0;
			
			for(int i=0; i<N; i++) {
				long cnt = mid / arr[i];
				
				if(sum >= M) break;
				sum += cnt;
			}
			
			if(sum >= M) {
				idx2 = mid -1;
				ans = Math.min(ans, mid);
			}
			else idx1 = mid +1;
		}
		System.out.println(ans);
	}

}
