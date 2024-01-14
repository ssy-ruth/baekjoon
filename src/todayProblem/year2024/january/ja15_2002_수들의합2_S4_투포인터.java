package todayProblem.year2024.january;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ja15_2002_수들의합2_S4_투포인터 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] A = new int[N+1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        int count = 0, sum = 0;
        int start = 1, end = 1;
        while(true){
            if (end > N){
                sum = 0;
                start += 1;
                end = start;
            }
            if (start > N){
                break;
            }
            sum += A[end];
            if (sum == M){
                count += 1;
            }
            end += 1;
        }
        System.out.println(count);
    }
}
