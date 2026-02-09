
import java.io.*;
import java.util.*;

public class Solution {
    static ArrayList<Integer>[] list;
    static boolean[] v;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int tc = 1; tc <= 10; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int start = Integer.parseInt(st.nextToken());

            list = new ArrayList[101];
            for (int i = 0; i <= 100; i++) list[i] = new ArrayList<>();

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N / 2; i++) {
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());
                list[from].add(to);
            }

            v = new boolean[101];
            int a = bfs(start);
            System.out.println("#" +tc +" " + a);
        }
    }

    static int bfs(int start) {
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(start);
        v[start] = true;

        int answer = start;

        while (!q.isEmpty()) {
            int size = q.size();
            int max = 0;

            for (int i = 0; i < size; i++) {
                int cur = q.poll();
                max = Math.max(max, cur);

                for (int next : list[cur]) {
                    if (!v[next]) {
                        v[next] = true;
                        q.offer(next);
                    }
                }
            }
            answer = max;
        }
        return answer;
    }
}
