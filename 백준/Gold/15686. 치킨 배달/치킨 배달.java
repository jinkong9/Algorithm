
import java.io.*;
import java.util.*;
public class Main {
	static int N,M,arr[][];
	static boolean v[];
	static class Point {
		int r,c;
		Point(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
	static ArrayList<Point> list;
	static ArrayList<Point> h;
	static ArrayList<Point> tmp;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N][N];
		list = new ArrayList<>();
		tmp = new ArrayList<>();
		h = new ArrayList<>();
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if(arr[i][j] ==2) list.add(new Point(i,j));
				if(arr[i][j] ==1) h.add(new Point(i,j));
			}
		}
		v = new boolean[list.size()];
		// 0 빈칸 1 집 2 치킨집
		int map[][] = new int[N][N];
		for(int i=0; i<N; i++) map[i] = arr[i].clone();
		perm(0,0, map);
		System.out.println(ans);
	}
	
	static void perm(int idx, int start, int map[][]) {

	    if(idx == M) {
	        for(Point p : tmp) {
	            map[p.r][p.c] = 2;
	        }
	        check(map);
	        return;
	    }

	    for(int i=start; i<list.size(); i++) {
	        tmp.add(list.get(i));
	        perm(idx + 1, i + 1, map);
	        tmp.remove(tmp.size() -1);
	    }

	}
	
	static int ans = Integer.MAX_VALUE;

	static void check(int map[][]) {

	    int sum = 0;

	    for(Point h : h) {

	        int min = Integer.MAX_VALUE;

	        for(Point c : tmp) {

	            int dist = Math.abs(h.r - c.r) + Math.abs(h.c - c.c);
	            min = Math.min(min, dist);

	        }

	        sum += min;
	    }

	    ans = Math.min(ans, sum);
	}
}
