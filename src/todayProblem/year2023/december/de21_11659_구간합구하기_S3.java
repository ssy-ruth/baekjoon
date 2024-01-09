package todayProblem.year2023.december;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class de21_11659_구간합구하기_S3 {
    static int[] array;

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int N=Integer.parseInt(st.nextToken());
        int M=Integer.parseInt(st.nextToken());

        st=new StringTokenizer(br.readLine());
        array=new int[N+1];

        for(int i=1;i<=N;i++) {
            array[i]=array[i-1]+Integer.parseInt(st.nextToken());
        }

        for(int i=0;i<M;i++) {
            st=new StringTokenizer(br.readLine());
            int a=Integer.parseInt(st.nextToken());
            int b=Integer.parseInt(st.nextToken());

            System.out.println(array[b]-array[a-1]);
        }
    }
}
