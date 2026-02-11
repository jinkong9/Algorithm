
import java.io.*;
import java.util.*;
public class Solution {
	static int N, B, arr[];
	static int min;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			StringBuilder sb = new StringBuilder();
			N = Integer.parseInt(st.nextToken());
			B = Integer.parseInt(st.nextToken());
			
			arr = new int[N];
			StringTokenizer st1 = new StringTokenizer(br.readLine());
			for(int i=0; i<N; i++) {
				arr[i] = Integer.parseInt(st1.nextToken());
			}
			boolean v[];
			int ans = Integer.MAX_VALUE;
			for(int i=0; i<N; i++) {
				min = Integer.MAX_VALUE;
				v = new boolean[N];
				comb(0,0, new int[i+1], v);
				int a  = min;
				ans = Math.min(ans, a);
			}
			sb.append("#").append(tc).append(" ").append(ans-B).append("\n");
			System.out.print(sb);
		}
	}
	
	static void comb(int idx, int k, int sel[], boolean v[]) {
		if(idx == sel.length) {
			int a = 0;
			for(int i=0; i<sel.length; i++) {
				a += sel[i];
			}
			if(a >= B) {
				min = Math.min(min, a);
			} 
			return;
		}
		
		for(int i=k; i<N; i++) {
			if(!v[i]) {
				v[i] = true;
				sel[idx] = arr[i];
				comb(idx+1, i+1, sel, v);
				v[i] = false;
			}
		}
	}
}
