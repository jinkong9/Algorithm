import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static char arr[][];
	static int dr[] = { -1, 1, 0, 0 };
	static int dc[] = { 0, 0, -1, 1 };
	static boolean ok;
	static class Point {
		int r,c;
		Point(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
	static ArrayList<Point> list;
	static ArrayList<Point> tlist;
	static ArrayList<Point> tmp;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new char[N][N];
		list = new ArrayList<>();
		tlist = new ArrayList<>();
		tmp = new ArrayList<>();
		for (int i = 0; i < N; i++) {
		    StringTokenizer st = new StringTokenizer(br.readLine());
		    for (int j = 0; j < N; j++) {
		        arr[i][j] = st.nextToken().charAt(0);
		        if(arr[i][j] == 'X') list.add(new Point(i,j));
		        if(arr[i][j] == 'T') tlist.add(new Point(i,j));
		    }
		}
		ok = false;
		comb(0,0);
		System.out.println("NO");
	}

	static void comb(int idx, int start) {

	    if(idx == 3) {
	    	char map[][] = new char[N][N];
	    	for(int i=0; i<N; i++) map[i] = arr[i].clone();
	        for(Point p : tmp) {
	            map[p.r][p.c] = 'O';
	        }
	        boolean f = false;
	        
	        for(Point p : tlist) {
	        	if(dfs(p.r,p.c,map)) {
	        		f = true;
	        		break;
	        	}
	        }
	        	if(!f) {
		        	System.out.println("YES");
		        	System.exit(0);
		        }
	        
	        return;
	    }

	    for(int i=start; i<list.size(); i++) {
	        tmp.add(list.get(i));
	        comb(idx + 1, i + 1);
	        tmp.remove(tmp.size() -1);
	    }

	}
	
	static boolean dfs(int r, int c, char map[][]) {
		for (int i = 0; i < 4; i++) {
			int nr = r;
			int nc = c;
			
			while(true) {
				nr += dr[i];
				nc += dc[i];
				if (nr < 0 || nr >= N || nc < 0 || nc >= N) {
					break;
				}
				if (map[nr][nc] == 'O')
					break;
				if (map[nr][nc] == 'S') {
					return true;
				}
			}
		}
		return false;
	}
}
