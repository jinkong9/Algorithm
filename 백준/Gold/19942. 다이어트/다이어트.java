import java.io.*;
import java.util.*;

public class Main {
	static int N, basic[], arr[][], ans;
	static boolean f;
	static ArrayList<Integer> list;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		basic = new int[4];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < 4; i++) {
			basic[i] = Integer.parseInt(st.nextToken());
		}
		arr = new int[N][5];
		list = new ArrayList<>();
		f = true;
		// 단백질 지방 탄수 비타민 가격 순
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 5; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		ans = Integer.MAX_VALUE;
		for (int i = 1; i <= N; i++) {
			comb(0, 0, new int[i]);
		}
		StringBuilder sb = new StringBuilder();
		if (list.size() == 0) {
			System.out.println(-1);
			return;
		}
		sb.append(ans).append("\n");
		for (int i : list)
			sb.append(i + 1).append(" ");
		System.out.println(sb);
	}

	static void comb(int idx, int start, int sel[]) {
		if (idx == sel.length) {
			check(sel);
			return;
		}

		for (int i = start; i < N; i++) {
			sel[idx] = i;
			comb(idx + 1, i + 1, sel);
		}
	}

	static void check(int sel[]) {
		int a = 0;
		int b = 0;
		int c = 0;
		int d = 0;
		int sum = 0;
		for (int i = 0; i < sel.length; i++) { // 선택할 인덱스
			a += arr[sel[i]][0];
			b += arr[sel[i]][1];
			c += arr[sel[i]][2];
			d += arr[sel[i]][3];
			sum += arr[sel[i]][4];
		}
		if (a >= basic[0] && b >= basic[1] && c >= basic[2] && d >= basic[3]) {
			if (ans > sum) {
				list.clear();
				for (int i = 0; i < sel.length; i++)
					list.add(sel[i]);
				ans = sum;
			} else if (ans == sum) {
				// 사전순 비교
				int m = Math.min(list.size(), sel.length);
				boolean f = false;
				for (int i = 0; i < m; i++) {
					if (sel[i] < list.get(i)) {
						f = true;
						break;
					} else if (sel[i] > list.get(i))
						return;
				}
				if (!f && sel.length >= list.size())
					return;

				list.clear();
				for (int i = 0; i < sel.length; i++)
					list.add(sel[i]);
			}
		}
	}
}
