import java.io.*;
import java.util.*;

class Solution {
    static boolean arr[][];
    public int solution(int n, int[][] wires) {
        int answer = 100000000;
        arr = new boolean[n+1][n+1];
        
        for(int i=0; i<wires.length; i++) {
            int a = wires[i][0];
            int b = wires[i][1];
            
            arr[a][b] = true;
            arr[b][a] = true;
        }
        
        for(int i=0; i<wires.length; i++) {
            int a = wires[i][0];
            int b = wires[i][1];
            
            arr[a][b] = false;
            arr[b][a] = false;
            
            int cnt = bfs(a, n);
            int aa = Math.abs(cnt - (n - cnt));
            answer = Math.min(answer, aa);
            
            arr[a][b] = true;
            arr[b][a] = true;
                
        }
        
        return answer;
    }
    static int bfs(int start, int n) {
        boolean v[] = new boolean[n+1];
        int tmp = 1;
        Queue<Integer> Q = new ArrayDeque<>();
        Q.offer(start);
        v[start] = true;
        
        while(!Q.isEmpty()) {
            int cur = Q.poll();
            for(int i=1; i<=n; i++) {
                if(arr[cur][i] && !v[i]) {
                    v[i] = true;
                    Q.offer(i);
                    tmp ++;
                }
            }
        }
        return tmp;
    }
}