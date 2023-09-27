package baekjoon.sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

// 정렬2 - 국영수
// P10825와 동일 - 변경사항: 입출력부분만 변경
// 객체 사용 o , scanner, println 사용(2464ms)
class Student {
    String name;
    int kor;
    int eng;
    int math;

    public Student(String name, int kor, int eng, int math) {
        this.name = name;
        this.kor = kor;
        this.eng = eng;
        this.math = math;
    }
}
public class P10825_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<Student> students = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String name = scanner.next();
            int koreanScore = scanner.nextInt();
            int englishScore = scanner.nextInt();
            int mathScore = scanner.nextInt();
            students.add(new Student(name, koreanScore, englishScore, mathScore));
        }

        Collections.sort(students, new Comparator<Student>() {
            @Override
            public int compare(Student s1, Student s2) {
                if (s1.kor != s2.kor) {
                    return s2.kor - s1.kor;
                } else if (s1.eng != s2.eng) {
                    return s1.eng - s2.eng;
                } else if (s1.math != s2.math) {
                    return s2.math - s1.math;
                } else {
                    return s1.name.compareTo(s2.name);
                }
            }
        });

        for (Student student : students) {
            System.out.println(student.name);
        }
    }
}
