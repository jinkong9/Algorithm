
import java.io.*;
import java.util.*;
public class Main {
	static int cnt =0;
	static int A,B;
	static int arr[];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		arr = new int[A];
		StringTokenizer st1 = new StringTokenizer(br.readLine());
		for(int i=0; i<A; i++) {
			arr[i] = Integer.parseInt(st1.nextToken());
		}
		dfs(0,0);
		//합이 0이면 모든 경우 선택 X일때 0이 나옴
		if(B==0) cnt-=1;
		
		System.out.println(cnt);
	}
	
	static void dfs(int idx, int a) {
		if(idx == A) {
			if(a == B) cnt++;
			return;
		}
		// 선택하는 경우
		dfs(idx+1, a + arr[idx]);
		// 선택하지 안는 경우
		dfs(idx+1, a);
	}
}
