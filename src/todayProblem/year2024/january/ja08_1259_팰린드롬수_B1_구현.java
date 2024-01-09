package todayProblem.year2024.january;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ja08_1259_팰린드롬수_B1_구현 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while(true){
            String x = br.readLine();
            String output = "yes";
            if (x.equals("0")) break;

            int start = 0;
            int end = x.length() - 1;

            while (start <= end) {
                if (x.charAt(start) != x.charAt(end)) {
                    output = "no";
                    break;
                }

                start++;
                end--;
            }
            sb.append(output).append("\n");
        }
        System.out.println(sb);
    }
}
