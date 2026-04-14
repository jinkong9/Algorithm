
import java.io.*;
import java.util.*;
public class Solution {
	static int N, arr[][];
	static final int INF = 100_000_000;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int tc=1; tc<=T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			arr = new int[N][N];
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					if(i == j) continue;
					arr[i][j] = INF;
				}
			}
			
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					int a = Integer.parseInt(st.nextToken());
					if(a ==0) continue;
					else arr[i][j] = a;
				}
			}
			
			for(int k=0; k<N; k++) {
				for(int i=0; i<N; i++) {
					for(int j=0; j<N; j++) {
						if(arr[i][k] != INF && arr[k][j] != INF) {
							arr[i][j] = Math.min(arr[i][j], arr[i][k] + arr[k][j]);
						}
					}
				}
			}
			int min = INF;
			for(int i=0; i<N; i++) {
				int tmp = 0;
				for(int j=0; j<N; j++) {
					if(i == j) continue;
					tmp += arr[i][j];
				}
				min = Math.min(min, tmp);
			}
			sb.append("#").append(tc).append(" ").append(min).append("\n");
		}
		System.out.println(sb);
	}

}
