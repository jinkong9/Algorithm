
import java.io.*;
import java.util.*;

public class Main {
    static int N, ans = Integer.MAX_VALUE;
    static int[] pop;
    static ArrayList<Integer>[] g;
    static boolean[] sel;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        pop = new int[N + 1];
        g = new ArrayList[N + 1];
        sel = new boolean[N + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) pop[i] = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= N; i++) g[i] = new ArrayList<>();

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());
            for (int j = 0; j < k; j++) {
                int v = Integer.parseInt(st.nextToken());
                g[i].add(v);
            }
        }

        comb(1, 0);
        System.out.println(ans == Integer.MAX_VALUE ? -1 : ans);
    }

    static void comb(int idx, int cnt) {
        if (idx == N + 1) {
            if (cnt == 0 || cnt == N) return;
            if (check(true) && check(false)) ans = Math.min(ans, diff());
            return;
        }
        sel[idx] = true;
        comb(idx + 1, cnt + 1);
        sel[idx] = false;
        comb(idx + 1, cnt);
    }

    static boolean check(boolean flag) {
        boolean[] v = new boolean[N + 1];
        int s = -1;
        for (int i = 1; i <= N; i++) if (sel[i] == flag) { s = i; break; }
        dfs(s, v, flag);
        for (int i = 1; i <= N; i++) if (sel[i] == flag && !v[i]) return false;
        return true;
    }

    static void dfs(int x, boolean[] v, boolean flag) {
        v[x] = true;
        for (int nx : g[x])
            if (!v[nx] && sel[nx] == flag)
                dfs(nx, v, flag);
    }

    static int diff() {
        int a = 0, b = 0;
        for (int i = 1; i <= N; i++) {
            if (sel[i]) a += pop[i];
            else b += pop[i];
        }
        return Math.abs(a - b);
    }
}
