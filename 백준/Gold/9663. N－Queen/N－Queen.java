
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int T;
	static int[] arr;
	static int cnt =0;
	static boolean [] y = new boolean[T];
	static boolean [] xy = new boolean[2*T];
	static boolean [] xyn1 = new boolean[2*T];
	public static void main(String[] args)throws IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		arr = new int[T];
		y = new boolean[T];
		xy = new boolean[2*T];
		xyn1 = new boolean[2*T];
		dfs(0);
		System.out.println(cnt);
	}
	
	static void dfs(int x) {
		if(x == T) {
			cnt++;
			return;
		}
		// y, x+y, x-y+T-1 경우 
		for(int i=0; i<T; i++) {
			if(y[i] || xy[x+i] || xyn1[x-i+T-1]) continue;
			
			y[i] = xy[x+i] = xyn1[x-i+T-1] = true;
			dfs(x+1);
			y[i] = xy[x+i] = xyn1[x-i+T-1] = false;
		}
	}

}
