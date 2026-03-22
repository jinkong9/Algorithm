import java.io.*;
import java.util.*;

public class Main {
    static int N, M, arr[][], ans;
    static int[] dr = {-1, 1, 0, 0, -1, -1, 1, 1};
    static int[] dc = {0, 0, -1, 1, -1, 1, -1, 1};
    static boolean v[][], f;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][M];
        v = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) arr[i][j] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (arr[i][j] > 0 && !v[i][j]) {
                    f = true;
                    dfs(i, j);
                    if (f) ans++;
                }
            }
        }
        System.out.println(ans);
    }

    static void dfs(int r, int c) {
        v[r][c] = true;
        for (int i = 0; i < 8; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];

            if (nr < 0 || nr >= N || nc < 0 || nc >= M) continue;
            
            if (arr[nr][nc] > arr[r][c]) f = false;
            if (!v[nr][nc] && arr[nr][nc] == arr[r][c]) {
                dfs(nr, nc);
            }
        }
    }
}