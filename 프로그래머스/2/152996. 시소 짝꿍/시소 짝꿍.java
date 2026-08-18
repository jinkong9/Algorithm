import java.io.*;
import java.util.*;

class Solution {
    public long solution(int[] weights) {
        long answer = 0;
        int N = weights.length;
        Arrays.sort(weights);
        
        int idx1 = 0;
        int idx2 = N-1;
        
        while(true) {
            if(idx1 == N-1) break;
            int a = weights[idx1];
            int b = weights[idx2];
            double div = (double) b/a;
            // 2:2 2:3 2:4 3:4 = a : b 
            if(a == b || 3*a == 2* b || 2*a == b || 4*a == 3*b ) {
                answer ++;
            }
            if(idx2 == idx1+1) {
                idx1++;
                idx2 = N-1;
            } else {
                idx2 --;
            }
        }
        
        return answer;
    }
}