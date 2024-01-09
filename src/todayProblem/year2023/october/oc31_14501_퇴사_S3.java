package todayProblem.year2023.october;

import java.util.Scanner;

public class oc31_14501_퇴사_S3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] T = new int[N + 1]; // 상담을 완료하는 데 걸리는 시간
        int[] P = new int[N + 1]; // 상담을 완료했을 때 받을 수 있는 금액
        int[] dp = new int[N + 2]; //i번째 날부터 시작해서 마지막 날까지 낼 수 있는 최대 이익

        for (int i = 1; i <= N; i++) {
            T[i] = sc.nextInt();
            P[i] = sc.nextInt();
        }

        for (int i = N; i >= 1; i--) {
            if (i + T[i] > N + 1) {//i번째 상담을 수락했을때, 상담끝나는 날이 퇴사날 이후면
                dp[i] = dp[i + 1]; //상담을 못하므로 다음날 최대 이익과 같다.
            } else {
                //i번째 날 상담 선택하는 경우의 이익(상담끝나는날이익+i번째날상담이익)과 선택하지 않을 경우(=다음날이익)의
                // 이익중 큰것을 i번째 날 최대 이익으로 저장
                dp[i] = Math.max(dp[i + 1], P[i] + dp[i + T[i]]);
            }
        }
        System.out.println(dp[1]);
    }
}
//        int[][] prft=new int[n][5];
//
//        int t, p, avr, ind=0, count=0, min, max=0, property, total=0;
//        //1. 기간안에 안되는 일 제외
//        for (int i=0;i<n;i++) {
//            t=sc.nextInt();
//            p= sc.nextInt();
//            prft[i][0]=t;//시간
//            prft[i][4]=t;//백업용
//            prft[i][1]=p;//비용
//            prft[i][2]=p/t;//시간당비용
//            if(prft[i][0] > n-i){ // 기간안에 진행할 수 없는 일
//                prft[i][0]=0;
//                prft[i][1]=0;
//                prft[i][2]=-1;
//                prft[i][3]=-1;
//                count++;
//            }
//            //젤큰거 하나 고르기
//            if (i!=0 && max<prft[i][2]){
//                max=prft[i][2];
//                ind=i;
//            }
//            else if(i==0){
//                max=prft[i][2];
//                ind=i;
//            }
//        }
//        prft[ind][3]=1;
//        prft[ind][2]=-1;
//        //2. 우선순위 부여
//        for (int i = n-count; i >1; i--) {
//            min=Integer.MAX_VALUE;
//            ind=0;
//            for (int j = 0; j < n; j++) {
//                avr=prft[j][2];
//                if (avr!=-1 && avr<min){ // 이미순위매겨졌거나 진행안되는일 비교 x
//                    min=avr;
//                    ind=j;
//                }
//            }
//            prft[ind][3]=i;
//            prft[ind][2]=-1;
//        }
//        property=1;
//        ind=-1;
//        //3. 우선순위대로 기간 배정, 가능한 아이들  돈 합산
//        outer:
//        while(property<=n-count){
//            //해당 우선순위 인덱스 찾기
//            inner:
//            for (int i = 0; i < n - count; i++) {
//                if (prft[i][3]==property) {
//                    ind = i;
//                    break inner;
//                }
//            }
//            //해당 인덱스의 소요기간만큼 일 배정
//            inner1:
//            for (int i = 0; i < prft[ind][4]; i++) {
//                //일배정가능하면 일배정
//                if (prft[ind+i][0]!=-1)
//                    prft[ind+i][0]=-1;
//                //일배정불가능하면 되돌리기
//                else if (prft[ind + i][0] == -1) {
//                    i-=1;
//                    while(i>=0) {
//                        prft[ind + i][0] = prft[ind + i][4];
//                        i-=1;
//                    }
//                    break inner1;
//                }
//                if(i==prft[ind][4]-1)
//                    total+=prft[ind][1];
//            }
//            property++;
//        }
//        System.out.println(total);

