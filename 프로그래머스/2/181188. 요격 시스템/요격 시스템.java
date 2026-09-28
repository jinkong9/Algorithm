import java.io.*;
import java.util.*;

class Solution {
    public int solution(int[][] targets) {
        int answer = 0;
        int tmp = 0;
        Arrays.sort(targets, (a,b) -> a[1] - b[1]);
        
        for(int arr[] : targets) {
            int start = arr[0];
            int end = arr[1];
            
            if(tmp <= start) {
                answer ++;
                tmp = end;
            }
        }
        
        return answer;
    }
}