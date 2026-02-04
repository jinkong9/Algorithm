
import java.io.*;
import java.util.*;
public class Solution {
	static int arr2[] = new int[9];
	static int arr1[] = new int[9];
	static boolean v[];
	static int max;
	static int Kwin, Iwin;
	static boolean va[] = new boolean[9];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int tc =1; tc<=T; tc++) {
			v  = new boolean[19];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i=0; i<9; i++) {
				int A = Integer.parseInt(st.nextToken());
				arr1[i] = A;
				v[A] = true;
			}
			int idx =0;
			for(int i=1; i<19; i++) {
				if(!v[i]) {
					arr2[idx++] = i;
				}
			}
			Kwin = Iwin = 0;
			win(0,0,0);
			System.out.println("#" +tc + " " +Kwin + " " + Iwin);
		}
	}
	static void win(int idx, int K, int I) {
		if(idx == 9) {
			if(K >I) {
				Kwin ++;
			} else if (K<I) {
				Iwin++;
			}
			return;
		}
		for(int i=0; i<9; i++) {
			if(!va[i]) {
				va[i] = true;
			
			int k = arr1[idx];
			int y = arr2[i];
			if(k > y) {
				win(idx+1, K+k+y, I);
			} else {
				win(idx+1, K, I+k+y);
			}
			va[i] = false;
			}
		}
		
	}

}
