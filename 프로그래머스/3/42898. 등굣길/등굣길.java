import java.io.*;
import java.util.*;

class Solution {
    static int arr[][], M, N;
    public int solution(int m, int n, int[][] puddles) {
        int answer = 0;
        M = m;
        N = n;
        arr = new int[N+1][M+1];
        
        for(int i=0; i<puddles.length; i++) {
            int a = puddles[i][0];
            int b = puddles[i][1];
            arr[b][a] = -1;
        }
        
        arr[1][1] = 1;
        
        for(int i=1; i<=N; i++) {
            for(int j=1; j<=M; j++) {
                if(arr[i][j] == -1) continue;
                
                if(arr[i-1][j] > 0) {
                    arr[i][j] = (arr[i][j] + arr[i-1][j]) % 1000000007;
                }
                
                if(arr[i][j-1] > 0) {
                    arr[i][j] = (arr[i][j] +arr[i][j-1]) % 1000000007;
                }
            }
        }
       
        return arr[N][M];
    }
}