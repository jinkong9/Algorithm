import java.io.*;
import java.util.*;
public class Main {
	static String S,T;
	static StringBuilder sb;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		S = br.readLine();
		T = br.readLine();
		sb = new StringBuilder(T);
		
		if(S.length() == T.length()) {
			if(S.equals(T)) {
				System.out.println(1);
				return;
			} else {
				System.out.println(0);
				return;
			}
		}
		dfs();
		if(S.equals(sb.toString())) System.out.println(1);
		else System.out.println(0);
	}

	static void dfs() {
		while(sb.length() > S.length()) {
			char last = sb.charAt(sb.length()-1);
			sb.deleteCharAt(sb.length()-1);
			if(last == 'B') {
				sb.reverse();
			}
		}
	}
}
