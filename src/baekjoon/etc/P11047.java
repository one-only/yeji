package baekjoon.etc;

import java.util.Scanner;

public class P11047 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        // 방법1 Scanner이용
        int n = sc.nextInt();
        int k = sc.nextInt();
        int count = 0;
        int[] val = new int[n];

        for (int i = 0; i < n; i++){
            val[i] = sc.nextInt();
        }
        // n=10이면 인덱스는 0~9까지인것 주의!
        for (int i = n-1; i >= 0; i--) {
            System.out.println("i = " + i);
            if(k < val[i])
                continue;
            count += (k / val[i]);
            k %= val[i];
//            if(k==0) break; // i는 9-4까지, 안넣으면 i는 9-0까지
            // 근데 테스트 겨로가 if문 제외하는 것이 4초 빨랐다.

        }
        System.out.println(count);
    }
}
