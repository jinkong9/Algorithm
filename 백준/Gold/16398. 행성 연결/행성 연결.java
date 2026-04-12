import java.util.*;
import java.io.*;

class Main {
    static int N, parent[];

    static class Ver {
        int from, to, w;
        Ver(int from, int to, int w) {
            this.from = from;
            this.to = to;
            this.w = w;
        }
    }

    static int find(int a) {
        if(a == parent[a]) return a;
        return parent[a] = find(parent[a]);
    }

    static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if(a != b) parent[a] = b;
    }

    static ArrayList<Ver> list;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        parent = new int[N];
        for(int i=0;i<N;i++) parent[i]=i;

        list = new ArrayList<>();

        for(int i=0;i<N;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++){
                int w = Integer.parseInt(st.nextToken());
                if(i<j) list.add(new Ver(i,j,w));
            }
        }

        Collections.sort(list,(a,b)->a.w-b.w);

        long sum = 0;

        for(Ver v:list){
            if(find(v.from)!=find(v.to)){
                union(v.from,v.to);
                sum+=v.w;
            }
        }

        System.out.print(sum);
    }
}