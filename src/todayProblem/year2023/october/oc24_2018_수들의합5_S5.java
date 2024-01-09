package todayProblem.year2023.october;

import java.util.Scanner;

public class oc24_2018_수들의합5_S5 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        int n=sc.nextInt();
        int count=0;
        for(int i=1;i<=n;i+=2){
            if(n%i==0)
                count++;
        }
        System.out.println(count);
    }
}
