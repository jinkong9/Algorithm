import java.io.*;
import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Long> pq = new PriorityQueue<>((a,b) -> Long.compare(a,b));
        for(int i=0; i<scoville.length; i++) {
            pq.offer((long)scoville[i]);
        }

        while(pq.peek() < K) {
            if(pq.size() < 2) {
                answer = -1;
                break;
            }
            long a = pq.poll();
            long b = pq.poll();
            long sum = a;
            sum += 2*b;
            answer ++;
            pq.offer(sum);
        }
        
        return answer;
    }
}