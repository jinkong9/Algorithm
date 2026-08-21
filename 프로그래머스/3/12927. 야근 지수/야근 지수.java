import java.io.*;
import java.util.*;

class Solution {
    public long solution(int n, int[] works) {
        long answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b-a);
        
        for(int i=0; i<works.length; i++) {
            pq.offer(works[i]);
        }
        
        while(n != 0) {
            int tmp = pq.poll();
            
            if(tmp == 0) {
                return 0;
            } else {
                pq.offer(tmp -1);
                n --;
            }
            
        }
        
        while(!pq.isEmpty()) {
            long tmp = pq.poll();
            answer += tmp * tmp;
        }
        
        return answer;
    }
}