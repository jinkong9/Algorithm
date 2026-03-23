
import java.io.*;
import java.util.*;

public class Main {
	static int N, arr[][];
	static long ans,r, c;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		r = Long.parseLong(st.nextToken());
		c = Long.parseLong(st.nextToken());
		long a = (long) Math.pow(2, N);
		ans = 0;
		dfs(r,c,a, 0);
		System.out.println(ans);
	}

	static void dfs(long r, long c, long size, long cnt) {
		if(size == 1) {
			ans = cnt;
			return;
		}
		long tmp = size /2;
		long tt = tmp * tmp;
		
		if (r < size / 2 && c < size / 2) { // 1
			dfs(r,c,size/2,cnt);
		} else if (r < size / 2 && c >= size / 2) { // 2
			dfs(r,c-tmp,size/2,cnt + tt *1);
		} else if (r >= size / 2 && c < size / 2) { // 3
			dfs(r-tmp,c,size/2,cnt + tt *2);
		} else if (r >= size / 2 && c >= size / 2) { // 4
			dfs(r-tmp,c-tmp,size/2,cnt + tt *3);
		}
	}
}
