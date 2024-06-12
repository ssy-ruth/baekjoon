package todayProblem.year2024.june;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//성공
public class ju12_1436_영화감독숀_S5_구현 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        //규칙이 있어야..
        //1. 자리수가 작아야함
        //2. 앞자리수 순서대로 작아야함
        //3. 666을 제외한 다른 문자를 최대한 바꿔봐야함
        //그냥 숫자 1씩 올리면서 666 포함되면서 몇번째로 발견되는 놈인지 카운트하고 출력
        String title = "666";
        int count =0;
        int number = 666;
        while (count!=N){
            String str = number+"";
            if (str.contains(title)){
                count++;
            }
            number++;
        }
        System.out.println((number-1));
    }
}
