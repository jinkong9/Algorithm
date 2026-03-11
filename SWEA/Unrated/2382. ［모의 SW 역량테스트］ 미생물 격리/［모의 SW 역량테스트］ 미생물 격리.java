

import java.io.*;
import java.util.*;

public class Solution {
	static int arr[][];
	static int dr[] = {-1,1,0,0};
	static int dc[] = {0,0,-1,1};
	static int N,M,K;
	static ArrayList<Point> list;

	static class Point {
	    int r,c,bug,d,time;
	    Point(int r, int c, int bug, int d, int time) {
	        this.r = r;
	        this.c = c;
	        this.bug = bug;
	        this.d = d;
	        this.time = time;
	    }
	}

	static Queue<Point> Q;

	public static void main(String[] args) throws IOException {

	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    int T = Integer.parseInt(br.readLine());

	    for(int tc=1; tc<=T; tc++) {

	        StringTokenizer st = new StringTokenizer(br.readLine());

	        N = Integer.parseInt(st.nextToken());
	        M = Integer.parseInt(st.nextToken());
	        K = Integer.parseInt(st.nextToken());

	        arr = new int[N][N];
	        Q = new ArrayDeque<>();

	        for(int i=0;i<K;i++) {
	            st = new StringTokenizer(br.readLine());

	            int a = Integer.parseInt(st.nextToken());
	            int b = Integer.parseInt(st.nextToken());
	            int c = Integer.parseInt(st.nextToken());
	            int d = Integer.parseInt(st.nextToken())-1;

	            Q.offer(new Point(a,b,c,d,0));
	        }

	        bfs(M);
	        int ans = 0;

	        while(!Q.isEmpty()) {
	            ans += Q.poll().bug;
	        }

	        System.out.println("#"+tc+" "+ans);
	    }
	}

	static void bfs(int t) {
		for(int time=0; time<M; time++) {

		    int size = Q.size();

		    Map<String, ArrayList<Point>> map = new HashMap<>();

		    for(int i=0;i<size;i++) {

		        Point p = Q.poll();

		        int nr = p.r + dr[p.d];
		        int nc = p.c + dc[p.d];

		        int bug = p.bug;
		        int dir = p.d;

		        if(nr==0 || nc==0 || nr==N-1 || nc==N-1) {
		            bug /= 2;

		            if(dir==0) dir=1;
		            else if(dir==1) dir=0;
		            else if(dir==2) dir=3;
		            else dir=2;
		        }

		        if(bug==0) continue;

		        String key = nr+" "+nc;

		        if(!map.containsKey(key)) {
		            map.put(key, new ArrayList<>());
		        }

		        map.get(key).add(new Point(nr,nc,bug,dir,0));
		    }

		    for(ArrayList<Point> list : map.values()) {

		        if(list.size()==1) {
		            Q.offer(list.get(0));
		            continue;
		        }

		        int sum = 0;
		        int max = 0;
		        int dir = 0;
		        int r= 0;
		        int c= 0;

		        // point별로 비교해서 max값바꿔서 Q에 넣어주기
		        for(Point p : list) {
		        	sum += p.bug;
		        	if(p.bug > max) {
		        		max = p.bug;
		        		r = p.r;
		        		c = p.c;
		        		dir = p.d;
		        	}
		        }
		        Q.offer(new Point(r,c,sum,dir,0));
		    }
		}
	}
}
