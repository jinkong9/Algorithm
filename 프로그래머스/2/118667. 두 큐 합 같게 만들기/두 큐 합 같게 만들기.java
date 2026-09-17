import java.io.*;
import java.util.*;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int answer = -2;
        Queue <Integer> Q1 = new ArrayDeque<>();
        Queue <Integer> Q2 = new ArrayDeque<>();
        long sum1 = 0;
        long sum2 = 0;
        for(int i=0; i<queue1.length; i++) {
            Q1.offer(queue1[i]);
            sum1 += queue1[i];
        }
        for(int i=0; i<queue2.length; i++) {
            Q2.offer(queue2[i]);
            sum2 += queue2[i];
        }
        int cnt = 0;
        if((sum1 + sum2) % 2 == 1) return -1;
        if(sum1 == sum2) return 0;
        while(sum1 != sum2) {
            if(cnt > (queue1.length + queue2.length) * 4) {
                cnt = -1;
                break;
            }
            if(sum1 > sum2) {
                int a = Q1.poll();
                Q2.offer(a);
                sum1 -= a;
                sum2 += a;
                cnt ++;
            } else {
                int b = Q2.poll();
                Q1.offer(b);
                sum2 -= b;
                sum1 += b;
                cnt ++;
            }
        }
        
        return cnt;
    }
}