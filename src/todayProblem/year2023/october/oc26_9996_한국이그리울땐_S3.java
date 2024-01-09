package todayProblem.year2023.october;

import java.util.Scanner;

public class oc26_9996_한국이그리울땐_S3 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        int n=Integer.parseInt(sc.nextLine());
        String rg="";

        String[] pt=sc.nextLine().split("");

        String alph="[a-z]";
        for (String a:pt) {
            if(a.matches(alph)){
                rg=rg+a;
            } else if (a.equals("*")) {
                rg=rg+"[a-z]*";
            }
        }

        for(int i=0;i<n;i++){
            String ip=sc.nextLine();
            if(ip.matches(rg))
                System.out.println("DA");
            else
                System.out.println("NE");
        }
        sc.close();
    }
}
