import java.io.*;
import java.util.*;

class Solution {
    public int solution(int storey) {
        int answer = 0;
        if(storey == 0) return 0;
        String s = String.valueOf(storey);
        String ans = "";
        int len = s.length();
        // 5보다 크면 더하기 작으면 빼기
        String arr[] = s.split("");
        
        for(int i=len-1; i>=1; i--) {
            int tmp = Integer.parseInt(arr[i]);
            int next_tmp = Integer.parseInt(arr[i-1]);
            if(next_tmp >= 5) {
                if(tmp >= 5) {
                answer += 10 - tmp;
                String a = arr[i-1];
                int b = Integer.parseInt(a);
                b += 1;
                a = String.valueOf(b);
                arr[i-1] = a;
                arr[i] = "0";
                } else {
                    answer += tmp;
                    arr[i] = "0";
                }
            } else {
                if(tmp > 5) {
                answer += 10 - tmp;
                String a = arr[i-1];
                int b = Integer.parseInt(a);
                b += 1;
                a = String.valueOf(b);
                arr[i-1] = a;
                arr[i] = "0";
                } else {
                    answer += tmp;
                    arr[i] = "0";
                }
            }
        }
        for(int i=0; i<len; i++) ans += arr[i];
        System.out.print(ans);
        
        String first[] = ans.split("");
        
        int first_ans = Integer.parseInt(first[0]);
        if(first_ans > 5) {
            answer = answer + (10 - first_ans) + 1;
        } else {
            answer += first_ans;
        }
        
        return answer;
    }
}