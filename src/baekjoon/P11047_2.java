package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P11047_2 {
    public static void main(String[] args) throws IOException {
        // 방법2 BufferedReader
        // BufferedReader는 문자열을 한 줄로 읽기 때문에 n, k 구분을 위해 문자열을 분리해야한다.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // StringTokenizer를 이용하여 문자열 분리
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        int n = Integer.parseInt(st.nextToken()); //문자열->정수
        int k = Integer.parseInt(st.nextToken());

        int[] val = new int[n];
        int count = 0;

        for (int i = 0; i < n; i++) {
            val[i] = Integer.parseInt(br.readLine());
        }
        for (int i = n-1; i >=0 ; i--) {
            if(k < val[i])
                continue;
            count += k/val[i];
            k %= val[i];
//            if(k==0) break; 근데 if문 제외하고 i가 0까지 가는게 시간이 더 짧게나옴
        }
        System.out.println(count);
    }
}
