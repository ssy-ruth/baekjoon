package todayProblem.year2024.january;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ja15_1074_Z_S1_구현 {
    static int count;
    static int r, c;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        findZ(r, c, (int) Math.pow(2, N));
    }

    public static void findZ(int r, int c, int size) {
        if (size == 1){
            System.out.println(count);
            return;
        }

        int half = size/2;
        if (r < half && c < half){
            findZ(r, c, half);
        } else if (r < half) {
            count += half*half;
            findZ(r, c-half, half);
        }
        else if (c < half) {
            count += half*half*2;
            findZ(r-half, c, half);
        }
        else {
            count += half*half*3;
            findZ(r-half, c-half, half);
        }
    }
}

//그대로 구현한 함수.. 실제로 z모양으로 탐색하면서 카운트를 함
//    public static void findZ(int startX, int endX, int startY, int endY){
//        if (find) return;
//        if (endX - startX == 1){
//            for (int i = startY; i <= endY; i++) {
//                for (int j = startX; j <= endX; j++) {
//                    if (i == r && j == c){
//                        System.out.println(count);
//                        find = true;
//                        return;
//                    }
//                    count += 1;
//                }
//            }
//        }else {
//            int a = (endX - startX + 1) / 2;
//            for (int i = startY; i <= endY ; i+=a) {
//                for (int j = startX; j <= endX; j+=a) {
//                    if (find) return;
//                    findZ(j, j+a-1, i, i+a-1);
//                }
//            }
//        }
//    }
