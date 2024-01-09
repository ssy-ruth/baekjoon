package todayProblem.year2023.december;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class de06_1018_체스판다시칠하기_S4 {
    private static String[] startW = {"W", "B", "W", "B", "W", "B", "W", "B"};
    private static String[] startB = {"B", "W", "B", "W", "B", "W", "B", "W"};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer input0 = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(input0.nextToken());
        int M = Integer.parseInt(input0.nextToken());
        int[][] cases = new int[N-7][M-7];
        String[][] board = new String[N][M];

        for (int i = 0; i < N; i++) {
            board[i] = br.readLine().split("");
        }

        int min=-1;
        for (int i = 0; i < N - 7; i++) {
            for (int j = 0; j < M - 7; j++) {
                String[][] copyBd = new String[8][8];
                for (int k = 0; k < 8; k++) {
                    System.arraycopy(board[i+k],j,copyBd[k],0,8);
                }
                cases[i][j] = checkDifference(copyBd);
                if (min==-1){
                    min=cases[i][j];
                }
                if (min>cases[i][j]){
                    min=cases[i][j];
                }
            }
        }
        System.out.println(min);
    }

    public static int checkDifference(String[][] arr){
        int countW=0, countB=0;

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (!arr[i][j].equals(startW[j])){
                    if (i%2==0){
                        countW+=1;
                    }else {
                        countB+=1;
                    }
                }
                if(!arr[i][j].equals(startB[j])){
                    if (i%2==0){
                        countB+=1;
                    }else {
                        countW+=1;
                    }
                }
            }
        }

        return Math.min(countW, countB);
    }
}
