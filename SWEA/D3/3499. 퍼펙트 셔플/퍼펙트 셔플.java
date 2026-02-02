
import java.io.*;
import java.util.*;

public class Solution {
	public static void main(String[] args) throws IOException {
		Queue<String> list1 = new ArrayDeque<>();
		Queue<String> list2 = new ArrayDeque<>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=T; tc++) {
			int N = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			int Alllen = st.countTokens();
			int len1;
			int len2;
			if(Alllen % 2 == 0) {
				len1 = Alllen/2;
				len2 = Alllen/2;
			} else {
				len1 = Alllen /2+1;
				len2 = Alllen /2;
			}
			
			for(int i=0; i<len1; i++) {
				list1.offer(st.nextToken());
			}
			for(int i=0; i<len2; i++) {
				list2.offer(st.nextToken());
			}
			sb.append("#").append(tc).append(" ");
			if(Alllen % 2 == 0) {
				for(int i=0; i<len2; i++) {
					sb.append(list1.poll()).append(' ');
					sb.append(list2.poll()).append(' ');
				}
			} else {
				for(int i=0; i<len2; i++) {
					sb.append(list1.poll()).append(' ');
					sb.append(list2.poll()).append(' ');
				}
				sb.append(list1.poll());
			}
			sb.append('\n');
		}
		System.out.println(sb);
	}
}
