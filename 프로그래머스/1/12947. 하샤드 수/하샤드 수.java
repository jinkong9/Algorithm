class Solution {
    public boolean solution(int x) {
        boolean answer = true;
        String str = String.valueOf(x);
        String arr[] = new String[str.length()];
        arr = str.split("");
        int sum = 0;
        
        
        for(int i=0; i<arr.length; i++) {
            sum += Integer.parseInt(arr[i]);
        }

        if(sum == 0) return false;
        
        if(x % sum == 0) {
            answer = true;
        } else {
            answer = false;
        }
        
        return answer;
    }
}