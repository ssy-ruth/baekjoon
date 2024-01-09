package todayProblem.year2023.november;

import java.util.Scanner;

public class no02_1010_다리놓기_S5 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        int T=sc.nextInt();
        int[] n=new int[T];
        int[] m=new int[T];

        for (int i = 0; i < T; i++) {
            n[i]=sc.nextInt();
            m[i]=sc.nextInt();
        }
        for (int i = 0; i < T; i++) {
            System.out.println(Math.round(ncr(m[i], n[i])));
        }
    }
    public static double ncr(int n, int r){
        double np=1,rp=1,nrp=1;
        for (int i = 1; i <= n; i++) {
            np*=i;
        }
        for (int i = 1; i <= r; i++) {
            rp*=i;
        }
        for (int i = 1; i <= n - r; i++) {
            nrp*=i;
        }
        return np/(rp*nrp);
    }
}
