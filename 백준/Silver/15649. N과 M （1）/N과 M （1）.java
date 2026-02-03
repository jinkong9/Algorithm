

import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws  IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int num = Integer.parseInt(st.nextToken());
		int sel = Integer.parseInt(st.nextToken());
		
		int arr[] = new int[num];
		boolean[] v = new boolean[arr.length];
		for(int i=1; i<=num; i++) {
			arr[i-1] = i; 
		}
		dfs(arr, 0, new int[sel],v);
	}
	
	public static void dfs(int arr[], int idx, int sel[], boolean[] v) {
		if(idx == sel.length) {
			for (int  a : sel) {
				System.out.print(a+" ");
			}
			System.out.println();
			return;
		}
		for(int i=0; i<arr.length; i++) {
			if(!v[i]) {
				v[i] = true;
				sel[idx] = arr[i];
				dfs(arr, idx+1, sel,v);
				v[i] = false;
			}
		}
	}

}
