package baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 잃어버린 괄호
public class P1541 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(),"-");

        int min = 0;
        int num = 1;

        while (st.hasMoreTokens()) {
            int sum = 0;
            StringTokenizer st2 = new StringTokenizer(st.nextToken(), "+");
            while(st2.hasMoreTokens()){
                sum += Integer.parseInt(st2.nextToken());
            }
            if (num == 1) { // 가장 처음 값은 부호가 '+'
                min += sum;
                num++;
            } else {
                min += -sum;
            }
        }
        System.out.println(min);

    }
}
