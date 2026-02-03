
import java.io.*;
import java.util.*;
public class Solution {
	static boolean v[];
	static int N, M;
	static int[] arr;
	static int max;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int tc =1; tc<=T; tc++) {
			StringTokenizer st1 = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st1.nextToken());
			M = Integer.parseInt(st1.nextToken());
			
			StringTokenizer st2 = new StringTokenizer(br.readLine());
			arr = new int[N];
			for(int i=0; i<N; i++) {
				arr[i] = Integer.parseInt(st2.nextToken());
			}
			sb.append("#").append(tc).append(" ");
			v = new boolean[N];
			dfs(0,0,0);
			if(max > 0) {
				sb.append(max);
			} else {
				sb.append(-1);
			}
			sb.append('\n');
			max = 0;
		}
		System.out.println(sb);
	}
	static void dfs(int idx, int k, int sum) { // 원본 선택
		if(sum >M) return;
		
		if(k == 2) {
			max = Math.max(max, sum);
			return;
		}
		
		if(idx == N) return;
		
		dfs(idx+1, k+1, sum + arr[idx]);
		dfs(idx+1, k, sum);
	}
}
