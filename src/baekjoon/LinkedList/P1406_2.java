package baekjoon.LinkedList;

import java.io.*;
import java.util.LinkedList;
import java.util.ListIterator;

// 백준 문제 에디터 - ListIterator 이용(통과)
public class P1406_2 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String str = br.readLine();
        int count = Integer.parseInt(br.readLine());

        LinkedList<Character> list = new LinkedList<>();

        for (int i = 0; i < str.length(); i++) {
            list.add(str.charAt(i));
        }

        // int index 대신 Iterator 메소드 호출
        ListIterator<Character> iter = list.listIterator();
        // 초기 커서는 문장의 맨 뒤에 있어야 하므로 커서를 맨뒤로 이동시킴(abc|)
        while (iter.hasNext()) {
//            System.out.println("iter.next() = " + iter.next()); // a b c d 차례로 출력됨
            iter.next();
        }
        // count만큼 반복, 명령어 한줄씩 읽어들여 처리
        for (int i = 0; i < count; i++) {
            String command = br.readLine();
            char val = command.charAt(0);

            switch (val) {
                case 'L':
                    if(iter.hasPrevious())
                        iter.previous();
                    break;
                case 'D':
                    if(iter.hasNext())
                        iter.next();
                    break;
                case 'B':
                    if (iter.hasPrevious()) {
                        // remove()는 next()나 previous()에 의해 반환된 가장 마지막 요소를 제거함.
                        // 주의! 커서의 왼쪽 값(바로앞의 값)이 반환된다.dmih|라면 h반환.
                        iter.previous();
                        iter.remove();
                    }
                    break;
                case 'P':
                    iter.add(command.charAt(2)); // 커서는 추가한 값 바로 위치하게 된다.
                    break;
            }
        }//for
        for (Character character : list) {
            bw.write(character);
        }
        bw.flush();
        bw.close();
    }//main
}
