package todayProblem.year2023.october;

import java.util.Scanner;

public class oc27_1668_트로피진열_B2 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        int n=sc.nextInt();
        int last=0;
        int visible=0;
        int[] ip=new int[n];
        for (int i = 0; i < n; i++) {
            int next=sc.nextInt();
            ip[i]=next;
            if(last<next) {
                last = next;
                visible += 1;
            }
        }
        System.out.println(visible);
        last=0;
        visible=0;
        for (int i = n-1; i >=0 ; i--) {
            if(last<ip[i]){
                last=ip[i];
                visible+=1;
            }
        }
        System.out.println(visible);
    }
}
