
import java.io.*;
import java.util.*;
public class Main {
	static int arr[][];
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		arr = new int[9][9];
		for(int i=0; i<9; i++) {
			String s = br.readLine();
			for(int j=0; j<9; j++) {
				arr[i][j] = s.charAt(j) - '0';
			}
		}
		dfs(0,0);
	}
	
	static void dfs(int row, int col) {
		if(col == 9) {
			dfs(row+1, 0);
			return;
		}
		
		if(row == 9) {
			for(int i=0; i<9; i++) {
				for(int j=0; j<9; j++) {
					sb.append(arr[i][j]);
				}
				sb.append('\n');
			}
			System.out.println(sb);
			System.exit(0);
		}
		
		if(arr[row][col] == 0) {
			for(int i=1; i<=9; i++) {
				if(check(row,col,i)) {
					arr[row][col] = i;
					dfs(row, col+1);
				}
			}
			arr[row][col] = 0;
			return;
		}
		dfs(row, col+1);
	}
	
	static boolean check(int row, int col, int val) {
		for(int i=0; i<9; i++) {
			if(arr[row][i] == val) return false; 
		}
		
		for(int i=0; i<9; i++) {
			if(arr[i][col] == val) return false; 
		}
		
		int a = (row /3) * 3;
		int b = (col /3) * 3;
		
		for(int i=a; i<a+3; i++) {
			for(int j=b; j<b+3; j++) {
				if(arr[i][j] == val) return false; 
			}
		}
		
		return true;
	}
}
