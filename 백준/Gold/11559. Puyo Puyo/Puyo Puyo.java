
import java.io.*;
import java.util.*;

public class Main {
	static char arr[][];
	static class Point {
		int r,c;
		Point(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
	static int dr[] = {-1,1,0,0};
	static int dc[] = {0,0,-1,1};
	static boolean v[][];
	static int ans;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		arr = new char[12][6];
		v = new boolean[12][6];
		for(int i=0; i<12; i++) {
			String s = br.readLine();
			for(int j=0; j<6; j++) {
				arr[i][j] = s.charAt(j);
			}
		}
		ans = 0;
		while(true) {
			boolean flag = false;
			v = new boolean [12][6];
			
			for(int i=0; i<12; i++) {
				for(int j=0; j<6; j++) {
					if(arr[i][j] != '.' && !v[i][j]) {
						if(bfs(i,j)) flag =true;
					}
				}
			}
			if(!flag) break;
			gravity();
			ans ++;
		}
		System.out.println(ans);
	}
	
	static boolean bfs(int sr, int sc) {
		Queue <Point> Q = new ArrayDeque<>();
		ArrayList<Point> list = new ArrayList<>();
		char tm = arr[sr][sc];
		Q.offer(new Point(sr,sc));
		v[sr][sc] = true;
		list.add(new Point(sr,sc));
		while(!Q.isEmpty()) {
			Point p = Q.poll();
			for(int i=0; i<4; i++) {
				int nr = p.r + dr[i];
				int nc = p.c + dc[i];
				if(nr <0 || nr >= 12 || nc <0 || nc >=6) continue;
				if(v[nr][nc]) continue;
				if(arr[nr][nc] != tm) continue;
				Q.offer(new Point(nr,nc));
				list.add(new Point(nr,nc));
				v[nr][nc] = true;
			}
		}
		if(list.size() >=4) {
			for(Point p : list) {
				arr[p.r][p.c] = '.';
			}
			return true;
		}
		return false;
	}
	
	
	static void gravity() {
        for(int c=0; c<6; c++) {
            int idx = 11;
            for(int r=11; r>=0; r--) {
                if(arr[r][c] != '.') {
                    char tmp = arr[r][c];
                    arr[r][c] = '.';
                    arr[idx][c] = tmp;
                    idx--;
                }
            }
        }
    }
}
