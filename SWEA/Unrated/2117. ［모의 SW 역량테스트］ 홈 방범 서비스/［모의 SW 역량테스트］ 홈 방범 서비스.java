
import java.io.*;
import java.util.*;

public class Solution {
	static int N, M, arr[][], ans, maxhouse;
	static int dr[] = { -1, 1, 0, 0 };
	static int dc[] = { 0, 0, -1, 1 };

	static class Point {
		int r, c, h;

		Point(int r, int c, int h) {
			this.r = r;
			this.c = c;
			this.h = h;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			arr = new int[N][N];

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			maxhouse = 0;
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					for(int k=1; k<=N+1; k ++) {
						int htmp = 0;
						
						for(int i=0; i<N; i++) {
							for(int j=0; j<N; j++) {
								if(arr[i][j] == 1) {
									int dist = Math.abs(r - i) + Math.abs(c - j);
									if(dist < k) htmp ++;
								}
							}
						}
						int a = k * k + (k-1) * (k-1);
						int b = htmp * M -a;
						if(b >= 0) maxhouse = Math.max(htmp, maxhouse);
					}
				}
			}
			sb.append("#").append(tc).append(" ").append(maxhouse).append("\n");
		}
		System.out.print(sb);
	}

}
