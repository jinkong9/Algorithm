
import java.io.*;
import java.util.*;

public class Main {
    static int N, M, parent[];
    static char[][] arr;
    static ArrayList<Point> nodes = new ArrayList<>();
    static ArrayList<Ver> list = new ArrayList<>();
    
    static Queue<Point> Q;
    
    static class Point {
        int r,c;
        Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
    
    static class Ver implements Comparable<Ver> {
        int a, b, cost;
        Ver(int a, int b, int cost) {
            this.a = a;
            this.b = b;
            this.cost = cost;
        }
        public int compareTo(Ver o) {
            return this.cost - o.cost;
        }
    }

    static int find(int x) {
        if(parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }

    static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if(a != b) parent[b] = a;
    }
    
    static void bfs(int idx) {
        int[][] dist = new int[N][N];
        for(int[] d : dist) Arrays.fill(d, -1);
        
        Point start = nodes.get(idx);
        Q = new ArrayDeque<>();
        Q.offer(start);
        dist[start.r][start.c] = 0;
        
        int[] dr = {1,-1,0,0};
        int[] dc = {0,0,1,-1};
        
        while(!Q.isEmpty()) {
            Point cur = Q.poll();
            
            for(int d=0; d<4; d++) {
                int nr = cur.r + dr[d];
                int nc = cur.c + dc[d];
                
                if(nr<0||nc<0||nr>=N||nc>=N) continue;
                if(arr[nr][nc] == '1') continue;
                if(dist[nr][nc] != -1) continue;
                
                dist[nr][nc] = dist[cur.r][cur.c] + 1;
                Q.offer(new Point(nr, nc));
            }
        }
        
        for(int i=0; i<nodes.size(); i++) {
            if(i == idx) continue;
            
            Point t = nodes.get(i);
            int d = dist[t.r][t.c];
            
            if(d != -1) {
                list.add(new Ver(idx, i, d));
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        arr = new char[N][N];
        
        for(int i=0; i<N; i++) {
            String str = br.readLine();
            for(int j=0; j<N; j++) {
                arr[i][j] = str.charAt(j);
                
                if(arr[i][j] == 'S' || arr[i][j] == 'K') {
                    nodes.add(new Point(i, j));
                }
            }
        }
        
        for(int i=0; i<nodes.size(); i++) {
            bfs(i);
        }
        
        Collections.sort(list);
        
        parent = new int[nodes.size()];
        for(int i=0; i<nodes.size(); i++) parent[i] = i;
        
        int cnt = 0;
        int sum = 0;
        
        for(Ver v : list) {
            if(find(v.a) != find(v.b)) {
                union(v.a, v.b);
                sum += v.cost;
                cnt++;
            }
        }
        
        if(cnt == nodes.size() - 1) {
            System.out.println(sum);
        } else {
            System.out.println(-1);
        }
    }
}