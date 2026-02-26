
import java.io.*;
import java.util.*;
public class Main {
	static int N,M, a,b,c;
	static int arr[][];
	static StringBuilder sb;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N+1][N+1];
		
		for(int i=0; i<N+1; i++) {
			for(int j=0; j<N+1; j++) {
				if(i==j) continue;
				arr[i][j] = 1000_1000_10;
			}
		}
		
		M = Integer.parseInt(br.readLine());
		for(int i=0; i<M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			arr[a][b] = Math.min(arr[a][b], w);
		}
		sb = new StringBuilder();
		floyd(arr, N);
		System.out.println(sb);
	}
	
	static void floyd(int g[][], int n) {
		for(int k=1; k<=N; k++) {
			for(int i=1; i<=N; i++) {
				for(int j=1; j<=N; j++) {
					g[i][j] = Math.min(g[i][j], g[i][k] + g[k][j]);
				}
			}
		}
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=N; j++) {
				if(g[i][j] == 1000_1000_10) {
					sb.append(0).append(" ");
				} else {
					sb.append(g[i][j]).append(" ");
				}
			}
			sb.append("\n");
		}
	}
}
