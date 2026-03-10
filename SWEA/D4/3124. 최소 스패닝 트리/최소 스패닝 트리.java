

import java.io.*;
import java.util.*;

public class Solution {

    static int N,M;
    static int parent[];

    static class Ver {
        int from, to, w;

        Ver(int from, int to, int w){
            this.from = from;
            this.to = to;
            this.w = w;
        }

    }

    static int find(int a){
        if(parent[a] == a) return a;
        return parent[a] = find(parent[a]);
    }

    static void union(int a, int b){
        a = find(a);
        b = find(b);

        if(a != b) {
        	parent[a] = b;
        }
    }

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for(int tc=1; tc<=T; tc++){

            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            
            
            parent = new int[N+1];
            for(int i=1;i<=N;i++) parent[i] = i;

            ArrayList<Ver> list = new ArrayList<>();

            for(int i=0; i<M; i++) {
            	st = new StringTokenizer(br.readLine());
            	int x = Integer.parseInt(st.nextToken());
            	int y = Integer.parseInt(st.nextToken());
            	int w = Integer.parseInt(st.nextToken());
            	list.add(new Ver(x,y,w));
            }
            
            Collections.sort(list, (a,b) -> a.w - b.w);

            long sum = 0;
            for(Ver v : list){
                if(find(v.from) != find(v.to)){
                	union(v.from,v.to);
                	sum += v.w;
                }
            }


            StringBuilder sb = new StringBuilder();
            sb.append("#").append(tc).append(" ").append(sum);
            System.out.println(sb);
        }
    }
}