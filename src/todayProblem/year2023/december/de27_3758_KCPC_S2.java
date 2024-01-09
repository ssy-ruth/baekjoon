package todayProblem.year2023.december;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class de27_3758_KCPC_S2 {
    static int N, K, M, n, k;
    static int[] rank, lastSubmit;
    static int[][] currentScore;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken()); //팀 개수
            K = Integer.parseInt(st.nextToken()); //문제 개수
            int myId = Integer.parseInt(st.nextToken()); //당신 팀Id
            M = Integer.parseInt(st.nextToken()); //로그 개수
            currentScore = new int[N+1][K+2]; //팀별 문제당 최고 점수, 팀별 총합, 팀별 제출횟수
            rank = new int[N+1]; //팀별 등수
            lastSubmit = new int[N+1]; //마지막 제출 시기

            for (int j = 0; j < M; j++) {
                StringTokenizer stn = new StringTokenizer(br.readLine());
                n = Integer.parseInt(stn.nextToken()); //팀
                k = Integer.parseInt(stn.nextToken()); //문제
                int score = Integer.parseInt(stn.nextToken()); //점수

                if (currentScore[n][k] < score){ //그 문제에 대한 최고점수만 저장
                    currentScore[n][0] -= currentScore[n][k]; //업데이트 전 점수 합산에서 제외
                    currentScore[n][k] = score; //문제에 점수 입력
                    currentScore[n][0] += score; //팀 총합에 점수 합산
                }
                currentScore[n][K+1] += 1; //제출횟수 증가
                lastSubmit[n] = j;
                updateRank();
            }
            System.out.println(rank[myId]);
        }
    }

    public static void updateRank(){
        int bigCount;

        outer:
        for (int i = 1; i <= N; i++) {
            bigCount = 1;
            inner:
            for (int j = 1; j <= N; j++) {
                if (i == j){
                    continue inner;
                }
                if (currentScore[j][0] > currentScore[i][0]){
                    bigCount += 1; // 순위 감소
                } else if (currentScore[j][0] == currentScore[i][0]) {
                    if (currentScore[j][K+1] < currentScore[i][K+1]){ //총점이 같은데 제출횟수가 더 많으면
                        bigCount += 1; // 순위 감소
                    } else if (currentScore[j][K+1] == currentScore[i][K+1] && lastSubmit[j] < lastSubmit[i]) {
                        //제출횟수도 같은데 마지막 제출시간이 더 느리면
                        bigCount += 1; // 순위 감소
                    }
                }
            }
            rank[i] = bigCount;
        }
    }
}
