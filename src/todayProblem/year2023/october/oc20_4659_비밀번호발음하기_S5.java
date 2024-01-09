package todayProblem.year2023.october;

import java.util.Scanner;

public class oc20_4659_비밀번호발음하기_S5 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        outer:
        while(true) {
            String pwd = sc.nextLine();
            char[] pwdarr = pwd.toCharArray();
            if (pwd.equals("end"))
                break;

            String pwdRegexLower = "[a-z]*";//대문자포함x
            String pwdRegexVowel = "[a-z]*[aeiou]+[a-z]*";//"[a-z]*[aeiou]+[a-z]*]";//조건1 모음중 하나 포함

            if(pwd.matches(pwdRegexLower)&&pwd.matches(pwdRegexVowel)){
                for(int i=1;i<pwd.length();i++){
                    //조건3 검사 - 같은 글자 e나 o빼고 올 수 없음
                    if(pwdarr[i-1]==pwdarr[i] && (pwdarr[i]!='e'&& pwdarr[i]!='o')){
                        System.out.printf("<%s> is not acceptable.%n", pwd);
                        continue outer;
                    }
                }
                //조건2 검사 - 모음이 3개 혹은 자음이 3개 연속으로 오면 안된다.
                if(pwd.matches("[a-z]*[aeiou][aeiou][aeiou][a-z]*") || pwd.matches("[a-z]*[^aeiou][^aeiou][^aeiou][a-z]*")){
                    System.out.printf("<%s> is not acceptable.%n", pwd);
                    continue outer;
                }
                //통과
                System.out.printf("<%s> is acceptable.%n", pwd);
            }else{
                //대문자 포함이거나 모음중 하나 없을때
                System.out.printf("<%s> is not acceptable.%n", pwd);
            }
        }
    }
}
