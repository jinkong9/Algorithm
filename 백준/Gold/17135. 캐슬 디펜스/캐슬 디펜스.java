
import java.io.*;
import java.util.*;

public class Main {
	static int N, M, D, arr[][], bowR[], bowC[], ans;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		ans = 0;
		comb(0, 0, new int[3]);
		System.out.println(ans);
	}

	static void comb(int idx, int start, int sel[]) {
		if (idx == 3) {
			play(sel);
			return;
		}
		// 조합 
		for (int i = start; i < M; i++) {
			sel[idx] = i;
			comb(idx + 1, i + 1, sel);
		}
	}

	static void play(int sel[]) {
		int map[][] = new int[N][M];
		for (int i = 0; i < N; i++) {
			map[i] = arr[i].clone();
		}
		int tmp = 0;
		while (true) {
			boolean k[][] = new boolean[N][M];
			for (int a = 0; a < sel.length; a++) {
				int ar = N;
				int ac = sel[a];

				int tr = -1;
				int tc = -1;
				// target r, target c임
				int min = Integer.MAX_VALUE;

				for (int r = N - 1; r >= 0; r--) {
					for (int c = 0; c < M; c++) {
						if (map[r][c] == 1) {
							// 거리계산
							int d = Math.abs(ar - r) + Math.abs(ac - c);
							// 최소 거리보다 크면은 넘김
							if (d > D)
								continue;
							// 최소거리거나 더 왼쪽에 있을 때 경우
							if (d < min || d == min && c < tc) {
								min = d;
								tr = r;
								tc = c;
								// map이 1일 때 즉, 적이 있을 때 tr tc 바꿔줌
							}
						}
					}
				}
				if (tr != -1)
					k[tr][tc] = true;
				// 적이 있으면 tr, tc가 바뀌므로 true
			}
			for (int r = N - 1; r >= 0; r--) {
				for (int c = 0; c < M; c++) {
					if (k[r][c]) {
						map[r][c] = 0;
						tmp++;
					}
				}
			}
			boolean flag = true;
			for (int r = N - 1; r > 0; r--) {
				map[r] = map[r - 1].clone();
			}
			map[0] = new int[M];

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (map[i][j] == 1) {
						flag = false;
						break;
					}
				}
			}
			if (flag) {
				ans = Math.max(ans, tmp);
				break;
			}
		}
	}
}
