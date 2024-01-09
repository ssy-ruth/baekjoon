package todayProblem.year2023.december;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class de04_1475_방번호_S5 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer input = new StringTokenizer(br.readLine());
        String number = input.nextToken();

        int[] count = new int[10];
        int max = 0;
        for (String i :
                number.split("")) {
            int a = Integer.parseInt(i);

            if (a == 6 || a == 9) {
                count[9] += 1;

                int b = count[9];
                if (count[9] % 2 != 0) {
                    b += 1;
                }

                if (max < b / 2) {
                    max = b / 2;
                }
            } else {
                count[a] += 1;
                if (max < count[a]) {
                    max = count[a];
                }
            }
        }

        System.out.println(max);
    }
}
