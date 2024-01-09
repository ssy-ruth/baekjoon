package todayProblem.year2023.october;

import java.util.Arrays;
import java.util.Scanner;

public class oc23_3040_백설공주와일곱난쟁이_B2 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        Integer[] ip = new Integer[9];
        int count=0;
        for(int i=0; i<9; i++){
            ip[i]=sc.nextInt();
            count+=ip[i];
        }
        final int gap=count -100;


        for(int j=0;j<ip.length;j++){
            int i=ip[j];
            ip[j]=200;
            if(Arrays.stream(ip).anyMatch(a->a==gap-i)){
                ip[j]=i;
                continue;
            }else{
                ip[j]=i;
                System.out.println(i);
            }
        }
    }

}
