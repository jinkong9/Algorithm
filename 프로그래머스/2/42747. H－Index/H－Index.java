import java.io.*;
import java.util.*;

class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        Arrays.sort(citations);
        int N = citations.length;
        
        for(int i=0; i<N; i++) {
            int h = N - i;
            
            if(h <= citations[i]) return h;
        }
        
        return answer;
    }
}