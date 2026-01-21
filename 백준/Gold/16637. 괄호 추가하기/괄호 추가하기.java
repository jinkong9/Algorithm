import java.io.*;

public class Main {
	static int MaxSum = Integer.MIN_VALUE;
	static int	nums[];
	static char susik[];
	static int susikCnt;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String s = br.readLine();
		nums = new int[(N/2)+1];
		susik = new char[N/2];
		susikCnt = N/2;
		
		int numsIdx = 0;
		int susikIdx = 0;
		
		for(int i=0; i<N; i++) {
			char c = s.charAt(i);
			if(i % 2 == 0) {
				nums[numsIdx++] = c-'0';
			} else {
				susik[susikIdx++] = c;
			}
		}
		dfs(0, nums[0]);
		System.out.println(MaxSum);
	}
	
	public static int cal(int a, int b, char op) {
		if(op == '+') return a+b;
		if(op == '*') return a*b;
		if(op == '-') return a-b;
		return 0;
	}
	
	public static void dfs(int curSusikIdx, int curSum) {
		if(curSusikIdx >= susikCnt) {
			MaxSum = Math.max(MaxSum, curSum);
			return;
		}
		
		int res = cal(curSum,nums[curSusikIdx+1], susik[curSusikIdx]);
		dfs(curSusikIdx+1, res); //괄호 없음
		
		if(curSusikIdx +1 < susikCnt) { //괄호
			int tmp = cal(nums[curSusikIdx+1], nums[curSusikIdx+2], susik[curSusikIdx+1]);
			int res1 = cal(curSum, tmp, susik[curSusikIdx]);
			dfs(curSusikIdx +2, res1);
		}
	}
	
}
