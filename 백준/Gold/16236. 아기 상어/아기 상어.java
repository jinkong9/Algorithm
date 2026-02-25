
import java.io.*;
import java.util.*;

public class Main {
	static int N, arr[][], sr, sc, size, cnt, time;
	static int[] dr = {-1, 0, 0, 1};
	static int[] dc = {0, -1, 1, 0};
	static class Point {
		int r, c, dist;
		Point(int r, int c, int dist) {
			this.r = r;
			this.c = c;
			this.dist = dist;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		arr = new int[N][N];
		
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if(arr[i][j] == 9) {
					sr = i;
					sc = j;
					arr[sr][sc] = 0;
				}
			}
		}
		size = 2;
		cnt = 0;
		time = 0;
		
		while(true) {
			Point tar = bfs();
			if(tar == null) break;
			
			sr = tar.r;
			sc = tar.c;
			time += tar.dist;
			
			cnt ++;
			arr[sr][sc] = 0;
			
			if(size == cnt) {
				size +=1;
				cnt = 0;
			}
		}
		System.out.println(time);
	}
	
	static Point bfs() {
		Queue <Point> Q = new ArrayDeque<>();
		boolean v[][] = new boolean[N][N];
		ArrayList<Point> list = new ArrayList<>();
		
		v[sr][sc] = true;
		Q.offer(new Point(sr,sc,0));
		
		int min = Integer.MAX_VALUE;
		while(!Q.isEmpty()) {
			Point p = Q.poll();
			int pr = p.r;
			int pc = p.c;
			int pd = p.dist;
			
			for(int i=0; i<4; i++) {
				int nr = pr + dr[i];
				int nc = pc + dc[i];
				int nd = pd + 1;
				
				if(nd > min) continue;
				if(nr <0 || nr >= N || nc < 0 || nc >= N) continue;
				if(v[nr][nc]) continue;
				if(arr[nr][nc] > size) continue;
				
				v[nr][nc] = true;
				Q.offer(new Point(nr,nc,nd));
				
				if(arr[nr][nc] > 0 && arr[nr][nc] < size) {
					list.add(new Point(nr,nc,nd));
					min = nd;
				}
			}
		}
		if(list.isEmpty()) return null;
		
		list.sort((a,b) -> {
			if(a.dist != b.dist) return a.dist - b.dist;
			if(a.r != b.r) return a.r - b.r;
			return a.c - b.c;
		});
		
		return list.get(0);
	}
	
}
