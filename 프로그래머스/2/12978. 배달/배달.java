import java.io.*;
import java.util.*;

class Solution {
    static ArrayList<Ver> list[];
    static int cnt;
    static class Ver implements Comparable<Ver> {
        int to, w;
        Ver(int to, int w) {
            this.to = to;
            this.w = w;
        }
        @Override
        public int compareTo(Ver o) {
            return this.w - o.w;
        }
    }
    public int solution(int N, int[][] road, int K) {
        int answer = 0;
        list = new ArrayList[N+1];
        for(int i=1; i<=N; i++) {
            list[i] = new ArrayList<>();
        }
        for(int i=0; i<road.length; i++) {
            int a = road[i][0];
            int b = road[i][1];
            int c = road[i][2];
            list[a].add(new Ver(b,c));
            list[b].add(new Ver(a,c));
        }
        cnt = 0;
        dijkstra(N, K);
        return cnt;
    }
    static void dijkstra(int N, int K) {
        PriorityQueue<Ver> pq = new PriorityQueue<>();
        pq.offer(new Ver(1,0));
        int dist[] = new int[N+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[1] = 0;
        
        while(!pq.isEmpty()) {
            Ver now = pq.poll();
            if(dist[now.to] < now.w) continue;
            
            for(Ver next : list[now.to]) {
                if(dist[next.to] > dist[now.to] + next.w) {
                    dist[next.to] = dist[now.to] + next.w;
                    pq.offer(new Ver(next.to, dist[next.to]));
                }
            }
        }
        for(int i=1; i<=N; i++) {
            if(dist[i] == Integer.MAX_VALUE || dist[i] > K) continue;
            cnt ++;
        }
    }
}