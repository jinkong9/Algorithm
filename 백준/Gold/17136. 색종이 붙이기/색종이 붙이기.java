import java.io.*;
import java.util.*;

public class Main {
	static int arr[][], ca[], ans;
	static ArrayList<int[]> list;
	static boolean v[][];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		arr = new int[10][10];
		list = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 10; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if (arr[i][j] == 1) {
				}
			}
		}
		ans = Integer.MAX_VALUE;
		ca = new int[6];

		dfs(0,0);
		if(ans == Integer.MAX_VALUE) {
			ans = -1;
		}
		System.out.println(ans);
	}

	static void dfs(int r, int c) {
		int tmp = 0;
		for(int i=1; i<=5; i++) {
			tmp += ca[i];
		}
		if(tmp >= ans) return;
		int nr = -1;
		int nc = -1;
		for(int i=0; i<10; i++) {
			for(int j=0; j<10; j++) {
				if(arr[i][j] == 1) {
					nr =i;
					nc =j;
					break;
				}
			}
			if(nr != -1) break;
		}
		
		if(nr == -1) {
			ans = Math.min(ans, tmp);
			return;
		}
		
		for(int k=1; k<=5; k++) {
			if (nr + k > 10 || nc + k > 10)
				continue;
			if (ca[k] >= 5)
				continue;
			boolean ch = false;
			for(int i=nr; i<nr +k; i++) {
				for(int j=nc; j <nc+k; j++) {
					if(arr[i][j] == 0) {
						ch = true;
						break;
					}
				}
				if(ch) break;
			}
			if(ch) continue;
			
			for(int i=nr; i<nr +k; i++) {
				for(int j=nc; j <nc+k; j++) {
					arr[i][j] = 0;
				}
			}
			ca[k] ++;
			dfs(nr,nc);
			
			for(int i=nr; i<nr +k; i++) {
				for(int j=nc; j <nc+k; j++) {
					arr[i][j] = 1;
				}
			}
			ca[k] --;
		}
		
		
	}

	static boolean check() {
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				if (arr[i][j] == 1) {
					return false;
				}
			}
		}
		return true;
	}
}
