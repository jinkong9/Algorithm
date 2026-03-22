import java.io.*;
import java.util.*;
public class Main {
	static String s;
	static HashSet<String> list;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		s =  br.readLine();
		list = new HashSet<>();
		for (int i = 0; i < s.length(); i++) {
            dfs(i, i, String.valueOf(s.charAt(i)), "");
        }
		
		System.out.println(list.size());
	}
	
	static void dfs(int l, int r, String tmp, String p) {
		p += tmp;
		
		if (l == 0 && r == s.length() - 1) {
            list.add(p);
            return;
        }
		
		
        if (l > 0) {
            dfs(l - 1, r, s.charAt(l - 1) + tmp, p);
        }

        if (r < s.length() - 1) {
            dfs(l, r + 1, tmp + s.charAt(r + 1), p);
        }
    }
}
