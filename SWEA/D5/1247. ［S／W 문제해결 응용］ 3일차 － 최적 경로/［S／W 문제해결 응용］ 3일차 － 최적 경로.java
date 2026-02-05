
import java.io.*;
import java.util.*;
public class Solution {
	static int Cr[], Cc[];
	static int N, hr,hc,wr,wc,a;
	static int sum;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int tc =1; tc<=T; tc++) {
			sum = Integer.MAX_VALUE;
			N = Integer.parseInt(br.readLine());
			Cr = new int[N];
			Cc = new int[N];
			boolean v[] = new boolean[N];
			StringTokenizer st = new StringTokenizer(br.readLine());
			wr = Integer.parseInt(st.nextToken());
			wc = Integer.parseInt(st.nextToken());
			hr = Integer.parseInt(st.nextToken());
			hc = Integer.parseInt(st.nextToken());
			for(int i=0; i<N; i++) {
				Cr[i] = Integer.parseInt(st.nextToken());
				Cc[i] = Integer.parseInt(st.nextToken());
			}
			rec(0, v, new int[N], new int[N]);
			System.out.println("#" +tc+" " + sum);
		}
	}
	
	static void rec(int idx, boolean v[], int sel1[], int sel2[]) {
		
		if(idx == N) {
			int a = Math.abs(wr-sel1[0]);
			int b = Math.abs(wc-sel2[0]);
			for(int i=1; i<N; i++) {
				a += Math.abs(sel1[i-1] - sel1[i]);
				b += Math.abs(sel2[i-1] - sel2[i]);
			}
			a += Math.abs(sel1[N-1] - hr);
			b += Math.abs(sel2[N-1] - hc);
			sum = Math.min(sum, a+b);
			return;
		}
		
		for(int i=0; i<N; i++) {
			if(!v[i]) {
				v[i] = true;
				sel1[idx] = Cr[i];
				sel2[idx] = Cc[i];
				rec(idx+1, v, sel1, sel2);
				v[i] = false;
			}
		}
	}
}
