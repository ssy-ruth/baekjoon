package todayProblem.year2023.december;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class de19_17266_어두운굴다리_S4 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int maxDis = 0;
        int lastPoint = 0;
        for (int i = 0; i < M; i++) {
            int a;
            if (i==M-1){
                a = N;
            }else {
                a = Integer.parseInt(st.nextToken());
            }
            if (i!=0 && i!=M-1){
                int b = (a - lastPoint)/2;
                if (b%2 ==0){
                    if ( maxDis < b ){
                        maxDis = b;
                    }
                }else {
                    if ( maxDis < Math.ceil(b) ){
                        maxDis = (int) Math.ceil(b);
                    }
                }
            }else {
                if ( maxDis < a-lastPoint){
                    maxDis = a-lastPoint;
                }
            }
            lastPoint = a;
        }

        System.out.println(maxDis);
    }
}
