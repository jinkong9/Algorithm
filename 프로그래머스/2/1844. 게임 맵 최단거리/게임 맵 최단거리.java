import java.util.*;

class Solution {
    private static final int[] dx = {0, 0, -1, 1};
    private static final int[] dy = {-1, 1, 0 ,0};
    
    public int solution(int[][] maps) {
        int n = maps.length;
        int m = maps[0].length;
        boolean[][] visted = new boolean[n][m];
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0,0,1});
        visted[0][0] = true;
        
        while(!q.isEmpty()){
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];
            int cnt = cur[2];
            
            if(x == n-1 && y == m-1){
                return cnt;
            }
            
            for(int i =0; i<4; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];
            
            
            if(nx >=0 && ny >= 0 && nx < n && ny < m && maps[nx][ny] == 1 && !visted[nx][ny]){
                visted[nx][ny] = true;
                q.add(new int[]{nx, ny, cnt+1});
            }
            }
        }
        return -1;
    }
}