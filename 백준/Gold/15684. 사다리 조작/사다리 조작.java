
import java.io.*;
import java.util.*;

public class Main {
    static int N, M, H;
    static int[][] arr;
    static ArrayList<int[]> list;
    static int ans = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        arr = new int[H][N];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            arr[a][b] = 1;
        }

        list = new ArrayList<>();

         for (int i = 0; i < H; i++) {
            for (int j = 0; j < N - 1; j++) {
                if (arr[i][j] == 0 &&
                    (j == 0 || arr[i][j - 1] == 0) &&
                    (j == N - 2 || arr[i][j + 1] == 0)) {
                    list.add(new int[]{i, j});
                }
            }
        }

        for (int i = 0; i <= 3; i++) {
            comb(0, 0, i);
            if (ans != Integer.MAX_VALUE) break;
        }

        System.out.println(ans == Integer.MAX_VALUE ? -1 : ans);
    }

    static void comb(int idx, int s, int tar) {
        if (idx == tar) {
            if (check()) ans = Math.min(ans, tar);
            return;
        }

        for (int i = s; i < list.size(); i++) {
            int r = list.get(i)[0];
            int c = list.get(i)[1];

            if (arr[r][c] == 1) continue;
            if (c > 0 && arr[r][c - 1] == 1) continue;
            if (c < N - 2 && arr[r][c + 1] == 1) continue;

            arr[r][c] = 1;
            comb(idx + 1, i + 1, tar);
            arr[r][c] = 0;
        }
    }

    static boolean check() {
        for (int i = 0; i < N; i++) {
            int col = i;
            for (int r = 0; r < H; r++) {
                if (col < N - 1 && arr[r][col] == 1) col++;
                else if (col > 0 && arr[r][col - 1] == 1) col--;
            }
            if (col != i) return false;
        }
        return true;
    }
}