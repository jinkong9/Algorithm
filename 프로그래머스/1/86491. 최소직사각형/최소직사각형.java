import java.util.*;
class Solution {
    public int solution(int[][] sizes) {
        int answer = 0;
        int max = 0;
        int min = 0;
        
        for(int i=0; i<sizes.length; i++){
            int Rtmp = Math.max(sizes[i][0], sizes[i][1]);
            int Ctmp = Math.min(sizes[i][0], sizes[i][1]);
            
            max = Math.max(Rtmp, max);
            min = Math.max(Ctmp, min);
        }
        
        answer = max * min;
        return answer;
        
    }
}