import java.io.*;
public class Main {
        static char arr[][];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while(true) {
            arr = new char[3][3];
            int idx = 0;
            int xcnt = 0;
            int ocnt = 0;
            String s = br.readLine();
            if(s.equals("end")) break;
            for(int i=0; i<3; i++) {
                for(int j=0; j<3; j++) {
                    arr[i][j] = s.charAt(idx++);
                    if(arr[i][j] == 'X') xcnt ++;
                    if(arr[i][j] == 'O') ocnt ++;
                }
            }
            boolean f = check(xcnt, ocnt);
            if(f) sb.append("valid").append("\n");
            else sb.append("invalid").append("\n");
        }
        System.out.println(sb);
    }

    static boolean check(int xcnt, int ocnt) {
        boolean xWin = false;
        boolean oWin = false;

        // 가로
        for(int i=0; i<3; i++) {
            if(arr[i][0] == arr[i][1] && arr[i][1] == arr[i][2] && arr[i][0] != '.') {
                if(arr[i][0] == 'X') xWin = true;
                else oWin = true;
            }
        }

        // 세로
        for(int i=0; i<3; i++) {
            if(arr[0][i] == arr[1][i] && arr[1][i] == arr[2][i] && arr[0][i] != '.') {
                if(arr[0][i] == 'X') xWin = true;
                else oWin = true;
            }
        }

        // 대각선
        if(arr[0][0] == arr[1][1] && arr[1][1] == arr[2][2] && arr[0][0] != '.') {
            if(arr[0][0] == 'X') xWin = true;
            else oWin = true;
        }

        if(arr[0][2] == arr[1][1] && arr[1][1] == arr[2][0] && arr[0][2] != '.') {
            if(arr[0][2] == 'X') xWin = true;
            else oWin = true;
        }
        if(xcnt < ocnt) return false;
        if(xcnt > ocnt + 1) return false;
        if(xWin && oWin) return false;
        if(xWin && xcnt != ocnt + 1) return false;
        if(oWin && xcnt != ocnt) return false;
        if(!xWin && !oWin && xcnt + ocnt != 9) return false;

        return true;
    }
}

