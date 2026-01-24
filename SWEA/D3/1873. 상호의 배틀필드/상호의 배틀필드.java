
import java.io.*;
import java.util.*;
public class Solution {
	static String state;
	static int dr[] = {-1,1,0,0};
	static int dc[] = {0,0,-1,1};
	static char direction[] = {'^', 'v', '<', '>'};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int H = Integer.parseInt(st.nextToken());
			int W = Integer.parseInt(st.nextToken());
			char arr[][] = new char[H][W];
			for(int i=0; i<H; i++) {
				String map = br.readLine();
				for(int j=0; j<W; j++) {
					arr[i][j] = map.charAt(j);
				}
			}
			int N = Integer.parseInt(br.readLine());
			state = br.readLine();
			
			int r = 0;
			int c =0;
			int d =0;
			
			for(int i=0; i<H; i++) {
				for(int j=0; j<W; j++) {
					if(arr[i][j] == '^') {r=i; c =j; d=0;}
					if(arr[i][j] == 'v') {r=i; c =j; d=1;}
					if(arr[i][j] == '<') {r=i; c =j; d=2;}
					if(arr[i][j] == '>') {r=i; c =j; d=3;}
				}
			}
			
			for(int k=0; k<N; k++) {
				char cmd = state.charAt(k);
				if(cmd == 'S') {
					int Sr = r + dr[d];
					int Sc = c + dc[d];
					while(Sr>=0 && Sr<H && Sc>=0 && Sc <W) {
					if(arr[Sr][Sc] == '*') {
						arr[Sr][Sc] = '.';
						break;
					} 
					if(arr[Sr][Sc] == '#') break;
						Sr = Sr + dr[d];
						Sc = Sc + dc[d];
					}
				} else {
				
					if(cmd == '-') {
						break;
					}
					if(cmd == 'U') {
						d = 0;
					}
					if(cmd == 'D') {
						d = 1;
					}
					if(cmd == 'L') {
						d = 2;
					}
					if(cmd == 'R') {
						d = 3;
					}
					int nr = r + dr[d];
					int nc = c + dc[d];
					
				if(nr >=0 && nr <H && nc >=0 && nc<W && arr[nr][nc] == '.' ) {
					arr[r][c] = '.';
					r = nr;
					c = nc;
				}
				arr[r][c] = direction[d];
			}
			}

			System.out.print("#" + tc+ " ");
			for(int i=0; i<H; i++) {
				for(int j=0; j<W; j++) {
					System.out.print(arr[i][j]);
				}
				System.out.print('\n');
			}
		}
	}
}
