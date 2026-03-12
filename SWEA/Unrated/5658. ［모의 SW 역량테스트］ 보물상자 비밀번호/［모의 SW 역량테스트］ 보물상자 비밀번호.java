
import java.io.*;
import java.util.*;
public class Solution {
	static int N,K;
	static HashSet<Integer> list;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int tc =1; tc<=T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			String s = br.readLine();
			int ans = 0;
			list = new HashSet<>();
			int idx = N/4;
			
			dfs(idx,s,1);
			List<Integer> tmp = new ArrayList<>(list);
			Collections.sort(tmp);
			for(int i=0; i<tmp.size(); i++) {
				if(i == tmp.size() - K) {
					System.out.println("#" + tc + " " +tmp.get(i));
				}
			}
		}
	}

	static void dfs(int idx, String s, int cnt) {
		if(cnt == N/4) return;
		int len = N / 4;
		for(int r = 0; r < len; r++) {
		    for(int i = 0; i < 4; i++) {
		        String sub = s.substring(i*len, (i+1)*len);
		        int num = Integer.parseInt(sub, 16);
		        list.add(num);
		    }
		    s = s.charAt(N-1) + s.substring(0, N-1); // 회전
		}
		dfs(idx,s, cnt+1);
	}
}
