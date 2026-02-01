import java.util.*;

class Solution {
  public static int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> q = new ArrayDeque<>();
        int arr[] = new int[speeds.length];
        for(int i=0; i<arr.length; i++){
            // 프로그래머스 질문하기에 테케 추가해서 잘 생각해보기
            arr[i] = (int)Math.ceil((100.0 - progresses[i] ) / speeds[i]);
        }
        int peek = arr[0];
        int cnt = 1;
        for(int i=1; i<arr.length; i++){
            if(arr[i] <= peek) { 
                cnt ++;
            } else {
            	q.add(cnt);
            	peek = arr[i];
            	cnt = 1;
            }
        }
        q.add(cnt);
        int a = q.size();
        int answer[] = new int[a];
        for(int i=0; i<a; i++) { 
        	answer[i] = q.poll();
        }
        return answer;
        
    }
}