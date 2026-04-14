import java.io.*;
import java.util.*;
public class Main {
	static int N,M, arr[][];
	static final int INF = 111_111_111;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N][N];
		int map[][] = new int[N][N];
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(i == j) continue;
				arr[i][j] = INF;
			}
		}
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken())-1;
			int b = Integer.parseInt(st.nextToken())-1;
			int c = Integer.parseInt(st.nextToken());
			arr[a][b] = c;
			arr[b][a] = c;
		}
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(i != j && arr[i][j] != INF) {
					map[i][j] = j+1;
				}
			}
		}
		
		for(int k=0; k<N; k++) {
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					if(arr[i][k] != INF && arr[k][j] != INF) {
						if(arr[i][j] > arr[i][k] + arr[k][j]) {
							arr[i][j] = arr[i][k] + arr[k][j];
							map[i][j] = map[i][k];
						} 
					}
				}
			}
		}
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(i == j) System.out.print('-' + " ");
				else System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}

}
