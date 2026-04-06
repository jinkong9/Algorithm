import java.io.*;
import java.util.*;
public class Main {
	static int N;
	static class Point implements Comparable<Point> {
		int start,end;
		Point(int start, int end) {
			this.start = start;
			this.end = end;
		}
		@Override
		public int compareTo(Point o) {
		    return this.start - o.start;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> Q = new PriorityQueue<>();
		Point arr[] = new Point[N];
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			arr[i] = new Point(b,c);
		}
		
		Arrays.sort(arr);
		
		Q.offer(arr[0].end);
		
		for(int i=1; i<N; i++) {
			if(Q.peek() <= arr[i].start) {
				Q.poll();
			}
			Q.offer(arr[i].end);
		}
		
		System.out.println(Q.size());
	}

}
