package todayProblem.year2023.november;

import java.io.*;
public class no28_1_1_운동중독_1 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        int W=0, R=0;
        for(int i=0;i<input.length();i++){
            if(input.charAt(i) == ' '){
                W=Integer.parseInt(input.substring(0,i));
                R=Integer.parseInt(input.substring(i+1));
                break;
            }
        }
        int result=(int) (W*(1+(float)R / 30));
        System.out.println(result);
    }
}
//스트링 토큰라이저라는게 있구나!!!!
//스캐너보다 버퍼리더가 더 좋대.
//스캐너는 타입을 지정해서 받을 수 있지만, 버퍼는 무조건 스트링임
//스캐너는 타입을 구분하는 정규식을 사용해서 속도가 더 걸리지만
//버퍼는 스트링을 받는 것만 하기에 조금 더 빠름