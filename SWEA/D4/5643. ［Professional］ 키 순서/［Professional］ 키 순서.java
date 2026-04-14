import java.io.*;
import java.util.*;
public class Solution {
	static int N,M, arr[][], ans;
	static final int INF = 100_000_000;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int tc=1; tc<=T; tc++) {
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		arr  = new int[N+1][N+1];
		
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=N; j++) {
				if(i==j) continue;
				arr[i][j] = INF;
			}
		}
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			arr[a][b] = 1;
		}
		ans = 0;
		floyd(arr,N);
		System.out.println("#" + tc + " " + ans);
        }
	}

	static void floyd(int g[][], int n) {
		int cnt = 0;
		for(int k=1; k<=N; k++) {
			for(int i=1; i<=N; i++) {
				for(int j=1; j<=N; j++) {
					if(g[i][k] != INF && g[k][j] != INF) {
						g[i][j] = Math.min(g[i][j], g[i][k] + g[k][j]);
					}
				}
			}
		}
		
		for(int i=1; i<=N; i++) {
			int tmp = 0;
			for(int j=1; j<=N; j++) {
				if(i==j) continue;
				if(g[i][j] != INF || g[j][i] != INF) {
					tmp ++;
				}
			}
			if(tmp == n-1) cnt ++;
		}
		ans = cnt;
	}
}
