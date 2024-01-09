package todayProblem.year2023.december;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class de18_9655_돌게임_S5 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        if (N%2==0)
            System.out.println("CY");
        else System.out.println("SK");
    }
}
