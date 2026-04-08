import java.io.*;
import java.util.*;
public class Main {
	static class Point {
		int l,r;
		Point(int l, int r) {
			this.l = l;
			this.r = r;
		}
	}
	static ArrayList<Point> list;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		list = new ArrayList<>();
		for(int i=1; i<=N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			list.add(new Point(a,b));
		}
		
		Collections.sort(list, (a,b) -> a.l - b.l);
		int max = 0;
		int dp[] = new int[N];
		for(int i=0; i<N; i++) {
			dp[i] = 1;
			for(int j=0; j<N; j++) {
				if(list.get(i).r > list.get(j).r) {
					dp[i] = Math.max(dp[i], dp[j] +1);
				}
			}
		}
		for(int i=0; i<N; i++) {
			max = Math.max(max, dp[i]);
		}
		System.out.println(N -max);
	}

}
