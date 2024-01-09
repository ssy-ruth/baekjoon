package todayProblem.year2023.november;

import java.util.Scanner;

public class no01_7568_덩치_S5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] weight=new int[n];
        int[] height=new int[n];

        for (int i = 0; i < n; i++) {
            weight[i]=sc.nextInt();
            height[i]=sc.nextInt();
        }

        int big;//나보다 큰등수 카운트
        for (int i = 0; i < n; i++) {
            big=0;
            for (int j = 0; j < n; j++) {
                if(i==j)
                    j++;
                if(j==n)
                    break;
                if (weight[i] < weight[j] && height[i] < height[j]) {
                    big+=1;
                }
            }
            System.out.print(big+1);
            System.out.print(" ");
        }
    }
}
