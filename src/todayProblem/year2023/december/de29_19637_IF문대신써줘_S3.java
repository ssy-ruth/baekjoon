package todayProblem.year2023.december;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class de29_19637_IF문대신써줘_S3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        String[] names = new String[N+1];
        int[] powers = new int[N+1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            names[i] = st.nextToken();
            powers[i] = Integer.parseInt(st.nextToken());
        }
        powers[0] = -1;
        for (int i = 0; i < M; i++) {
            int character = Integer.parseInt(br.readLine());

            int left=0;
            int right=N-1;
            int mid=(left+right)/2;
            while(left<=right){
                mid=(left+right)/2;

                if(powers[mid]<character){
                    left=mid+1;
                }
                else{
                    right=mid-1;
                }
            }
            sb.append(names[left]+"\n");
        }
        System.out.print(sb);
    }
}

//            inner:
//            for (int j = 1; j <= N; j++) {
//                if (character > powers[j-1] && character <= powers[j]){
//                    System.out.println(names[j]);
//                    break inner;
//                }
//            }