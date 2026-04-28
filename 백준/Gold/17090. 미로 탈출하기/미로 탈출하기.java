import java.io.*;
import java.util.*;

public class Main {
    static int N, M, ans;
    static char[][] arr;
    static int[][] state;

    static int[] dr = { -1, 0, 1, 0 };
    static int[] dc = { 0, 1, 0, -1 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new char[N][M];
        state = new int[N][M];

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < M; j++) {
                arr[i][j] = s.charAt(j);
            }
        }

        ans = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (dfs(i, j)) {
                    ans++;
                }
            }
        }

        System.out.println(ans);
    }

    static boolean dfs(int r, int c) {
        if (r < 0 || r >= N || c < 0 || c >= M) {
            return true;
        }

        if (state[r][c] == 1) {
            return false;
        }

        if (state[r][c] == 2) {
            return true;
        }

        if (state[r][c] == 3) {
            return false;
        }

        state[r][c] = 1;

        int dir = getDir(arr[r][c]);
        int nr = r + dr[dir];
        int nc = c + dc[dir];

        boolean canEscape = dfs(nr, nc);

        state[r][c] = canEscape ? 2 : 3;

        return canEscape;
    }

    static int getDir(char ch) {
        if (ch == 'U') return 0;
        if (ch == 'R') return 1;
        if (ch == 'D') return 2;
        return 3;
    }
}
