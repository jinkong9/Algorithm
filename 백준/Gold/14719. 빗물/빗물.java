import java.io.*;
import java.util.*;

public class Main {
	static int H, W, arr[], ans;
	static int dr[] = { 0, 0 };
	static int dc[] = { -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		H = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());
		arr = new int[W];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < W; i++) {
			int a = Integer.parseInt(st.nextToken());
			arr[i] = a;
		}
		ans = 0;

		check();
		System.out.println(ans);
	}

	static void check() {
		for (int i = 1; i < W - 1; i++) {
			int lm = 0;
			int rm = 0;
			for (int l = 0; l < i; l++) {
				lm = Math.max(lm, arr[l]);
			}

			for (int r = i + 1; r < W; r++) {
				rm = Math.max(rm, arr[r]);
			}
			int min = Math.min(lm, rm) - arr[i];
			if(min >0) ans += min;
		}
	}
}
