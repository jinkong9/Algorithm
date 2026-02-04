
import java.io.*;
import java.util.*;

public class Main {
	static ArrayList<Integer>[] list;
	static boolean[] v;
	static int Comp, link;
	static int cnt = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Comp = Integer.parseInt(br.readLine());
		link = Integer.parseInt(br.readLine());
		list = new ArrayList[Comp + 1];

		for (int i = 0; i <= Comp; i++) {
			list[i] = new ArrayList<Integer>();
		}
		v = new boolean[Comp+1];
		for (int i = 0; i < link; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			list[A].add(B);
			list[B].add(A);
		}
		dfs(1);
		System.out.println(cnt-1);
	}

	static void dfs(int ver) {
		if (!v[ver]) {
			v[ver] = true;
			cnt ++;
			for(int i=0; i<list[ver].size(); i++) {
				dfs(list[ver].get(i));
			}
		}
	}
}
