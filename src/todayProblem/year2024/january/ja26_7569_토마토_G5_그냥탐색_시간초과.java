package todayProblem.year2024.january;

import java.util.*;
import java.io.*;

public class ja26_7569_토마토_G5_그냥탐색_시간초과 {
    static int[][][] box, cloneBox; // box는 입력받는 토마토 상태의 상자, clonebox는 하루 지난 뒤 상태의 상자야
    static int N, M, H, oldDays; // N은 상자의 세로, M은 상자의 가로, H는 쌓아올려지는 상자의 개수, oldDays는 토마토가 익는데 지나는 날짜들을 세는 변수야
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        oldDays = 0;
        box = new int[H][N][M];
        cloneBox = new int[H][N][M];
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < M; k++) {
                    box[i][j][k] = Integer.parseInt(st.nextToken());
                }
            }
        }

        while(true){
            if (day()){ // 하루가 지나면서 토마토들이 익을때, 모두 익은 토마토라면 oldDays를 출력하고 종료
                System.out.println(oldDays);
                break;
            }else {
                boolean isSame = true; // 기존 box와 하루동안 토마토가 익은 cloneBox가 같은지 확인하는 변수

                for (int i = 0; i < H; i++) {
                    for (int j = 0; j < N; j++) {
                        for (int k = 0; k < M; k++) {
                            if (box[i][j][k] != cloneBox[i][j][k]){ // 기존 box와 다르다면 isSame을 false로 바꿈
                                isSame = false;
                            }
                            box[i][j][k] = cloneBox[i][j][k]; // 변화 결과인 cloneBox를 box에 깊은 복사함. 다음날 또 변화할 것이기 때문
                        }
                    }
                }
                if (isSame == true){ // box와 cloneBox가 같다면 앞으로 시간이 더 지나도 익지 않는 토마토들이 있기 때문에 -1을 출력하고 종료
                    System.out.println(-1);
                    break;
                }
                oldDays += 1; // 토마토가 익는 날짜수 증가
            }
        }

    }
    public static boolean day(){
        boolean noZero = true; // 0이 없는지 표시하는 변수

        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    if (cloneBox[i][j][k] != 1 && cloneBox[i][j][k] != box[i][j][k]){
                        cloneBox[i][j][k] = box[i][j][k];
                    }
                    switch (box[i][j][k]){
                        case 0:
                            noZero = false; // 익지 않은 토마토가 있다면 noZero 변수를 true로 바꿈
                            break;
                        case 1: // 익은 토마토라면 주변 익지 않은 토마토들을 변화시킴.
                            // z축
                            if (i == 0){
                                if (H != 1){
                                    if (box[i+1][j][k] == 0){
                                        cloneBox[i+1][j][k] = 1;
                                    }
                                }
                            } else if (i == H-1) {
                                if (box[i-1][j][k] == 0){
                                    cloneBox[i-1][j][k] = 1;
                                }
                            }else{
                                if (box[i+1][j][k] == 0){
                                    cloneBox[i+1][j][k] = 1;
                                }
                                if (box[i-1][j][k] == 0){
                                    cloneBox[i-1][j][k] = 1;
                                }
                            }
                            // y축
                            if (j == 0){
                                if (N != 1){
                                    if (box[i][j+1][k] == 0){
                                        cloneBox[i][j+1][k] = 1;
                                    }
                                }
                            } else if (j == N-1) {
                                if (box[i][j-1][k] == 0){
                                    cloneBox[i][j-1][k] = 1;
                                }
                            }else{
                                if (box[i][j+1][k] == 0){
                                    cloneBox[i][j+1][k] = 1;
                                }
                                if (box[i][j-1][k] == 0){
                                    cloneBox[i][j-1][k] = 1;
                                }
                            }
                            // x축
                            if (k == 0){
                                if (M != 1){
                                    if (box[i][j][k+1] == 0){
                                        cloneBox[i][j][k+1] = 1;
                                    }
                                }
                            } else if (k == M-1) {
                                if (box[i][j][k-1] == 0){
                                    cloneBox[i][j][k-1] = 1;
                                }
                            }else{
                                if (box[i][j][k+1] == 0){
                                    cloneBox[i][j][k+1] = 1;
                                }
                                if (box[i][j][k-1] == 0){
                                    cloneBox[i][j][k-1] = 1;
                                }
                            }
                            break;
                        default: break;
                    }
                }
            }
        }

        return noZero; // 모두 익었는지 여부 리턴
    }
}
