import java.io.*;
import java.util.*;

class Solution {
    static class Ver {
        int from, to, w;
        Ver(int from, int to, int w) {
            this.from = from;
            this.to = to;
            this.w = w;
        }
    }
    static int find(int a) {
        if(parent[a] == a) {
            return a;
        } else {
            return parent[a] = find(parent[a]);
        }
    }
    static void union(int a, int b) {
        a = find(a);
        b = find(b);
        
        if(a != b) {
            parent[a] = b;
        }
    }
    static int parent[];
    static ArrayList<Ver> list;
    public int solution(int n, int[][] costs) {
        int answer = 0;
        parent = new int[n];
        for(int i=0; i<n; i++) parent[i] = i;
        
        list = new ArrayList<>();
        
        for(int i=0; i<costs.length; i++) {
            int a = costs[i][0];
            int b = costs[i][1];
            int c = costs[i][2];
            
            list.add(new Ver(a,b,c));
        }
        
        Collections.sort(list, (a,b) -> a.w - b.w);
        int cnt = 0;
        int sum = 0;
        for(Ver v : list) {
            if(find(v.from) != find(v.to)) {
                union(v.from, v.to);
                sum += v.w;
            }
        }
        
        answer = sum;
        return answer;
    }
}