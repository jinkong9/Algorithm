import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    static int N,M;
    static class Ver implements Comparable<Ver> {
		int to,w;
		Ver(int to, int w) {
			this.to = to;
			this.w = w;
		}
		@Override
		public int compareTo(Ver o) {
			return this.w - o.w;
		}
    }
        static ArrayList<Ver> list[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        list = new ArrayList[N+1];
        for(int i=1; i<=N; i++) list[i] = new ArrayList<>();
        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            list[a].add(new Ver(b,w));
            list[b].add(new Ver(a,w));
        }

        dijkstra();
    }

    static void dijkstra() {
        int dist[] = new int[N+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        PriorityQueue <Ver> Q = new PriorityQueue<>();
        Q.offer(new Ver(1,0));
        dist[1] = 0;

        while(!Q.isEmpty()) {
            Ver now = Q.poll();

            if(dist[now.to] < now.w) continue;

                for(Ver next : list[now.to]) {
                if(dist[next.to] > dist[now.to] + next.w) {
                    dist[next.to] = dist[now.to] + next.w;
                    Q.offer(new Ver(next.to, dist[next.to]));
                }
            }
        }
        System.out.println(dist[N]);
    }

}