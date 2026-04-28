import java.io.*;
import java.util.*;
class Solution {
    static int B,Y;
    public int[] solution(int brown, int yellow) {
        B = brown;
        Y = yellow;
        int aa = B+Y;
        int a = 0;
        int b = 0;
        for(int w = aa-1; w > 0; w-- ) {
            if(aa % w != 0)  continue;
            
            int h = aa / w;
            int tt = (h -2) * (w -2);
            int ttt = aa - tt;
            
            if(tt == yellow && ttt == brown) {
                a = w;
                b = h;
            }
        }
        
        int answer[] = {b,a};
        return answer;
    }
}