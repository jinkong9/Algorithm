import java.io.*;
import java.util.*;
public class Main {
	static int N,S;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		
		int arr[] = new int[N+1];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int idx1 = 0;
		int idx2 = 0;
		long sum = arr[0];
		
		int min = Integer.MAX_VALUE;
		
		while(idx2 < N) {
			if(sum >= S) {
				min = Math.min(idx2-idx1+1, min);
				sum -= arr[idx1];
				idx1 ++;
			} else {
				idx2 ++;
				sum += arr[idx2];
			}
		}
		if(min == Integer.MAX_VALUE) System.out.println(0);
		else System.out.println(min);
	}
}
