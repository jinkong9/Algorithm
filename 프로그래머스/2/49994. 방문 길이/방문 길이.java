import java.util.*;

class Solution {
    static class Point {
        int r,c,t;
        Point(int r, int c, int t) {
            this.r = r;
            this.c = c;
            this.t = t;
        }
    }    
    static int dr[] = {-1,1,0,0};
    static int dc[] = {0,0,-1,1};
    static int arr[][];
    static String s[];
    
    public int solution(String dirs) {
        int answer = 0;
        arr = new int[21][21];
        s = dirs.split("");
        
        boolean v[][] = new boolean[21][21];
        
        int sr = 10;
        int sc = 10;
        
        for(int i=0; i<s.length; i++) {
            int tmp = check(s[i]);
            int nr = sr + dr[tmp] * 2;
            int nc = sc + dc[tmp] * 2;
            
            if(nr < 0 || nr >= 21 || nc < 0 || nc >= 21) { 
                continue;
            } 
            
            int midR = (sr + nr) / 2;
            int midC = (sc + nc) / 2;
            
            if(v[midR][midC]) { 
                sr = nr;
                sc = nc;
            } else {
                answer++;
                v[midR][midC] = true;
                sr = nr;
                sc = nc;
            }
        }
        
        return answer;
    }
    
    static int check(String tmp) {
        if(tmp.equals("U")) {
            return 0;
        } else if(tmp.equals("D")) {
            return 1;
        } else if(tmp.equals("L")) {
            return 2;
        } else if(tmp.equals("R")) {
            return 3;
        }
        return -1;
    }
}
