class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        
        int sum = brown + yellow;
        
        for(int i=3; i<sum / 2; i++) {
            int col = i;
            int row = sum / i;
            
            if((col - 2) * (row - 2) == yellow) {
                answer[0] = col;
                answer[1] = row;
            }
        }        
        return answer;
    }
}