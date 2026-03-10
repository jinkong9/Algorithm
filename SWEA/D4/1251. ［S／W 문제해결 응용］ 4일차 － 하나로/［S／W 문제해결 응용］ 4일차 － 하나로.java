import java.io.*;
import java.util.*;

public class Solution {

    static int N;
    static int parent[];

    static class Ver implements Comparable<Ver>{
        int from, to;
        double w;

        Ver(int from, int to, double w){
            this.from = from;
            this.to = to;
            this.w = w;
        }

        public int compareTo(Ver o){
            return Double.compare(this.w, o.w);
        }
    }

    static int find(int a){
        if(parent[a] == a) return a;
        return parent[a] = find(parent[a]);
    }

    static boolean union(int a, int b){
        a = find(a);
        b = find(b);

        if(a == b) return false;

        parent[b] = a;
        return true;
    }

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for(int tc=1; tc<=T; tc++){

            N = Integer.parseInt(br.readLine());

            int[] x = new int[N];
            int[] y = new int[N];

            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i=0;i<N;i++) x[i] = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            for(int i=0;i<N;i++) y[i] = Integer.parseInt(st.nextToken());

            double E = Double.parseDouble(br.readLine());

            parent = new int[N];
            for(int i=0;i<N;i++) parent[i] = i;

            ArrayList<Ver> list = new ArrayList<>();

            for(int i=0;i<N;i++){
                for(int j=i+1;j<N;j++){
                    double tmpx =Math.abs(x[i] - x[j]);
                    double tmpy =Math.abs(y[i] - y[j]);
                    double d = Math.pow(tmpx, 2) + Math.pow(tmpy,2);
                    list.add(new Ver(i,j,d));
                }
            }

            Collections.sort(list);

            double result = 0;
            int count = 0;

            for(Ver e : list){

                if(union(e.from,e.to)){
                    result += e.w;
                    count++;

                    if(count == N-1) break;
                }
            }

            result *= E;

            System.out.println("#"+tc+" "+Math.round(result));
        }
    }
}