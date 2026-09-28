import java.io.*;
import java.util.*;

class Solution {
    public String solution(String s) {
        String answer = "";
        
        String arr[] = s.split(" ");
        
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        
        for(int i=0; i<arr.length; i++) {
            int a = Integer.parseInt(arr[i]);
            max = Math.max(max, a);
            min = Math.min(min, a);
        }
        
        StringBuilder sb = new StringBuilder();
        sb.append(min).append(" ").append(max);
        
        return sb.toString();
    }
}