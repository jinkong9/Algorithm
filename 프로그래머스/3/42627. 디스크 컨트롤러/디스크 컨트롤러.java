import java.io.*;
import java.util.*;

class Solution {
    static class Node {
        int start, t;
        Node(int start, int t) {
            this.start = start;
            this.t = t;
        }
    }
    public int solution(int[][] jobs) {
        int answer = 0;
        Arrays.sort(jobs, (a,b) -> a[0] - b[0]);
        PriorityQueue<Node> pq = new PriorityQueue<>((a,b) -> a.t - b.t);
        
        int now = 0;
        int sum = 0;
        int idx = 0;
        int cnt = 0;
        
        while(cnt < jobs.length) {
            while(idx < jobs.length && jobs[idx][0] <= now) {
                pq.offer(new Node(jobs[idx][0], jobs[idx][1]));
                idx ++;
            }
            
            if(pq.isEmpty()) {
                now = jobs[idx][0];
            } else {
                Node node = pq.poll();
                now += node.t;
                sum += (now - node.start);
                cnt ++;
            }
        }
        
        answer = sum / jobs.length;
        return answer;
    }
}