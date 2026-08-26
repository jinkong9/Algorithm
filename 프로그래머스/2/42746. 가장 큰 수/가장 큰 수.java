import java.io.*;
import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        int N = numbers.length;
        StringBuilder sb = new StringBuilder();
        Arrays.sort(numbers);
        String arr[] = new String[N];
        for(int i=0; i<N; i++) {
            arr[i] = String.valueOf(numbers[i]);
        }
        
        Arrays.sort(arr, (a,b) -> (b+a).compareTo(a+b));
        
        if(arr[0].equals("0")) return "0";
        
        for(int i=0; i<N; i++) {
            sb.append(arr[i]);
        }
        
        return sb.toString();
    }
}