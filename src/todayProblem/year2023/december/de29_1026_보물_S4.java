package todayProblem.year2023.december;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class de29_1026_보물_S4 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer a = new StringTokenizer(br.readLine());
        StringTokenizer b = new StringTokenizer(br.readLine());
        int result = 0;

        List<Integer> A = new ArrayList<>();
        List<Integer> B = new ArrayList<>();

        for (int i = 0; i <N; i++) {
            A.add(Integer.parseInt(a.nextToken()));
            B.add(Integer.parseInt(b.nextToken()));
        }

        Collections.sort(A);
        Collections.sort(B);


        for (int i = 0; i < N; i++) {
            result += A.get(i) * B.get(N-i-1);
        }

        System.out.println(result);
    }
}
