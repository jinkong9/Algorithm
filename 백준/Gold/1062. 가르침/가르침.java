import java.io.*;
import java.util.*;

public class Main {
	static int N, K, cnt;
	static String arr[];
	static ArrayList<Character> list;
	static boolean v[];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		if (K < 5) {
			System.out.println(0);
			return;
		}
		int tK = N - 5;
		cnt = 0;
		list = new ArrayList<>();
		v = new boolean[26];

		v['a' - 97] = v['n' - 97] = v['t' - 97] = v['i' - 97] = v['c' - 97] = true;
		arr = new String[N];
		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			arr[i] = s.substring(4, s.length() - 4);
		}
		dfs(0,0);
		System.out.println(cnt);
	}

	static void dfs(int idx, int start) {
		if(idx == K-5) {
			play();
			return;
		}
		
		for(int i=start; i<26; i++) {
			if(!v[i]) {
				v[i] = true;
				dfs(idx+1, i+1);
				v[i] = false;
			}
		}
	}
	
	static void play() {
		int tmp = 0;
		for(int i=0; i<N; i++) {
			boolean f = false;
			String s = arr[i];
			for(int j=0; j<s.length(); j++) {
				char a = s.charAt(j);
				if(!v[a -97]) {
					f = true;
					break;
				}
			}
			if(!f) {
				tmp += 1;
			}
		}
		cnt = Math.max(cnt, tmp);
	}
}
