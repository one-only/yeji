package baekjoon.sort;

import java.io.*;
import java.util.*;
// 정렬2 - 국영수
// P10825와 동일
// 변경사항: List로 저장하지 않고 객체 배열로 변경하여 풀이(820ms)
public class P10825_4 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int count = stoi(br.readLine());

        Stu[] stus = new Stu[count];

        for (int i = 0; i < count; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            String name = st.nextToken();
            int kor = stoi(st.nextToken());
            int eng = stoi(st.nextToken());
            int math = stoi(st.nextToken());
            stus[i] = new Stu(name, kor, eng, math);
        }
        Comparator<Stu> comp = new Comparator<Stu>() {
            @Override
            public int compare(Stu s1, Stu s2) {
                if(s1.kor!=s2.kor)
                    return s2.kor-s1.kor;
                else if(s1.eng!=s2.eng)
                    return s1.eng - s2.eng;
                else if(s1.math!=s2.math)
                    return s2.math - s1.math;
                else
                    return s1.name.compareTo(s2.name);
            }
        };
        Arrays.sort(stus,comp);

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
