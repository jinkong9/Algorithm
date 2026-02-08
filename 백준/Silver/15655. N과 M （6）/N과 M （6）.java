

import java.io.*;
import java.util.*;

public class Main {
	static int A,B, arr[];
	static boolean v[];
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		arr = new int[A];
		v = new boolean[A];
		StringTokenizer st1 = new StringTokenizer(br.readLine());
		for(int i=0; i<A; i++) {
			arr[i] = Integer.parseInt(st1.nextToken());
		}
		Arrays.sort(arr);
		
		dfs(0, new int[B], 0);
		System.out.println(sb);
	}
	
	static void dfs(int idx, int sel[], int s) {
		if(idx == B) {
			for(int i=0; i<B; i++) {
				sb.append(sel[i]).append(" ");
			}
			sb.append("\n");
			return;
		}
		
		for(int i =s; i<arr.length; i++) {
			if(!v[i]) {
				sel[idx] = arr[i];
				v[i] = true;
				dfs(idx+1, sel,i+1);
				v[i] = false;
			}
		}
	}
	
}
