package baekjoon.sort;

import java.io.*;
import java.util.*;

// 정렬2 - 국영수 -> 결과가 제대로 나오지 않음 -> 해결(o) 영어 오름차순 문제
// 객체 사용, BufferedReader 사용하여 풀이 (776ms)

/*
[ 객체 사용O ]
    P10825 - List에 객체 담아 풀이(Collections.sort)
    P10825_4 – P10825와 동일, 객체 배열을 만들어 풀이(Comparator 구현하여 Arrays.sort)
    P10825_2 – P10825와 동일, 입출력 부분 Scanner, println()사용

[ 객체 사용X ]
    P10825_3 – String배열 만들어 Arrays.sort로 정렬
*/
class Stu {
    String name;
    int kor;
    int eng;
    int math;

    public Stu(String name, int kor, int eng, int math) {
        this.name = name;
        this.kor = kor;
        this.eng = eng;
        this.math = math;
    }
}
public class P10825 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int count = stoi(br.readLine());

        List<Stu> stus = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            String name = st.nextToken();
            int kor = stoi(st.nextToken());
            int eng = stoi(st.nextToken());
            int math = stoi(st.nextToken());

            stus.add(new Stu(name,kor,eng,math));
        }
        Collections.sort(stus, new Comparator<Stu>() {
            @Override
            public int compare(Stu s1, Stu s2) {
                // 앞의 수가 더 크면 양수->두 객체 위치를 바꾸어 정렬
                // 음수나 0 -> 위치 바꾸지 않음
                if (s1.kor != s2.kor) {
                    return s2.kor - s1.kor;
                }
                else if (s1.eng != s2.eng) {
                    return s1.eng - s2.eng;
                }
                else if (s1.math != s2.math) {
                    return s2.math - s1.math;
                }
                else {
                    // 이름을 사전순으로 정렬
                    return s1.name.compareTo(s2.name);
                }
            }
        });
        for (Stu student : stus) {
            bw.write(student.name+"\n");
        }
        bw.flush();
        bw.close();

    }

    public static int stoi(String str) {
        return Integer.parseInt(str);
    }
}
