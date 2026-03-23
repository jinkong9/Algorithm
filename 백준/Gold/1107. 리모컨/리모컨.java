import java.io.*;
import java.util.*;
public class Main {
	static int M, arr[], ans;
	static String N;
	static boolean v[] = new boolean[10];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = br.readLine();
		M = Integer.parseInt(br.readLine());
		arr = new int[M];
		if(M >0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i=0; i<M; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
				v[arr[i]] = true;
			}
		}
		ans = Integer.MAX_VALUE;
		perm(0,"");
		ans = Math.min(ans, Math.abs(Integer.parseInt(N) - 100));
		System.out.println(ans);
	}

	static void perm(int idx, String s) {
		if(s.length() > 0) check(s);
	    if(s.length() == N.length() + 1) return;
		
		for(int i=0; i<10; i++) {
			if(!v[i]) {
				perm(idx+1, s+i);
			}
		}
	}
	
	static void check(String s) {
		int a = Integer.parseInt(s);
		int b = Integer.parseInt(N);
		ans = Math.min(ans, s.length() + Math.abs(b-a));
	}
}
