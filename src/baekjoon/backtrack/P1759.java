package baekjoon.backtrack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P1759 {
    static int L;
    static int C;
    static char[] arr;
    static char[] code;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        arr = new char[C];
        code = new char[L];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < C; i++) {
            arr[i] = st.nextToken().charAt(0);
        }
        Arrays.sort(arr);
        bk(0,0);
        System.out.println(sb);
    }

    static void bk(int depth, int start) {
        if (depth == L) {
            if (check()) {
                System.out.println(code);
            }
            return;
        }

        for (int i = start; i < C; i++) {
            code[depth] = arr[i];
            bk(depth+1,i+1);

        }
    }
    // 최소 한 개의 모음, 최소 두 개의 자음인지
    static boolean check() {
        int vowel = 0;
        int cons = 0;

        for (char c : code) {
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                vowel++;
            } else {
                cons++;
            }
        }
        if (vowel >= 1 && cons >= 2) {
            return true;
        }
        return false;
    }
}
