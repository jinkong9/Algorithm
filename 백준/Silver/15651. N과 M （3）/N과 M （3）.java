

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
		for(int i=0; i<A; i++) {
			arr[i] = i+1;
		}
		
		dfs(0, new int[B]);
		System.out.println(sb);
	}
	
	static void dfs(int idx, int sel[]) {
		if(idx == B) {
			for(int i=0; i<B; i++) {
				sb.append(sel[i]).append(" ");
			}
			sb.append("\n");
			return;
		}
		for(int i=0; i<arr.length; i++) {
			sel[idx] = arr[i];
			dfs(idx+1, sel);
		}
	}
	
}
