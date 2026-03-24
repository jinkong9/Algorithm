import java.io.*;
import java.util.*;
public class Main {
	static int C, arr[][], ans;
	static ArrayList <Integer> list;
	static boolean v[], v1[];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		C = Integer.parseInt(br.readLine());
		
		for(int tc = 0; tc < C; tc ++) {
			arr = new int[11][11];
			list = new ArrayList<>();
			
			for(int i=0; i<11; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j=0; j<11; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			v = new boolean [11];
			ans = 0;
			comb(0, 0);
			System.out.println(ans);
		}
	}

	static void comb(int idx, int a) {
		if(idx == 11) {
			ans = Math.max(ans, a);
			return;
		}
		
		for(int i= 0; i<11; i++) {
			if(!v[i]) {
				if(arr[idx][i] == 0) continue;
				v[i] = true;
				comb(idx +1, a + arr[idx][i]);
				v[i] = false;
			}
		}
	}
}
