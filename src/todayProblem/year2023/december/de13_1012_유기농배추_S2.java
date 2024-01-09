package todayProblem.year2023.december;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class de13_1012_유기농배추_S2 {
    static int[][] map;
    static int count;
    static int M, N;

    public static void main(String[] args) throws IOException {
        BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            StringTokenizer input = new StringTokenizer(br.readLine());
            M = Integer.parseInt(input.nextToken());
            N = Integer.parseInt(input.nextToken());
            int cabbage = Integer.parseInt(input.nextToken());
            count=0;
            map = new int[M][N];

            for (int j = 0; j < cabbage; j++) {
                StringTokenizer input0 = new StringTokenizer(br.readLine());
                int m = Integer.parseInt(input0.nextToken());
                int n = Integer.parseInt(input0.nextToken());

                checkGroup(m, n);
            }
            System.out.println(count);
            for (int j = 0; j < M; j++) {
                System.out.println(Arrays.toString(map[j]).replaceAll("[,\\[\\]]",""));
            }
        }
    }
    public static void checkGroup(int m, int n){
        if (m==0){//맨 가로 첫줄
            if (n==0){//세로첫줄
                if(map[m+1][n] !=0) {
                    map[m][n] = map[m + 1][n];
                } else if (map[m][n+1] !=0) {
                    map[m][n]=map[m][n+1];
                }else{
                    map[m][n] = ++count;
                }
            } else if (n==N-1) { //세로 끝줄
                if(map[m+1][n] !=0) {
                    map[m][n] = map[m + 1][n];
                } else if (map[m][n-1] !=0) {
                    map[m][n]=map[m][n-1];
                }else{
                    map[m][n] = ++count;
                }
            }else{//중간줄
                if(map[m+1][n] !=0) {
                    map[m][n] = map[m + 1][n];
                } else if (map[m][n-1] !=0) {
                    map[m][n]=map[m][n-1];
                } else if (map[m][n+1]!=0) {
                    map[m][n]=map[m][n+1];
                } else{
                    map[m][n] = ++count;
                }
            }
        }

        else if (m == M-1) { //가로 맨 끝줄
            if (n==0){//세로첫줄
                if(map[m-1][n] !=0) {
                    map[m][n] = map[m - 1][n];
                } else if (map[m][n+1] !=0) {
                    map[m][n]=map[m][n+1];
                }else{
                    map[m][n] = ++count;
                }
            } else if (n==N-1) { //세로 끝줄
                if(map[m-1][n] !=0) {
                    map[m][n] = map[m - 1][n];
                } else if (map[m][n-1] !=0) {
                    map[m][n]=map[m][n-1];
                }else{
                    map[m][n] = ++count;
                }
            }else{//중간줄
                if(map[m-1][n] !=0) {
                    map[m][n] = map[m - 1][n];
                } else if (map[m][n-1] !=0) {
                    map[m][n]=map[m][n-1];
                } else if (map[m][n+1]!=0) {
                    map[m][n]=map[m][n+1];
                } else{
                    map[m][n] = ++count;
                }
            }
        }

        else{ // 가로 가운데
            if (n==0){//세로첫줄
                if(map[m-1][n] !=0) {
                    map[m][n] = map[m - 1][n];
                } else if (map[m+1][n] !=0) {
                    map[m][n]=map[m+1][n];
                }else if (map[m][n+1] !=0) {
                    map[m][n]=map[m][n+1];
                }else{
                    map[m][n] = ++count;
                }
            } else if (n==N-1) { //세로 끝줄
                if(map[m-1][n] !=0) {
                    map[m][n] = map[m - 1][n];
                } else if (map[m+1][n] !=0) {
                    map[m][n]=map[m+1][n];
                }else if (map[m][n-1] !=0) {
                    map[m][n]=map[m][n-1];
                }else{
                    map[m][n] = ++count;
                }
            }else{//중간줄
                if(map[m-1][n] !=0) {
                    map[m][n] = map[m - 1][n];
                } else if (map[m+1][n] !=0) {
                    map[m][n]=map[m+1][n];
                }else if (map[m][n-1] !=0) {
                    map[m][n]=map[m][n-1];
                } else if (map[m][n+1]!=0) {
                    map[m][n]=map[m][n+1];
                } else{
                    map[m][n] = ++count;
                }
            }

        }
    }
}
