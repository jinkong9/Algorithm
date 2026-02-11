
import java.io.*;
import java.util.*;

public class Solution {

    static int N, X, M;
    static int[] arr;
    static int[] ans;
    static int[][] arr1;
    static int max;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
        	StringBuilder sb= new StringBuilder();
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            X = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            arr = new int[N];
            ans = new int[N];
            arr1 = new int[M][3];
            max = -1;

            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                arr1[i][0] = Integer.parseInt(st.nextToken()) - 1;
                arr1[i][1] = Integer.parseInt(st.nextToken()) - 1;
                arr1[i][2] = Integer.parseInt(st.nextToken());
            }

            dfs(0);

            sb.append("#").append(tc).append(" ");
            if (max == -1) {
                sb.append(-1).append('\n');
            } else {
                for (int i = 0; i < N; i++) {
                    sb.append(ans[i]).append(' ');
                }
                sb.append('\n');
            }
            System.out.print(sb);
        }
    }

    static void dfs(int idx) {
        if (idx == N) {
            if (check()) {
                int sum = 0;
                for (int i = 0; i < N; i++) sum += arr[i];
                if (sum > max) {
                    max = sum;
                    ans = arr.clone();
                } 
            }
            return;
        }

        for (int i = 0; i <= X; i++) {
        	arr[idx] = i;
            dfs(idx + 1);
        }
    }

    static boolean check() {
        for (int i = 0; i < M; i++) {
            int sum = 0;
            for (int j = arr1[i][0]; j <= arr1[i][1]; j++) {
                sum += arr[j];
            }
            if (sum != arr1[i][2]) return false;
        }
        return true;
    }
    
}
