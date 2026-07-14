import java.io.*;
import java.util.*;

class Solution {
    static int len;
    static String str;
    static boolean v[];
    static HashSet <Integer> set = new HashSet<>();
    public int solution(String numbers) {
        int answer = 0;
        str = numbers;
        len = str.length();
        v = new boolean [len];
        int arr[] = new int[len];
        for(int i=0; i<len; i++ ) {
            arr[i] = str.charAt(i) - '0';
        }
        
        dfs(arr, "", 0);
        
        for(int i : set) {
            if(isPrime(i)) {
                answer ++;
            }
        }
        
        return answer;
    }
    
    public static void dfs(int arr[], String s, int idx) {
        if(s.length() > 0) {
                System.out.println(s);
                set.add(Integer.parseInt(s));    
        }
        
        for(int i=0; i<len; i++) {
            if(!v[i]) {
                v[i] = true;
                dfs(arr, s + arr[i], idx +1);
                v[i] = false;
            }
        }
        
    }
    public static boolean isPrime(int n) {
	    if (n <= 1) return false;
	    for (int i = 2; i <= Math.sqrt(n); i++) {
	        if (n % i == 0) return false;
	    }
	    return true;
	}
}