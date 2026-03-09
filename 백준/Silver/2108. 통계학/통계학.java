
import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int arr[] = new int[8001];
		
		long sum = 0; // 안전하게 long 사용
		int mid = 10000; // 0이 중앙값일 때를 대비해 범위 밖으로 초기화
		int most = 0; 
		int range = 0;
		int max = Integer.MIN_VALUE; // 초기값 수정
		int min = Integer.MAX_VALUE;
		int fre = 0;
		int cnt = 0; 
		boolean first = true;

		for(int i=0; i<N; i++) {
			int a = Integer.parseInt(br.readLine());
			sum += a;
			arr[a + 4000] ++;
			max = Math.max(max, a);
			min = Math.min(min, a);
		}
		
		int avg = (int)Math.round((double)sum / N);
		
		// 1. 최빈값의 빈도수(fre) 먼저 찾기
		for(int i=0; i<8001; i++) {
			if(arr[i] > fre) {
				fre = arr[i];
			}
		}
		
		// 2. 중앙값과 최빈값 결정
		for(int i=0; i<8001; i++) {
			if(arr[i] > 0) {
				int val = i - 4000;
				
				// 중앙값: 누적 개수가 중앙에 도달하면 딱 한 번만 저장
				cnt += arr[i];
				if(cnt >= (N+1)/2 && mid == 10000) {
					mid = val;
				}
				
				// 최빈값: 두 번째 작은 값을 찾기 위한 로직
				if(arr[i] == fre) {
					if(first) {
						most = val;
						first = false; // 첫 번째 찾음
					} else {
						most = val;
						fre = -1; // 두 번째 찾았으므로 더 이상 갱신 안 되게 차단
					}
				}
			}
		}
		range = max - min;
		
		System.out.println(avg);
		System.out.println(mid);
		System.out.println(most);
		System.out.println(range);
	}
}