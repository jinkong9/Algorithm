class Solution {
    public int solution(int a, int b, int n) {
        int answer = 0;
        int tmp1 = 0; // 되돌려받음
        int tmp2 = 0; // 나머지
        int sum = n;
        while(true) {
            if(sum < a) break;
            tmp1 = (sum / a) * b;
            tmp2 = sum % a;
            sum = tmp1 + tmp2;
            answer += tmp1;
        }
        
        return answer;
    }
}