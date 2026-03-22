import java.io.*;
import java.util.*;
public class Main {
	static int L,C;
	static char arr[];
    static char c[] = {'a', 'e', 'i', 'o', 'u'};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		L  = Integer.parseInt(st.nextToken());
		C  = Integer.parseInt(st.nextToken());
		arr = new char[C];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<C; i++) {
			arr[i] = st.nextToken().charAt(0);
		}
		Arrays.sort(arr);
		comb(0,0,new char[L]);
	}

	static void comb(int idx, int start, char sel[]) {
		if(idx == L) {
			check(sel);
			return;
		}
		
		for(int i = start; i<C; i++) {
			sel[idx] = arr[i];
			comb(idx+1, i+1, sel);
		}
	}
	static void check(char sel[]) {
		boolean f = false;
		int cnt2 = 0;
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < L; i++) {
			boolean f1 = false;
			for (char c : c) {
				if (sel[i] == c) {
					f = true;
					f1 = true;
					break;
				}
			}
			if(!f1) cnt2 ++;
			sb.append(sel[i]);
		}
		if (f && cnt2 >= 2) {
			System.out.println(sb);
		}
	}
}
