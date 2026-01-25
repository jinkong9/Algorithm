import java.util.*;
class Solution {
    public int[] solution(int[] answers) {
        
        int cnt1 = 0;
        int cnt2 = 0;
        int cnt3 = 0;
        int arr1[] = {1,2,3,4,5};
        int arr2[] = {2,1,2,3,2,4,2,5};
        int arr3[] = {3,3,1,1,2,2,4,4,5,5};
        int max = 0;
        for(int i=0; i<answers.length; i++){
            if(answers[i] == arr1[i % arr1.length]) cnt1 ++;
            if(answers[i] == arr2[i % arr2.length]) cnt2 ++;
            if(answers[i] == arr3[i % arr3.length]) cnt3 ++;
        }
        int arr[] = {cnt1, cnt2, cnt3};

        for(int i=0; i<3; i++){
            max = Math.max(max, arr[i]);
        }
        int size = 0;
        if (cnt1 == max) size++;
        if (cnt2 == max) size++;
        if (cnt3 == max) size++;

        int[] answer = new int[size];
        int idx = 0;

        if (cnt1 == max) answer[idx++] = 1;
        if (cnt2 == max) answer[idx++] = 2;
        if (cnt3 == max) answer[idx++] = 3;
    
        return answer;
    }
}