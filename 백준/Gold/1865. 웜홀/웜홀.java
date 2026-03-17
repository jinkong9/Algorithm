import java.io.*;
import java.util.*;

public class Main {
	static int N, M, W;
	static long dist[];

	static class Ver {
		int from, to, w;

		Ver(int from, int to, int w) {
			this.from = from;
			this.to = to;
			this.w = w;
		}
	}

	static ArrayList<Ver> list;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		for (int t = 0; t < tc; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			list = new ArrayList<>();
			dist = new long[N + 1];
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				int w = Integer.parseInt(st.nextToken());
				list.add(new Ver(a, b, w));
                list.add(new Ver(b, a, w));
			}
			for (int i = 0; i < W; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				int w = Integer.parseInt(st.nextToken());
				list.add(new Ver(a, b, -w));
			}
			boolean a = bell();
			if(a) System.out.println("YES");
			else System.out.println("NO");

		}

	}

	static boolean bell() {
		Arrays.fill(dist, 0);
		for(int i=1; i<=N; i++) {
			for(Ver v : list) {
				if(dist[v.to] > dist[v.from] + v.w) {
					dist[v.to] = dist[v.from] + v.w;
					
					if(i == N) return true;
				}
			}
		}
		
		return false;
	}

}
