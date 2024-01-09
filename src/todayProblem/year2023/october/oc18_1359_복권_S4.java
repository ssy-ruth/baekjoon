package todayProblem.year2023.october;

import java.util.Scanner;

public class oc18_1359_복권_S4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n= sc.nextInt(), m= sc.nextInt(), k= sc.nextInt();

        //n개중 m개 선택하는 모든 경우의 수 구하기
        double p = Combination(n,m);
        double result=0.0;

        //2. M 중에 K 개 이상의 수가 포함되면 당첨이기 때문에 M개 중에서 K개를 포함하는 경우 M개중 K+1 개를 포함하는 경우
        //M개중에서 M개를 포함하는 경우 모두를 더해주면 된다.
        //mCk = 당첨 숫자를 뽑는 경우의 수, n-mCm-k= 당첨이 아닌 숫자를 뽑는 경우의 수
        while(m >= k){
            //특정 입력값(ex.3 2 2)이 올 때, n-m이 m-k보다 작은 경우가 존재해서
            //이를 검사하는 if문이 있다.
            if(n - m < m - k){
                k++;
                continue;
            }

            double c = Combination(m, k) * Combination(n-m, m-k);

            result += c/p;
            k++;
        }
        System.out.println(result);

    }

    static long Combination(int n, int r){
    //nCr = n!/r!(n-r)!
        // (n-r)!은 n에서 r개만큼을 제외한 작은 숫자들이 소거됨.=> r번만큼만 계산해주면 n!/(n-r)!만큼은 자연스럽게 약분 처리
        int c=1, p=1;

        while(r>0){
            c*=n--;
            p*=r--;
        }

        return c/p;
    }
}
