
import java.io.*;
import java.util.*;

public class Main {
	static int dr[] = { -1, 0, 1 };
	static int dc[] = { 1, 1, 1 };
	static int R,C,cnt;
	static char arr[][];
	static boolean v[][];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		arr = new char[R][C];
		for(int i =0; i<R; i++) {
			String s= br.readLine();
			for(int j=0; j<C; j++) {
				arr[i][j] = s.charAt(j);
			}
		}
		int a =0;
		v = new boolean[R][C];
		
		for(int i=0; i<R; i++) {
			v[i][0] = true;
			if(dfs(i,0)) a ++;
		}
		System.out.println(a);
	}
	
	static boolean dfs(int r, int c) {
		if(c == C-1) {
			return true;
		}
		
		for(int i=0; i<3; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];
			
			if(nr < 0 || nr >=R || nc <0 || nc >=C) continue;
			if(v[nr][nc]) continue;
			if(arr[nr][nc] != '.') continue;
			v[nr][nc] = true;
			if(dfs(nr,nc)) return true;
		}
		return false;
	}
}
