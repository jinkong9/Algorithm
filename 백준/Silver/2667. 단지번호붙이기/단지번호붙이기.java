import java.util.*;
import java.lang.*;
import java.io.*;


class Main {
    static int N, arr[][], res[];
    static ArrayList <Integer> list;
    static int dr[] = {-1,1,0,0};
    static int dc[] = {0,0,-1,1};
    static class Point {
        int r,c;
        Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
    static Queue <Point> Q;
    static boolean v[][];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        Q = new ArrayDeque<>();
        v = new boolean[N][N];
        arr = new int[N][N];
        for(int i=0; i<N; i++) {
            String s = br.readLine();
            for(int j=0; j<N; j++) {
                arr[i][j] = s.charAt(j) - '0';
            }
        }
        int a = 1;
        list = new ArrayList<>();
        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                if(arr[i][j] != 0 && !v[i][j]) {
                    v[i][j] = true;
                    Q.offer(new Point(i,j));
                    bfs(a);
                    a++;
                }
            }
        }
        // for(int i=0; i<N; i++) {
        //     System.out.println(Arrays.toString(arr[i]));
        // }
        res = new int[a-1];
        for(int i=0; i<list.size(); i++) {
            res[i] = list.get(i);
        }
        Arrays.sort(res);
        StringBuilder sb = new StringBuilder();
        sb.append(a-1).append("\n");
        for(int i=0; i<res.length; i++) {
            sb.append(res[i]).append("\n");
        }
        System.out.print(sb);
    }

    static void bfs(int num) {
        int tmp = 0;
        while(!Q.isEmpty()) {
            tmp ++;
            Point p = Q.poll();
            int pr = p.r;
            int pc = p.c;
            arr[pr][pc] = num;
            for(int i=0; i<4; i++) {
                int nr = pr + dr[i];
                int nc = pc + dc[i];

                if(nr <0 || nr >= N || nc <0 || nc >=N) continue;
                if(v[nr][nc]) continue;
                if(arr[nr][nc] == 0 ) continue;
                arr[nr][nc] = num;
                v[nr][nc] = true;
                Q.offer(new Point(nr,nc));
            }
        }
        list.add(tmp);
    }
}