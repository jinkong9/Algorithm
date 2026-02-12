

import java.io.*;
import java.util.*;

public class Main {
	static int arr[][], N, M;
	static int dr[] = { -1, 1, 0, 0 };
	static int dc[] = { 0, 0, 1, -1 };
	static boolean v[][];
	static class Point {
		int r,c;
		Point(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
	static class Ver{
		int to, b;
		Ver(int to, int b) {
			this.to = to;
			this.b = b;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr= new int[N][M];
		
		for(int i=0; i<N; i++) {
			StringTokenizer st1 = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				arr[i][j] = Integer.parseInt(st1.nextToken());
			}
		}
		// 1. bfs로 섬 구분 1 -> 2 -> 3 이런 순으로 라벨링
		// 2. 섬 과 섬 사이 간선 (다리) 찾기
		// 3. 섬을 정점으로 하는 그래프 생성
		v = new boolean[N][M];
		int label = 1;
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(arr[i][j] == 1 && !v[i][j]) {
					bfs(i,j, label);
					label++;
				}
			}
		} // 라벨링 끝
		ArrayList<Ver> list[] = new ArrayList[label];
		for(int i=1; i<label; i++) {
			list[i] = new ArrayList<>();
		}
		// 섬과 섬 사이 간선 찾기
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(arr[i][j] == 0) continue;
				int dest = arr[i][j];
				
				for(int k=0; k<4; k++) {
					int nr = i;
					int nc = j;
					int len = 0;
					
					while(true) {
						nr += dr[k];
						nc += dc[k];
						
						if(nr <0 || nr >= N || nc <0 || nc >= M) break;
						if(arr[nr][nc] == dest) break;
						if(arr[nr][nc] == 0) {
							len ++;
							continue;
						}
						
						if(len >=2) {
							int to = arr[nr][nc];
							list[dest].add(new Ver(to, len));
						}
						break;
					}
				}
			}
		}
		
		int [] bridge = new int[label];
		Arrays.fill(bridge, Integer.MAX_VALUE);
		boolean v[] = new boolean[label];
		bridge[1] = 0;
		for(int s = 0; s <label-1; s++) {
			int minidx = -1;
			int minD = Integer.MAX_VALUE;
			for(int i=1; i<bridge.length; i++) {
				if(!v[i] && bridge[i] < minD) {
					minidx = i;
					minD = bridge[i];
				}
			}
			if(minidx == -1) {
				break;
			}
			v[minidx] = true;
			for(Ver ver : list[minidx]) {
				if(!v[ver.to] && ver.b < bridge[ver.to]) {
					bridge[ver.to] = ver.b;
				}
			}
		}
		int sum = 0;
		for(int i=1; i<bridge.length; i++) {
			if(bridge[i] == Integer.MAX_VALUE) {
				System.out.println(-1);
				return;
			} else {
				sum += bridge[i];
			}
		}
		System.out.println(sum);
	}
	
	static void bfs(int r, int c, int label) {
		Queue<Point> Q = new ArrayDeque<>();
		Q.offer(new Point(r,c));
		v[r][c] =true;
		arr[r][c] = label;
		while(!Q.isEmpty()) {
			Point p = Q.poll();
			
			for(int i=0; i<4; i++) {
				int nr = p.r + dr[i];
				int nc = p.c + dc[i];
				
				if(nr < 0 || nr >=N || nc <0 || nc >=M) continue;
				if(v[nr][nc]) continue;
				if(arr[nr][nc] != 1) continue;
				v[nr][nc] = true;
				arr[nr][nc] = label;
				Q.offer(new Point(nr,nc));
			}
		}
	}
}
