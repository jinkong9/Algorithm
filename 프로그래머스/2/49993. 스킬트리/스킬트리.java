import java.io.*;
import java.util.*;

class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        int N = skill_trees.length;
        String arr[] = skill.split("");
        ArrayList<String> list = new ArrayList<>();
        
        for(int i=0; i<arr.length; i++) list.add(arr[i]);
        
        for(int i=0; i<N; i++) {
            boolean[] v = new boolean[skill.length()];
            String arr2[] = skill_trees[i].split("");
             System.out.println(Arrays.toString(arr2));
            int idx = 0;
            boolean f = false;
            for(int j=0; j<arr2.length; j++) {
                if(list.contains(arr2[j])) {
                    if(idx == list.indexOf(arr2[j])) {
                        idx ++;
                    } else {
                        f = true;
                        break;
                    }
                }
            }
            if(!f) answer ++;
        }
        
        return answer;
    }
}