package todayProblem.year2025;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class nov28_6198_옥상정원꾸미기_G5 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        long result =0;

        for (int i = 0; i < N; i++) {
            arr[i]=Integer.parseInt(br.readLine());
        }

        for (int i = 0; i < N; i++) {
            for (int j = i+1; j < N; j++) {
                if (arr[i]>arr[j]) {
                    result+=1;
                }else break;
            }
        }
        System.out.println(result);
    }
}
