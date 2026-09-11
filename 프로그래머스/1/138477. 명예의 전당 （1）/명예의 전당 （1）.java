import java.io.*;
import java.util.*;

class Solution {
    public int[] solution(int k, int[] score) {
        int[] answer = new int[score.length];
    
        ArrayList<Integer> list = new ArrayList<>();
        int idx = 0;
        for(int i=0; i<score.length; i++) {
            list.add(score[i]);
            Collections.sort(list, (a,b) -> a-b);
            if(list.size() > k) {
                list.remove(list.get(0));
            }
            answer[i] = list.get(0);
        }
        
        return answer;
    }
}