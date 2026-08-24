import java.io.*;
import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        int[] answer = new int[2];
        TreeSet<Integer> set = new TreeSet<>();
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for(int i=0; i<operations.length; i++) {
            StringTokenizer st = new StringTokenizer(operations[i]);
            String a = st.nextToken();
            int b = Integer.parseInt(st.nextToken());
            if(a.equals("I")) {
                map.put(b, map.getOrDefault(b, 0) + 1);
            } else {
                if(map.isEmpty()) continue;
                
                if(b == 1) {
                    int Vtmp = map.lastEntry().getValue();
                    int Ktmp = map.lastEntry().getKey();
                    if(Vtmp > 1) {
                        map.put(Ktmp, Vtmp -1);
                    } else {
                        map.remove(Ktmp);
                    }
                } else {
                    int Vtmp = map.firstEntry().getValue();
                    int Ktmp = map.firstEntry().getKey();
                    if(Vtmp > 1) {
                        map.put(Ktmp, Vtmp -1);
                    } else {
                        map.remove(Ktmp);
                    }
                }
            }
        }
        
        if(map.isEmpty()) {
            answer[0] = answer[1] = 0;
        } else {
            answer[0] = map.lastKey();
            answer[1] = map.firstKey();
        }
        
        return answer;
    }
}