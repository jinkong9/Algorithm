
import java.io.*;
import java.util.*;
public class Solution {
	static char arr[][];
	static int dr[] = {-1,1,0,0};
	static int dc[] = {0,0,-1,1};
	static boolean[] v;
	static int R,C;
	static int cnt;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for(int tc =1; tc<=T; tc++) {
			StringTokenizer st1 = new StringTokenizer(br.readLine());
			R = Integer.parseInt(st1.nextToken());
			C = Integer.parseInt(st1.nextToken());
			arr = new char[R][C];
			for(int i=0; i<R; i++) {
				String s = br.readLine();
				for(int j=0; j<C; j++) {
					arr[i][j] = s.charAt(j);
				}
			}
			v = new boolean[26];
			v[arr[0][0] - 'A'] = true;
			cnt = 0;
			dfs(0,0, 1);
			sb.append("#").append(tc).append(' ').append(cnt).append('\n');
		}
		System.out.println(sb);
	}
	
	static void dfs(int r, int c, int d) {
		cnt = Math.max(cnt, d);
		for(int i=0; i<4; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];
			
			if(nr < 0 || nr >= R || nc <0 || nc >= C) {
				continue;
			}
			if(v[arr[nr][nc] - 'A']) {
				continue;
			}
			
			v[arr[nr][nc] - 'A'] = true;
			dfs(nr, nc, d+1);
			v[arr[nr][nc] - 'A'] = false;
		}
	}
}
