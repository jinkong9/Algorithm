import java.io.*;
import java.util.*;

class Solution {
    public int[] solution(int n, int s) {
        if (s < n) {
            return new int[] {-1};
        }
        
        int mok = s / n;
        int na = s % n;
        int ans[] = new int[n];
        for(int i=0; i<n; i++) {
            ans[i] = mok;
        }
        
        int idx = 0;
        while(na != 0) {
            if(idx == n) {
                idx = 0;
            } else {
                ans[idx] ++;
                na --;
                idx ++;
            }
        }
        Arrays.sort(ans);
        return ans;
    }
}