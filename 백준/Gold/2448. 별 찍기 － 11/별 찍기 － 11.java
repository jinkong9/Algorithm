
import java.io.*;
import java.util.*;
public class Main {
	static int N;
	static char arr[][];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		arr = new char[N][2*N -1];
		for(int i=0; i<N; i++) Arrays.fill(arr[i], ' ');
		
		dfs(0,N-1,N);
		for(int i=0; i<N; i++) {
			for(int j=0; j<2 *N -1; j++) {
				sb.append(arr[i][j]);
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}

	static void dfs(int r, int c, int N) {
		if(N == 3) {
			arr[r][c] = '*';
			arr[r+1][c-1] = arr[r+1][c+1] = '*';
			arr[r+2][c-2] = arr[r+2][c-1] = arr[r+2][c] = arr[r+2][c+1] = arr[r+2][c+2] = '*';
			return;
		} else {
			int tmp = N/2;
			dfs(r, c, tmp);
			dfs(r + tmp , c - tmp , tmp);
			dfs(r + tmp , c + tmp , tmp);
		}
	}
}
