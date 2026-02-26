
import java.io.*;
import java.util.*;
public class Main {
	static int N,M, arr[][];
	static StringBuilder sb;
	static final int INF =1_000_000_000;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		arr = new int[N+1][N+1];
		
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=N; j++) {
				if(i==j) continue;
				arr[i][j] = INF; 
			}
		}
		
		for(int i=0; i<M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			arr[a][b] = 1;
		}
		sb = new StringBuilder();
		floyd(arr, N);
		System.out.println(sb);
	}
	
	static void floyd(int g[][], int n) {
		for(int k=1; k<=n; k++) {
			for(int i=1; i<=n; i++) {
				for(int j=1; j<=n; j++) {
					if(g[i][k] != INF && g[k][j] != INF) {
						g[i][j] = Math.min(g[i][j], g[i][k] + g[k][j]);
					}
				}
			}
		}
//		for(int i=1; i<=n; i++) {
//			int tmp = 0;
//			for(int j=1; j<=n; j++) {
//				if(i==j) continue;
//				if(g[i][j] != INF || g[j][i] != INF) tmp++;
//			}
//			sb.append(n-(tmp+1)).append("\n");
//			(나보다 가볍 + 나보다 무겁 + 나자신) 으로 빼준다
//		}
		
		for(int i=1; i<=n; i++) {
			int tmp = 0;
			for(int j=1; j<=n; j++) {
				if(i==j) continue;
				if(g[i][j] == INF && g[j][i] == INF) tmp++;
			}
			sb.append(tmp).append("\n");
		}
	}
}
