import java.io.*;
import java.util.*;
public class Main {
	static int N, arr[][], ans;
	static int cnt = 5;
	static int dr[] = {-1,1,0,0};
	static int dc[] = {0,0,-1,1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		ans = 0;
		dfs(0,arr);
		System.out.println(ans);
	}
	// 상 -> r 0 하 -> r N-1 좌 -> c 0 우 -> c N-1
	static void dfs(int idx, int map[][]) {
		if(idx == cnt) {
			check(map);
			return;
		}
		
		for(int i=0; i<4; i++) {
			int copy[][] = new int[N][N];
			for(int d=0; d<N; d++) {
				copy[d] = map[d].clone();
			}
			
			if(i == 0) {
				top(copy);
			} else if(i == 1) {
				down(copy);
			} else if(i == 2) {
				left(copy);
			} else {
				right(copy);
			}
			dfs(idx +1, copy);
		}
	}
	
	static void check(int map [][]) {
		int tmp = 0;
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				tmp = Math.max(tmp, map[i][j]);
			}
		}
		
		ans = Math.max(ans, tmp);
	}
	
	static void top(int map[][]) { // 상
		for (int c = 0; c < N; c++) {
			ArrayList<Integer> list = new ArrayList<>();
			for (int r = 0; r < N; r++) {
				if(map[r][c] !=0) list.add(map[r][c]);
			}
			
			ArrayList <Integer> plus = new ArrayList<>();
			
			for(int i=0; i<list.size(); i++) {
				if(i+1 < list.size() && list.get(i).equals(list.get(i+1))) {
					plus.add(list.get(i) *2);
					i++;
				} else {
					plus.add(list.get(i));
				}
			}
			int idx = 0;
			for(int r = 0; r < N; r ++) { // 아래 채우고 위에 0 처리
				if(idx < plus.size()) {
					map[r][c] = plus.get(idx);
					idx++;
				} else {
					map[r][c] = 0;
				}
			}
		}
	}
	
	static void down(int map[][]) { // 하
		for (int c = 0; c < N; c++) {
			ArrayList<Integer> list = new ArrayList<>();
			for (int r = N-1; r >= 0; r--) {
				if(map[r][c] !=0) list.add(map[r][c]);
			}
			
			ArrayList <Integer> plus = new ArrayList<>();
			
			for(int i=0; i<list.size(); i++) {
				if(i+1 < list.size() && list.get(i).equals(list.get(i+1))) {
					plus.add(list.get(i) *2);
					i++;
				} else {
					plus.add(list.get(i));
				}
			}
			int idx = 0;
			for(int r = N-1; r >= 0; r --) { // 아래 채우고 위에 0 처리
				if(idx < plus.size()) {
					map[r][c] = plus.get(idx);
					idx++;
				} else {
					map[r][c] = 0;
				}
			}
		}
	}
	
	static void left(int map[][]) { // 좌
		for (int r = 0; r < N; r++) {
			ArrayList<Integer> list = new ArrayList<>();
			for (int c = 0; c < N; c++) {
				if(map[r][c] !=0) list.add(map[r][c]);
			}
			
			ArrayList <Integer> plus = new ArrayList<>();
			
			for(int i=0; i<list.size(); i++) {
				if(i+1 < list.size() && list.get(i).equals(list.get(i+1))) {
					plus.add(list.get(i) *2);
					i++;
				} else {
					plus.add(list.get(i));
				}
			}
			int idx = 0;
			for(int c = 0; c < N; c ++) { // 아래 채우고 위에 0 처리
				if(idx < plus.size()) {
					map[r][c] = plus.get(idx);
					idx++;
				} else {
					map[r][c] = 0;
				}
			}
		}
	}
	
	static void right(int map[][]) { // 우
		for (int r = 0; r < N; r++) {
			ArrayList<Integer> list = new ArrayList<>();
			for (int c = N-1; c >= 0; c--) {
				if(map[r][c] !=0) list.add(map[r][c]);
			}
			
			ArrayList <Integer> plus = new ArrayList<>();
			
			for(int i=0; i<list.size(); i++) {
				if(i+1 < list.size() && list.get(i).equals(list.get(i+1))) {
					plus.add(list.get(i) *2);
					i++;
				} else {
					plus.add(list.get(i));
				}
			}
			int idx = 0;
			for(int c = N-1; c >= 0; c --) { // 아래 채우고 위에 0 처리
				if(idx < plus.size()) {
					map[r][c] = plus.get(idx);
					idx++;
				} else {
					map[r][c] = 0;
				}
			}
		}
	}
}
