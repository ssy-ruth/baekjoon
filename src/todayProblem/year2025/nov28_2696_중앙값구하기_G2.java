package todayProblem.year2025;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class nov28_2696_중앙값구하기_G2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); //테스트케이스개수
        // 1. 받을때마다 정렬한다 그리고 가운데 인덱스를 반환한다.
        // 2. 받을때마다 정렬하는데 가운데 값을 갖고 있는 걸 pivot삼아 정렬한다.

        for (int i = 0; i < N; i++) {
            int M = Integer.parseInt(br.readLine());
            ArrayList<Integer> arr = new ArrayList<>();
            StringTokenizer st = new StringTokenizer("");
            int cnt = 0;

            //중앙값 개수 출력
            if (M%2==0) System.out.println(M/2);
            else System.out.println((M+1)/2);
            StringBuilder sb = new StringBuilder();

            for (int j = 1; j <= M; j++) {
                while (!st.hasMoreTokens()) {
                    st = new StringTokenizer(br.readLine());
                }
                //일단 정렬
                arr=findPivot(arr, Integer.parseInt(st.nextToken()));
                //홀수면 중앙값 출력
                if (j%2==1) {
                    sb.append(arr.get((j-1)/2)).append(" ");
                    cnt++;

                    if (cnt % 10 == 0) sb.append("\n");
                }
            }
            System.out.println(sb);
        }
    }
    public static ArrayList<Integer> sortTen(ArrayList<Integer> arr, int num, int start, int end) {
        // 배열이 비어있으면 그냥 넣기
        if (arr.isEmpty()) {
            arr.add(num);
            return arr;
        }
        // arr 길이가 10 이하면 직접 비교 후 넣음
        for (int i=start;i<=end;i++) {
            //마지막인덱스면 넣음
            if (i==end) {
                if (num >= arr.get(i)) arr.add(i + 1, num);
                else arr.add(i, num);
                return arr;
            }

            //현재 요소보다 크면 넘어감
            if(arr.get(i)<num){
                //근데 다음요소보다 작으면 여기가 그자리! 넣음
                if (num<arr.get(i+1)){
                    arr.add(i+1, num);
                    return arr;
                }
            }else {
                //현재 요소보다 작으면 여기에 넣어야함
                arr.add(i, num);
                return arr;
            }
        }
        // 루프를 다 돌면 맨 뒤에 삽입
        arr.add(num);
        return arr;
    }
    public static ArrayList<Integer> findPivot(ArrayList<Integer> arr, int num) {
        int start = 0;
        int end = arr.size()-1;

        // 빈 배열이면 그냥 첫 요소 삽입
        if (arr.isEmpty()) {
            arr.add(num);
            return arr;
        }
        int pivot = (start + end) / 2;//int pivot = end%2==1?(end+1)/2:end/2;

        while (end-start>10){
            // 배열의 후반에 num 자리가 있을 때
            if (arr.get(pivot)<num) {
                start = pivot+1;
                pivot = (start + end) / 2;//pivot = end%2==1?(end+1)/2:end/2;
            }
            //배열의 전반에 num 자리가 있을 때
            else{
                end = pivot-1;
                pivot = (start + end) / 2;//pivot = end%2==1?(end+1)/2:end/2;
            }
        }
        return sortTen(arr,num,start,end);
    }
}
