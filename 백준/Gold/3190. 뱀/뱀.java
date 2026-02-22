
import java.io.*;
import java.util.*;
public class Main {
	static int N, arr[][];
	static boolean v[][];
	static int[] dr = {0, 1, 0, -1};
	static int[] dc = {1, 0, -1, 0};
	static int len, time,nr,nc;
	static class turn{
		int t;
		char d;
		turn(int t, char d) {
			this.t = t;
			this.d = d;
		}
	}
	static Queue<turn> Q;
	static Deque<int []> snake;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr= new int[N][N];
		v = new boolean[N][N];
		Q = new ArrayDeque<>();
		snake = new ArrayDeque<>();
		int A = Integer.parseInt(br.readLine());
		for(int i=0; i<A; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken())-1;
			int b = Integer.parseInt(st.nextToken())-1;
			arr[a][b] = 1;
		}
		Q = new ArrayDeque<>();
		A = Integer.parseInt(br.readLine());
		len =1;
		time = 0;
		for(int i=0; i<A; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			char b = st.nextToken().charAt(0);
			Q.offer(new turn(a,b));
		}
		v[0][0] = true;
		int r= 0;
		int c=0;
		int dir = 0;
		
		snake.addFirst(new int[] {0,0});
		v[0][0] = true;
		
		while(true) {
			int nr = r + dr[dir];
			int nc = c + dc[dir];
			time ++;
			
			if(nr <0 || nr >= N || nc <0 || nc >=N) {
				System.out.println(time);
				return;
			}
			if(v[nr][nc]) {
				System.out.println(time);
				return;
			}
			
			snake.addFirst(new int[] {nr,nc});
			v[nr][nc] = true;
			
			if(arr[nr][nc] == 1) {
				arr[nr][nc] = 0; 
			} else {
				int tail[] = snake.pollLast();
				v[tail[0]][tail[1]] = false;
			}
			
			r = nr;
			c = nc;
			
			if(!Q.isEmpty() && Q.peek().t == time) {
				turn T = Q.poll();
				if(T.d == 'L') {
					dir = (dir +3) % 4;
				} else {
					dir = (dir +1) % 4;
				}
			}
			
		}
	}
	
}
