package todayProblem.year2023.november;

import java.util.Scanner;

public class no03_15489_파스칼삼각형_S4 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int R=sc.nextInt();
        int C= sc.nextInt();
        int W= sc.nextInt();
        int[][] triangle=new int [R+W][C+W];
        
        for (int i = 1; i < R+W; i++) {
            for (int j = 1; j < C+W; j++) {
                if (i<=2&&j<=i)
                    triangle[i][j]=1;
                else if (j==1||j==i) {
                    triangle[i][j]=1;
                }else if(j>i){
                    triangle[i][j]=0;
                }else{
                    triangle[i][j]=triangle[i-1][j-1]+triangle[i-1][j];
                }
            }
        }

        int result=0;
        for (int i = 0; i < W; i++) {
            int I=i+R;
            for (int j = 0; j <= i; j++) {
                int J=j+C;
                if (J<=I){
                    result+=triangle[I][J];
                }
            }
        }
        System.out.println(result);
    }
}
