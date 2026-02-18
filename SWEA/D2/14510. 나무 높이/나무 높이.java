
import java.io.*;
import java.util.*;
public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int tc=1; tc<=T; tc++) {
			int N = Integer.parseInt(br.readLine());
			int arr[] = new int[N];
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			int max = 0;
			for(int i=0; i<N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
				if(arr[i] > max) max = arr[i];
			}
			
			int one = 0;
			int two = 0;
			
			for(int i=0; i<N; i++) {
				int diff = max - arr[i];
				one += diff % 2;
				two += diff / 2;
			}
			
			while(two > one +1) {
				two -= 1;
				one += 2;
			}
			
			int res = 0;
			if(two >= one) {
				res = 2 * two;
			} else {
				res = 2 * one -1;
			}
			
			sb.append("#").append(tc).append(" ").append(res).append('\n');
			
		}
		System.out.print(sb);
	}
}
