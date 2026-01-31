import java.io.*;
import java.util.*;

class Solution {
     public String solution(String number, int k) {
		StringBuilder answer = new StringBuilder();
		int len = number.length() - k;
		Stack<Character> list = new Stack<>();	
		
		
		for(int i=0; i<number.length(); i++) {
			char a = number.charAt(i);
			while(!list.isEmpty() && k >0 && list.peek() < a) {
				list.pop();
				k--;
			}
			list.push(number.charAt(i));
		}
		
		for(int i=0; i<len; i++) {
			answer.append(list.get(i));
		}
         
        return answer.toString();
	}
}