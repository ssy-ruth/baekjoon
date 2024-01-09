package todayProblem.year2023.november;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class no29_16967_배열복원하기_S3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer input = new StringTokenizer(br.readLine());
        int H = Integer.parseInt(input.nextToken());
        int W = Integer.parseInt(input.nextToken());
        int X = Integer.parseInt(input.nextToken());
        int Y = Integer.parseInt(input.nextToken());
        int[][] A=new int[H+X+1][W+Y+1];
        int[][] B=new int[H+X+1][W+Y+1];

        for (int i=1;i<=H+X;i++){
            StringTokenizer bInput = new StringTokenizer(br.readLine());
            for (int j = 1; j <= W + Y; j++) {
                int element=Integer.parseInt(bInput.nextToken());
                B[i][j]=element;

                if (i<=X && j<=W){//안겹쳐서 순수A인곳
                    A[i][j]=element;
                }else if(j<=Y && i<=H){//안겹쳐서 순수A인곳
                    A[i][j]=element;
                }
            }

        }
        for (int i = X+1; i <= H; i++) {
            for (int j = Y+1; j <= W+Y; j++) {
                A[i][j]=B[i][j]-A[i-X][j-Y];
            }
        }


        for (int i = 1; i <= H; i++) {
            for (int j = 1; j <= W; j++) {
                System.out.print(A[i][j]+" ");
            }
            System.out.println();
        }
    }
}
