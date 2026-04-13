import java.io.*;
import java.util.*;
public class Main {
	static String T,P;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = br.readLine();
		P = br.readLine();
		KMP(T,P);
	}

	static int[] makeLPS(String p) {
		int [] lps = new int[p.length()];
		int j =0;
		
		for(int i=1; i<p.length(); i++) {
			while(j >0 && p.charAt(i) != p.charAt(j)) {
				j = lps[j-1];
			}
			if(p.charAt(i) == p.charAt(j)) {
				lps[i] = ++j;
			}
		}
		return lps;
	}
	
	static void KMP(String t, String p) {
		int lps[] = makeLPS(p);
		int j=0;
		
		ArrayList<Integer> list = new ArrayList<>();
		
		for(int i=0; i<t.length(); i++) {
			while(j > 0 && t.charAt(i) != p.charAt(j)) {
				j = lps[j-1];
			}
			if(t.charAt(i) == p.charAt(j)) {
				if(j == p.length() -1) {
					list.add(i-j+1);
					j = lps[j];
				} else {
					j ++;
				}
			}
		}
		System.out.println(list.size());
		for(int i : list) {
			System.out.print(i + " ");
		}
	}
}
