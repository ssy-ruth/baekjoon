package todayProblem.year2023.december;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class de27_11047_동전0_S4 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer sr = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(sr.nextToken());//동전의 종류
        int K = Integer.parseInt(sr.nextToken());//계산 금액
        int[] coins = new int[N];
        int sumK = 0;//K와 똑같은 금액을 만들 변수
        int count = 0;//필요한 동전 개수 세기
        int start = 0;//그리디 계산 시작할 동전의 가치

        for (int i = 0; i < N; i++) {
            coins[i] = Integer.parseInt(br.readLine());
            if (coins[i] > K){
                start = i;
                break;
            }
        }
        if (start==0)
            start=N;


        outer:
        for (int i = start-1; i >= 0; i--) {
            int coin = coins[i];

            if (sumK == K)
                break outer;
            inner:
            while (true){
                if (K >= sumK+coin){
                    sumK+=coin;
                    count+=1;
                }else{
                    break inner;
                }
            }
        }
        if (sumK==K)
            System.out.println(count);
    }
}
