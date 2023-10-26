package baekjoon.hash;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

// 서로 다른 부분 문자열의 개수 https://www.acmicpc.net/problem/11478
public class P11478 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        Set<String> set = new HashSet<>();

        for (int i = 0; i < str.length(); i++) { //0-4
            for (int j = i+1; j <= str.length(); j++) { //1-5
                set.add(str.substring(i, j));
            }
        }
        System.out.println(set.size());
    }
}
