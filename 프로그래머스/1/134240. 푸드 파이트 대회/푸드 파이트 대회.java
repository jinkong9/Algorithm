import java.io.*;
import java.util.*;

class Solution {
    public String solution(int[] food) {
        String answer = "";
        
        for(int i=1; i<food.length; i++) {
            if(food[i] % 2 == 1) food[i] -= 1;
        }
        
        StringBuilder sb = new StringBuilder();
        int idx = 1;
        
        for(int i=1; i<food.length; i++) {
            for(int j=0; j<food[i] / 2; j++) {
                sb.append(idx);
            }
            idx ++;
        }
        
        String tmp = sb.toString();
        StringBuilder tt = new StringBuilder(tmp);
        String reverse = tt.reverse().toString();
        sb.append(0).append(reverse);
        
        return sb.toString();
    }
}