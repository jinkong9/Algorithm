class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        
        int idx1 = 0;
        int idx2 = 1;
        int cnt = 0;
        while(idx1 != prices.length - 1) {
            cnt ++;
            if(idx2 == prices.length -1 || prices[idx1] > prices[idx2]) {
                answer[idx1] = cnt;
                idx1 ++;
                idx2 = idx1 + 1;
                cnt = 0;
            } else {
                idx2 ++;
            }
        }

        return answer;
    }
}