
import java.io.*;
import java.util.*;
public class Solution {
	static int cnt;
	static int dr[] = {-1,1,0,0};
	static int dc[] = {0,0,-1,1};
	static String arr[][];
	static HashSet<String> list;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int tc =1; tc<=T; tc++) {
			arr = new String[4][4];
			
			for(int i=0; i<4; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j=0; j<4; j++) {
					arr[i][j] = st.nextToken();
				}
			}
			cnt = 0;
			list = new HashSet<>();
			for(int i=0; i<4; i++) {
				for(int j=0; j<4; j++) {
					dfs(0,i,j, ""+arr[i][j]);
				}
			}
			cnt = list.size();
			System.out.println("#" + tc + " " +cnt);
		}
	}

	static void dfs(int idx, int r, int c, String s) {
		if(idx == 6) {
			list.add(s);
			return;
		}
		
		for(int i=0; i<4; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];
			
			if(nr <0 || nr >=4 || nc <0 || nc >=4) continue;
			dfs(idx +1, nr,nc,s+arr[nr][nc]);
		}
	}
}
