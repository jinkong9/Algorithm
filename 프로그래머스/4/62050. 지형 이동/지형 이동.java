import java.io.*;
import java.util.*;

class Solution {
    static int parent[];
    static int dr[] = {-1,1,0,0};
    static int dc[] = {0,0,-1,1};
    static ArrayList<Ver> list;
    static int find(int a) {
        if(a == parent[a]) {
            return a;
        }
        return parent[a] = find(parent[a]);
    }
    static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if(a != b) {
            parent[a] = b;
        }
    }
    static class Ver implements Comparable<Ver> {
        int from, to, w;
        Ver(int from, int to, int w) {
            this.from = from;
            this.to = to;
            this.w = w;
        }
        @Override
        public int compareTo(Ver o) {
            return this.w - o.w;
        } 
    }    
    
    public int solution(int[][] land, int height) {
        int N = land.length * land.length;
        parent = new int[N];
        list = new ArrayList<>();
        for(int i=0; i<N; i++) parent[i] = i;
        for(int i=0; i<land.length; i++) {
            for(int j=0; j<land.length; j++) {
                for(int k=0; k<4; k++) {
                    int nr = i + dr[k];
                    int nc = j + dc[k];
                    if(nr <0 || nr >= land.length || nc <0 || nc >= land.length ) continue;
                    int now_tmp = i*land.length + j;
                    int next_tmp = nr*land.length + nc;
                    int diff = Math.abs(land[i][j] - land[nr][nc]);
                    
                    int cost = (diff <= height) ? 0 : diff;
                    list.add(new Ver(now_tmp, next_tmp, cost));
                }
            }
        }
        Collections.sort(list);
        int used = 0;
        int sum = 0;
        for(Ver v : list) {
            if(find(v.from) != find(v.to)) {
                union(v.from, v.to);
                used ++;
                sum += v.w;
                
                if(used == N-1) break;
            }
        }
        return sum;
    }
}