package baekjoon.LinkedList;

import java.io.*;
import java.util.LinkedList;
import java.util.ListIterator;
// 백준 - 키로거 연결리스트 에러 못 고침
public class P5397 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // 문자열 개수 입력받음
        int count = Integer.parseInt(br.readLine());

        for (int i = 0; i < count; i++) {
            LinkedList<Character> list = new LinkedList<>();
            ListIterator<Character> iter = list.listIterator();
            String str = br.readLine();

            for (int j = 0; j < str.length(); j++) {
                char c = str.charAt(j);
                switch (c) {
                    case '<':
                        if (iter.hasPrevious()) {
                            iter.previous();
                        }
                        break;
                    case '>':
                        if (iter.hasNext()) {
                            iter.next();
                        }
                        break;
                    case '-':
                        if (iter.hasPrevious()) {
                            // ListIteratord의 remove()는 Iterator와 달리 양방향 이동이 가능해
                            // 이전에 방문한 요소를 삭제한다.(next나 previous 호출없이 remove()를 진행할 수 없다.)
                            // 즉 이전에 previous()나 next()에 의해 마지막에 호출된 값을 삭제함
                            iter.previous();
                            iter.remove();
                        }
                        break;
                    default:
                        list.add(c);
                }
            }
            for (Character character : list) {
                bw.write(character);
            }
            bw.write("\n");
        }
        bw.flush();
        bw.close();
    }
}

