package baekjoon.linkedList;

import java.io.*;
import java.util.LinkedList;

// 백준 문제 에디터 - 시간초과(P1406_2로 리팩토링하여 통과)
public class P1406 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String str = br.readLine();
        int count = Integer.parseInt(br.readLine());

        LinkedList<Character> list = new LinkedList<>();
        // 크기가 5이면 인덱스는 0-4 ! 헷갈 ㄴㄴ
        // 문자열을 리스트에 한 문자씩 저장
        for (int i = 0; i < str.length(); i++) {
            list.add(str.charAt(i));
        }

        // 커서의 역할을 위한 변수 선언. 리스트의 마지막 인덱스+1 을 가리키도록
        // abcd 라면 index = 4
        int index = list.size();
        // count만큼 반복, 명령어 한줄씩 읽어들여 처리
        for (int i = 0; i < count; i++) {
            String command = br.readLine();
            char val = command.charAt(0);

            switch (val) {
                case 'L':
                    if(index!=0) // 커서가 맨앞이 아닌경우
                        index -= 1; // 커서 왼쪽으로 한 칸 이동
                    break;
                case 'D':
                    if(index!=list.size()) // 커서가 맨뒤가 아닌경우
                        index += 1; // 커서 오른쪽으로 한 칸 이동
                    break;
                case 'B':
                    if(index!=0){ // 커서가 맨앞이 아닌경우
                        list.remove(index-1); // 커서 왼쪽 값 삭제
                        index -= 1;
                    }
                    break;
                case 'P':
                    list.add(index, command.charAt(2));
                    index +=1;
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
