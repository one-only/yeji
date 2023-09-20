package baekjoon;

import java.util.ArrayList;
import java.util.List;

public class MainFree {
    public static void main(String[] args) {
//        LocalDate
        System.out.println(5%4);

        StringBuilder sb = new StringBuilder();
        char a = 'a';
        char b = 'b';

        sb.append(a);
        sb.append(b);
        System.out.println(sb);

        List<Integer> list = new ArrayList<>();
        list.add(2);
        list.add(3);
        list.add(4);
        list.remove(2); // 인덱스 2인 값 4가 지워짐
        System.out.println(list.toString());
    }
}