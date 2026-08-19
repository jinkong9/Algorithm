import java.io.*;
import java.util.*;

class Solution {
    public String solution(int n) {
        StringBuilder sb = new StringBuilder();
        String arr[] = {"4", "1", "2"};
        while(n != 0) {
            if(n % 3 == 0) {
                n = (n-1) / 3;
                sb.append("4");
            } else {
                sb.append(arr[n % 3]);
                n /= 3;
            }
        }
        return sb.reverse().toString();
    }
}