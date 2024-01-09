package todayProblem.year2023.november;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class no30_14889_스타트와링크_S1 {
    static int N;
    static int R;
    static int[] n;
    static int[][] S;
    static int[] result;
    static int[] result2;
    static int[] minSs;
    static int minS;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer input = new StringTokenizer(br.readLine());
        N = Integer.parseInt(input.nextToken());
        R = N/2;
        n = new int[N];
        S = new int[N][N];
        result = new int[R];
        result2 = new int[2];
        minSs = new int[N];
        minS=0;

        for (int i = 0; i < N; i++) {
            S[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            n[i] = i+1;
        }


        Combination(0,0);
    }

    public static void Combination(int start, int count){
        if(count==R) {
            //System.out.println(Arrays.toString(result));
            checkS(result);
            return;
        }

        for(int i=start; i<N; i++){
            result[count] = n[i];
            Combination(i+1, count+1);
        }
    }
    public static void Combination2(int start, int count){
        if(count==2) {
            //System.out.println(Arrays.toString(result));
            checkS(result);
            return;
        }

        for(int i=start; i<N; i++){
            result2[count] = n[i];
            Combination2(i+1, count+1);
        }
    }

    public static void checkS(int[] team){
        Combination2(0,0);
    }

//    public static void Combination(int level, int biginWith, int[] n, int[] result){
//        //종료조건, 뎁스가 2개 들어가며 ㄴ종료
//        if (level == 2)
//            System.out.println(result);
//        else {
//            for (int i :
//                    n.) {
//
//            }
//        }
//    }
}
