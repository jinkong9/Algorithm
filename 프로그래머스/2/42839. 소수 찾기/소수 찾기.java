import java.util.HashSet;
import java.util.Set;

class Solution {
    static Set<Integer> list = new HashSet<>();
    public int solution(String numbers) {
        int num[] = new int[numbers.length()];
		boolean[] v = new boolean[numbers.length()];
		
		for(int i=0; i<numbers.length(); i++) {
			num[i] = numbers.charAt(i) - '0';
		}
		dfs(num, "", v);
		
		int cnt=0;
		for (int n : list) {
			if(isPrime(n)) {
				cnt++;
			}
		}
        return cnt;
    }
    
    public static boolean isPrime(int n) {
	    if (n <= 1) return false;
	    for (int i = 2; i <= Math.sqrt(n); i++) {
	        if (n % i == 0) return false;
	    }
	    return true;
	}
	
	public static void dfs(int[] arr, String cur, boolean[] v) {
		if(cur.length() > 0) {
			list.add(Integer.parseInt(cur));
		}
		for(int i=0; i<arr.length; i++) {
			if(!v[i]) {
				v[i] = true;
				dfs(arr, cur+arr[i], v);
				v[i] = false;
			}
		}
		
	}
    
}