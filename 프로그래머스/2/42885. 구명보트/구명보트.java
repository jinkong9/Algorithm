import java.io.*;
import java.util.*;
class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        Arrays.sort(people);
        int left = 0;
        int right = people.length-1;
        int tmp =0;
        while(left < right) {
            if(people[right] + people[left] <= limit) {
                tmp ++;
                left ++;
                right --;
            } else {
                right --;
            } 
        }
        
        return people.length-tmp;
    }
}