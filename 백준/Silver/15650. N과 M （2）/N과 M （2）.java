

import java.io.*;
import java.util.*;

public class Main {
	static int arr[], A,B;
	static boolean v[];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		arr = new int[A];
		v = new boolean[A];
		for(int i=0; i<A; i++) {
			arr[i] = i+1;
		}
		dfs(0,new int[B],0);
	}
	
	static void dfs(int idx, int sel[], int start) {
		if(idx == B) {
			for(int i=0; i<sel.length; i++) {
				System.out.print(sel[i] + " ");
			}
			System.out.println();
			return;
		}
		
		for(int i=start; i<arr.length; i++) {
			if(!v[i]) {
				sel[idx] = arr[i];
				dfs(idx+1, sel, i+1);
			}
		}
	}

}
