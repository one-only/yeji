package baekjoon.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 수학 - LCM
public class P5347 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());
        int[] a = new int[count];
        int[] b = new int[count];

        for (int i = 0; i < count; i++) {
            String[] str = br.readLine().split(" ");
            a[i] = Integer.parseInt(str[0]);
            b[i] = Integer.parseInt(str[1]);
            if (b[i] < a[i]) {
                int temp = a[i];
                a[i] = b[i];
                b[i] = temp;
            }
        }
        for (int i = 0; i < count; i++) {
            // int형은 제출이 되지 않는다. 최송공배수는 수가 많이 커질 수 있어 long형으로 다뤄야한다.
            long answer = 1;
            int divisor = 2;

            while(divisor <= a[i]){
                if (a[i] % divisor == 0 && b[i] % divisor == 0) {
                    a[i] /= divisor;
                    b[i] /= divisor;
                    answer *= divisor;
                    divisor = 2;
                    continue;
                }
                divisor++;
            }
            answer = answer * a[i] * b[i];
            System.out.println(answer);
        }
    }
}
