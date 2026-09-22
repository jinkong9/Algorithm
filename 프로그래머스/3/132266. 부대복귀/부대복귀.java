import java.io.*;
import java.util.*;

class Solution {
    static class Node {
        int to, w;
        Node(int to, int w) {
            this.to = to;
            this.w = w;
        }
    }
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        int[] answer = new int[sources.length];
        ArrayList<Node> list[] = new ArrayList[n+1];
        boolean v[] = new boolean [n+1];
        for(int i=1; i<=n; i++) {
            list[i] = new ArrayList<>();
        }
        
        for(int i=0; i<roads.length; i++) {
            int a = roads[i][0];
            int b = roads[i][1];
            v[a] = v[b] = true;
            list[a].add(new Node(b,1));
            list[b].add(new Node(a,1));
        }
        
        int dist[] = new int[n+1];
        PriorityQueue<Node> pq = new PriorityQueue<>((a,b) -> a.w - b.w);
        Arrays.fill(dist, 100000000);
        pq.offer(new Node(destination, 0));
        dist[destination] = 0;
        
        while(!pq.isEmpty()) {
            Node now = pq.poll();
                
            if(now.w > dist[now.to]) continue;
                
            for(Node next : list[now.to]) {
                if(dist[next.to] > next.w + dist[now.to]) {
                    dist[next.to] = next.w + dist[now.to];
                    pq.offer(new Node(next.to, dist[next.to]));
                }
            }
        }
        
        for(int i=0; i<sources.length; i++) {
            int tmp = dist[sources[i]];
            if(tmp == 100000000) answer[i] = -1;
            else answer[i] = tmp;
        }
        
        return answer;
    }
}