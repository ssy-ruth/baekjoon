package todayProblem.year2023.october;

import java.util.Scanner;

public class oc19_21920_서로소평균_S4 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] a=new int[n];
        for(int i=0;i<n;i++){
            a[i]=sc.nextInt();
        }
        int x= sc.nextInt();
        System.out.print(CheckCoprime(a,x));
    }
    public static int CheckCoprime(int[] a, int xx){
        int result=0;
        int countCop=0;
        for (int nu:a) {
            //최대공약수 구하기
            int gcd=0;
            int num=nu;
            int x=xx;
            if(num>x){
                outer:
                while (x!=0){
                    gcd=num%x;
                    if(gcd==0) {
                        if(x==1){
                            result+=nu;
                            countCop++;
                        }
                        break outer;
                    }else{
                        num=x;
                        x=gcd;
                    }
                }
            }else{
                outer:
                while(num!=0){
                    gcd=x%num;
                    if(gcd==0) {
                        if(num==1){
                            result+=nu;
                            countCop++;
                        }
                        break outer;
                    }else{
                        x=num;
                        num=gcd;
                    }
                }
            }
        }
        return result/countCop;
    }
}
