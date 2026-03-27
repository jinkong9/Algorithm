import java.io.*;
import java.util.*;
public class Main {
	static char arr[][];
	static int ans;
	static boolean v[][], v1[];
	static int dr[] = {-1,1,0,0};
	static int dc[] = {0,0,-1,1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		arr = new char[5][5];
		for(int i=0; i<5; i++) {
			String s = br.readLine();
			for(int j=0; j<5; j++) {
				arr[i][j] = s.charAt(j);
			}
		}
		ans = 0;
		v1 = new boolean[25];
		comb(0,0,0);
		System.out.println(ans);
	}

	static void comb(int idx, int start, int ycnt) {
		if(ycnt >=4) {
			return;
		}
		
		if(idx == 7) {
		    v = new boolean[5][5];

		    for(int i=0; i<25; i++) {
		        if(v1[i]) {
		            int r = i/5;
		            int c = i%5;
		            if(dfs(r,c) == 7) ans++;
		            break;
		        }
		    }
		    return;
		}
		
		for(int i=start; i<25; i++) {
			v1[i] = true;
			if(arr[i/5][i%5] == 'Y') {
				comb(idx+1, i+1, ycnt+1);
			} else {
				comb(idx+1, i+1, ycnt);
			}
			v1[i] = false;
		}
	}
	
	static int dfs(int r, int c) {
	    int cnt = 1;
	    v[r][c] = true;

	    for(int i=0; i<4; i++) {
	        int nr = r + dr[i];
	        int nc = c + dc[i];

	        if(nr <0 || nr >=5 || nc <0 || nc >=5) continue;
	        if(v[nr][nc]) continue;
	        if(!v1[nr*5 + nc]) continue;

	        cnt += dfs(nr,nc);
	    }

	    return cnt;
	}
}
