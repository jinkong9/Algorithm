import java.util.*;
class Solution {
    public int solution(String name) {
        int answer = 0;
        int len = name.length();
        int cnt = 0;
        for(int i=0; i<len; i++){
            char a = name.charAt(i);
            int cal = Math.min(a - 'A', 'Z' -a +1);
            answer += cal;
        }
        
        int move = len - 1;
        for(int i=0; i<len; i++){
            int next = i+1;
            while(next < len && name.charAt(next) == 'A'){
                next ++;
            }
            int tmpmove = i + len - next + Math.min(i, len-next);
            move = Math.min(tmpmove, move);
        }
        answer += move;
        return answer;
    }
}