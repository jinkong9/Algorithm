
import java.io.*;
import java.util.*;
public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int arr[] = new int[10001];
		int T = Integer.parseInt(br.readLine());
		for(int i=0; i<T; i++) {
			int a = Integer.parseInt(br.readLine());
			arr[a] ++;
		}
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<10001; i++) {
			while(arr[i] >0) {
				sb.append(i).append("\n");
				arr[i] --;
			}
		}
		System.out.print(sb);
	}

}
