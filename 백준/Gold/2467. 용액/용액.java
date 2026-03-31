
import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static long arr[];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new long[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Long.parseLong(st.nextToken());
		}

		int r = 0;
		int c = 0;
		long sum = Long.MAX_VALUE;
		int idx = N - 1;
      int idx1 = 0;
		while (idx1 < idx) {
				long a = (long)arr[idx1] + arr[idx];
				if (Math.abs(a) < sum) {
					r = idx1;
					c = idx;
					sum = Math.abs(a);
				}
			if(a >0) {
				idx--;
			} else {
				idx1 ++;
			}
		}

		System.out.println(arr[r] + " " + arr[c]);
	}

}
