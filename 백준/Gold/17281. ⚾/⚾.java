
import java.io.*;
import java.util.*;

public class Main {
    static int T, arr[][], sum;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());

        arr = new int[T][9];
        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 9; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int play[] = new int[9];
        boolean v[] = new boolean[9];

        play[3] = 0;
        v[0] = true;

        dfs(play, 0, v);
        System.out.println(sum);
    }

    static void dfs(int play[], int idx, boolean v[]) {
        if (idx == 9) {
            game(play);
            return;
        }

        if (idx == 3) {
            dfs(play, idx + 1, v);
            return;
        }

        for (int i = 1; i < 9; i++) {
            if (!v[i]) {
                v[i] = true;
                play[idx] = i;
                dfs(play, idx + 1, v);
                v[i] = false;
            }
        }
    }

    static void game(int tmp[]) {
        int a = 0;
        int b = 0;

        for (int i = 0; i < T; i++) {
            int out = 3;
            boolean[] base = new boolean[4];

            while (out > 0) {
                int s = arr[i][tmp[a]];

                if (s == 0) {
                    out--;
                } else {
                    for (int k = 3; k >= 1; k--) {
                        if (base[k]) {
                            if (k + s >= 4) {
                            	b++;
                            } else {
                            	base[k + s] = true;
                            }
                            base[k] = false;
                        }
                    }
                    if (s >= 4) b++;
                    else base[s] = true;
                }

                a = (a + 1) % 9;
            }
        }

        sum = Math.max(sum, b);
    }
}
