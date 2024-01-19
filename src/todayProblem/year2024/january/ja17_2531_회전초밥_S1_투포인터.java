package todayProblem.year2024.january;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

//풀다보니 투포인터로 안풀음......
//아직 시간초과로 틀림,,,,
public class ja17_2531_회전초밥_S1_투포인터 {
    static int[] belt;
    static int N, K, C;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); //회전초밥벨트에 놓인 접시 수
        int D = Integer.parseInt(st.nextToken()); //초밥 가지 수  ___ 이건 왜 알려준담
        K = Integer.parseInt(st.nextToken()); //연속해서 먹는 접시 수
        C = Integer.parseInt(st.nextToken()); //쿠폰 번호
        belt = new int[N]; // 벨트 위 초밥들
        for (int i = 0; i < N; i++) {
            belt[i] = Integer.parseInt(br.readLine());
        }
        System.out.println(countSushi());
    }

    public static int countSushi(){
        int max = 0;
        Set<Integer> sushi = new HashSet<>();
        for (int i = 0; i < N; i++) {
            if (sushi.size() == 0){                 //첫 바퀴일 때 K사이즈만큼 다 추가
                for (int j = 0; j < K; j++) {
                    int index = i + j;
                    if (index >= N){
                        index = index-N;                  // 한바퀴 넘어가면 인덱스 초기화
                    }
                    if (!sushi.contains(belt[index])){
                        sushi.add(belt[index]);     // 안 겹치는 초밥만 추가
                    }
                }
            }else {                                 // 한칸씩 이동 중인 경우
                int index = i+K-1;                    // 끝 인덱스만 추가 과정
                if (index >= N){
                    index = index - N;              // 한바퀴 넘어가면 인덱스 초기화
                }
                if (!sushi.contains(belt[index])){
                    sushi.add(belt[index]);
                }
            }
            if (!sushi.contains(C)){            //쿠폰 초밥 없으면 추가
                sushi.add(C);
            }
            if (sushi.size() > max){            //초밥 종류 제일 많으면 저장
                max = sushi.size();
            }
            // 삭제할 때.. K범위 안에서 같은 값 여러개 있을 때 set에서 삭제되어 버리면 초밥종류 카운트가 어려워짐
            if (sushi.contains(belt[i])){ //K길이 중 첫칸 삭제. 아까 끝칸 추가했듯.
                sushi.remove(belt[i]);
            }
        }
        return max;
    }


    //3%시간초과 떴다. 그대로 구현해서 그런듯
//    public static int countSushi(){
//        int count = 0, max = 0; //초밥 종류 카운트, 초밥 종류 최대값 저장
//        for (int i = 0; i < N; i++) {
//            Set<Integer> already = new HashSet<>();
//            count = 0;
//            for (int j = 0; j < K; j++) {
//                int index = i+j;
//                if (i+j >= N){
//                    index = j; // 인덱스 넘어가면 0+j로 해서 처음 인덱스로 연결
//                }
//                if (!already.contains(belt[index])){ // 지금까지 안먹은 초밥이면
//                    count += 1;                         // 카운트 늘리고
//                    already.add(belt[index]);           // 먹은 초밥에 저장
//                }                                       //진작 투포인터로 풀었더라면 합한걸 다 저장해두고 적당히 더하고 빼기만 했을텐데,, 돌면서 더했던거 또 더하고 있네,,,
//            }
//            if (!already.contains(C)){ // 쿠폰 조밥 안먹은 초밥이면
//                count += 1;             //카운트 늘리고
//                already.add(C);         //먹은 초밥에 저장
//            }
//            if (count > max){ // 최대인 초밥개수면
//                max = count; //저장
//            }
//        }
//        return max;
//    }
}
