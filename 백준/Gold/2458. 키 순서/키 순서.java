
import java.io.*;
import java.util.*;
public class Main {
	static int N,M, arr[][];
	static StringBuilder sb;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N+1][N+1];
		
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=N; j++) {
				if(i==j) continue;
				arr[i][j] = 10_1000_1000; 
			}
		}
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			arr[a][b] = 1;
		}
		sb = new StringBuilder();
		floyd(arr, N);
		System.out.println(sb);
	}
	
	static void floyd(int g[][], int n) {
		int cnt = 0;
		for(int k=1; k<=N; k++) {
			for(int i=1; i<=N; i++) {
				for(int j=1; j<=N; j++) {
					if(g[i][k] != 10_1000_1000 && g[k][j] != 10_1000_1000) {
						g[i][j] = Math.min(g[i][j], g[i][k] + g[k][j]);
					}
				}
			}
		}
		
		for(int i=1; i<=N; i++) {
			int tmp = 0;
			for(int j=1; j<=N; j++) {
				if(i==j) continue;
				if(g[i][j] != 10_1000_1000 || g[j][i] != 10_1000_1000) tmp++;
			}
			if(tmp == N-1) cnt ++;
		}
		sb.append(cnt);
	}
}
