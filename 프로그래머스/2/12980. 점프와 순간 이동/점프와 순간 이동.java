import java.io.*;

public class Solution {
    public int solution(int n) {
        int ans = 0;
        if (n == 1) {
            return 1;
        }
        ans += 1;
        if(n % 2 == 1) {
            n -= 1;
            ans += 1;
        }
        while(true) {
            if(n == 1) break;
            if(n % 2 == 1 && n != 1) {
                ans ++;
                n -= 1;
            } else if (n % 2 == 0) {
                n /= 2;
            }
        }
        
        return ans;
    }
}