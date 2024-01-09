package todayProblem.year2023.december;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class de05_9012_괄호_S4 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer input0 = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(input0.nextToken());

        for (int i = 0; i < N; i++) {
            StringTokenizer input = new StringTokenizer(br.readLine());
            int countO =0;
            int countC =0;
            int failed =0;

            for (String a : input.nextToken().split("")) {
                if (a.equals("(")){
                    countO+=1;
                } else if (a.equals(")") && countO>countC) {
                    countC+=1;
                }else {
                    failed+=1;
                }
            }

            if ((countO==countC) && (failed==0)){
                System.out.println("YES");
            }else {
                System.out.println("NO");
            }
        }
    }
}
