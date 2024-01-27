package todayProblem.year2024.january;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//bfs dfs 로 푸는 문제를 그냥 그래프로 푼듯
public class ja22_16234_인구이동_G4_ {
    static int N, L, R, lastUnion;
    //static int[] sum;
    static int[][] A, border, sum;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // NxN 땅의 크기
        L = Integer.parseInt(st.nextToken()); // 인구 차이 범위 최소치 L
        R = Integer.parseInt(st.nextToken()); // 인구 차이 범위 최대치 R
        A = new int[N][N];                     // 위치에 해당하는 국가별 인구를 저장하는 배열
        int count = 0;                          // 인구 이동이 일어나는 횟수(출력값)

        //입력받기
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                A[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        //국경열리는지 탐색
        while(true){
            border = new int[N][N];
            sum = new int[N*N][2];
            lastUnion = 0;

            // 인구이동이 일어나지 않으면 종료
            if (!movePopulation()){
                break;
            }else count++; // 인구이동이 일어나면 count 증가

            //인구 이동후 상태 업데이트
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    // 인구이동 하는 동안 (연합의 인구 수) / (연합을 이루고 있는 칸의 개수) 로 인구수 업데이트
                    if (border[i][j] != 0){
                        A[i][j] = (int) Math.floor(sum[border[i][j]][0] / sum[border[i][j]][1]);
                    }
                }
            }
        }
        System.out.println(count);
    }

    public static boolean movePopulation(){
        boolean move = false; // 인구이동이 발생했는지의 여부

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int v;
                // 본인과 우측 국가 비교
                if (j != N - 1) {
                    v = Math.abs(A[i][j] - A[i][j+1]);
                    if (v <= R && v >= L ){
                        move = true;
                        if (border[i][j] == 0 && border[i][j+1] == 0){
                            border[i][j] = ++lastUnion;
                            border[i][j+1] = lastUnion;
                            sum[lastUnion][0] += A[i][j] + A[i][j+1];
                            sum[lastUnion][1] += 2;
                        }else if(border[i][j] != 0 && border[i][j+1] == 0){
                            border[i][j+1] = border[i][j];
                            sum[border[i][j]][0] += A[i][j+1];
                            sum[border[i][j]][1] += 1;
                        } else if (border[i][j] == 0 && border[i][j+1] != 0){
                            border[i][j] = border[i][j+1];
                            sum[border[i][j+1]][0] += A[i][j];
                            sum[border[i][j+1]][1] += 1;
                        } else if (border[i][j] != border[i][j+1]){
                            sum[border[i][j]][0] += sum[border[i][j+1]][0];
                            sum[border[i][j]][1] += sum[border[i][j+1]][1];
                            sum[border[i][j+1]][0] = 0;
                            sum[border[i][j+1]][1] = 0;
                            updateUnion(border[i][j], border[i][j+1]);
                        }
                    }
                }
                // 본인과 아래 국가 비교
                if (i != N-1){
                    v = Math.abs(A[i][j] - A[i+1][j]);
                    if (v <= R && v >= L){
                        move = true;
                        if (border[i][j] == 0){
                            border[i][j] = ++lastUnion;
                            border[i+1][j] = lastUnion;
                            sum[lastUnion][0] += A[i][j] + A[i+1][j];
                            sum[lastUnion][1] += 2;
                        }else {
                            border[i+1][j] = border[i][j];
                            sum[border[i][j]][0] += A[i+1][j];
                            sum[border[i][j]][1] += 1;
                        }
                    }
                }
            }
        }

        return move;
    }

    public static void updateUnion(int a, int b){
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (border[i][j] == b){
                    border[i][j] = a;
                }
            }
        }
    }
}
