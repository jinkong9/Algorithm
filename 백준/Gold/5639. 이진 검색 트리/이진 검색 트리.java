
import java.io.*;
import java.util.*;

public class Main {
    static ArrayList<Integer> list = new ArrayList<>();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s;
        while ((s = br.readLine()) != null && !s.isEmpty()) {
            list.add(Integer.parseInt(s));
        }

        dfs(0, list.size() - 1);
        System.out.print(sb);
    }

    static void dfs(int start, int end) {
        if (start > end) return;

        int root = list.get(start);
        
        int low = start + 1;
        int high = end;
        int idx = start + 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (list.get(mid) < root) {
                idx = mid + 1;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        dfs(start + 1, idx - 1);
        dfs(idx, end);
        sb.append(root).append('\n');
    }
}