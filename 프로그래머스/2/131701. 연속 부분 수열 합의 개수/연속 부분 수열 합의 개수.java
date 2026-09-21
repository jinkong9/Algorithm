import java.io.*;
import java.util.*;

class Solution {
    public int solution(int[] elements) {
        int answer = 0;
        int N = elements.length;
        HashSet<Integer> set = new HashSet<>();
        
        int arr[] = new int[2*N];
        
        for(int i=0; i<N; i++) {
            arr[i] = elements[i];
            arr[i + N] = elements[i];
        }
        
        for(int size = 1; size <= N; size++) {
            for(int i=0; i<N; i++) {
                int tmp = 0;
               for(int j=i; j<i+size; j++) {
                   tmp += arr[j];
               }
                set.add(tmp);
            }
        }
        answer = set.size();
        return answer;
    }
}