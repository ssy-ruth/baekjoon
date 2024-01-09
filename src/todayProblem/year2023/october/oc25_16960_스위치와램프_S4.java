package todayProblem.year2023.october;

import java.util.Arrays;
import java.util.Scanner;

public class oc25_16960_스위치와램프_S4 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        int n=sc.nextInt();
        int m=sc.nextInt();
        String[][] lamp=new String[n+1][];
        for(int i=1;i<=n;i++) {
            int swch = sc.nextInt();
            if (swch==0){
                lamp[i] = ". .".split(" ");
            }else{
                lamp[i] = sc.nextLine().trim().split(" ");
            }
        }
        outer:
        for(int i=1;i<=n;i++){
            int isPossible=0;
            for (String s:lamp[i]) {
                inner:
                for(int j=1;j<=n;j++){
                    if(j!=i && Arrays.stream(lamp[j]).anyMatch(a-> a.equals(s))){
                        isPossible+=1;
                        break inner;
                    }
                }
            }
            if(isPossible == lamp[i].length){
                System.out.println(1);
                break outer;
            } else if (i==n) {
                System.out.println(0);
                break outer;
            }

        }
    }
}
