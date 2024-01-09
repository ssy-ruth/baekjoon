package todayProblem.year2023.december;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class de05_10431_줄세우기_S5 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] T = new int[N][21];

        for (int i = 0; i < N; i++) {
            T[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            System.out.println(T[i][0] + " " + lineUp(T[i]));
        }
    }

    public static int lineUp(int[] student){
        int result=0;
        int[] line = new int[21];
        line[1] = student[1];

        outer:
        for (int i = 1; i <= 20; i++) {
            inner:
            for (int j = 20; j > 0; j--) {
                if (line[j]==0)
                    continue inner;
//                int indContain = contain(line, student[i]);
//                if (indContain!=0)
//                    line[indContain]=0;
                if (student[i]<line[j]){
                    insert(line, j, student[i]);
                    result+=1;
                } else if (student[i]>line[j]) {
                    line[j+1]=student[i];
                }
            }
        }

        return result;
    }

    public static int[] insert(int[] arr, int index, int v){
        for (int i = 19; i >=index; i--) {
            arr[i+1]=arr[i];
        }
        arr[index]=v;
        return arr;
    }

    public static int contain(int[] arr, int v){
        for (int i = 1; i <= 20; i++) {
            if (arr[i]==v)
                return i;
        }
        return 0;
    }
}
