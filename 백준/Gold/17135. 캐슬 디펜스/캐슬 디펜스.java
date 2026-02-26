import java.io.*;
import java.util.*;

public class Main {
    static int N, M, D;
    static int[][] origin;
    static int answer = 0;

    static class Enemy {
        int r, c, d;
        Enemy(int r, int c, int d) {
            this.r = r;
            this.c = c;
            this.d = d;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        origin = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                origin[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 궁수 위치 3개 조합
        for (int i = 0; i < M - 2; i++) {
            for (int j = i + 1; j < M - 1; j++) {
                for (int k = j + 1; k < M; k++) {
                    simulate(new int[]{i, j, k});
                }
            }
        }

        System.out.println(answer);
    }

    static void simulate(int[] archers) {
        int[][] map = new int[N][M];
        for (int i = 0; i < N; i++) {
            map[i] = origin[i].clone();
        }

        int kill = 0;

        for (int turn = 0; turn < N; turn++) {
            Set<String> targets = new HashSet<>();

            // 각 궁수별 타겟 탐색
            for (int a : archers) {
                Enemy target = findTarget(map, a);
                if (target != null) {
                    targets.add(target.r + "," + target.c);
                }
            }

            // 동시 제거
            for (String s : targets) {
                String[] t = s.split(",");
                int r = Integer.parseInt(t[0]);
                int c = Integer.parseInt(t[1]);
                if (map[r][c] == 1) {
                    map[r][c] = 0;
                    kill++;
                }
            }

            // 적 한 칸 아래로 이동
            for (int r = N - 1; r > 0; r--) {
                map[r] = map[r - 1];
            }
            map[0] = new int[M];
        }

        answer = Math.max(answer, kill);
    }

    static Enemy findTarget(int[][] map, int archerCol) {
        Enemy res = null;

        for (int r = N - 1; r >= 0; r--) {
            for (int c = 0; c < M; c++) {
                if (map[r][c] == 1) {
                    int dist = Math.abs(N - r) + Math.abs(archerCol - c);
                    if (dist <= D) {
                        if (res == null ||
                            dist < res.d ||
                            (dist == res.d && c < res.c)) {
                            res = new Enemy(r, c, dist);
                        }
                    }
                }
            }
        }
        return res;
    }
}