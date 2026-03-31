import java.io.*;
import java.util.*;
public class Main {
	static long x[],y[];
	static int N;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		x = new long[N];
		y = new long[N];
		for(int i=0; i<N; i++) {
			StringTokenizer st=  new StringTokenizer(br.readLine());
			long a = Long.parseLong(st.nextToken());
			long b = Long.parseLong(st.nextToken());
			x[i] = a;
			y[i] = b;
		}
		
		long sum = 0;
		for(int i=0; i<N; i++) {
			int j = (i+1) % N;
			sum += x[i] * y[j];
			sum -= x[j] * y[i];
		}
		
		double a = Math.abs(sum) / 2.0;
		System.out.printf("%.1f\n", a);
	}

}
