//package baekjoon;
//
//import java.io.*;
//import java.util.*;
//
//// 정렬2 - 국영수 -> 결과가 제대로 나오지 않음
//class Student{
//    String name;
//    int kor;
//    int eng;
//    int math;
//
//    public Student(String name, int kor, int eng, int math) {
//        this.name = name;
//        this.kor = kor;
//        this.eng = eng;
//        this.math = math;
//    }
//}
//public class P10825 {
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//        int count = stoi(br.readLine());
//
//        List<Student2> student2s = new ArrayList<>();
//
//        for (int i = 0; i < count; i++) {
//            StringTokenizer st = new StringTokenizer(br.readLine());
//
//            String name = st.nextToken();
//            int kor = stoi(st.nextToken());
//            int eng = stoi(st.nextToken());
//            int math = stoi(st.nextToken());
//
//            student2s.add(new Student2(name,kor,eng,math));
//        }
//        for (Student2 student2 : student2s) {
//            bw.write(student2.name+"\n");
//        }
//        Collections.sort(student2s, new Comparator<Student2>() {
//            @Override
//            public int compare(Student2 s1, Student2 s2) {
//                // 앞의 수가 더 크면 양수->두 객체 위치를 바꾸어 정렬
//                // 음수나 0 -> 위치 바꾸지 않음
//                if (s1.kor != s2.kor) {
//                    return s2.kor - s1.kor;
//                }
//                else if (s1.eng != s2.eng) {
//                    return s2.eng - s1.eng;
//                }
//                else if (s1.math != s2.math) {
//                    return s2.math - s1.math;
//                }
//                else {
//                    // 이름을 사전순으로 정렬
//                    return s1.name.compareTo(s2.name);
//                }
//            }
//        });
//        for (Student2 student2 : student2s) {
//            bw.write(student2.name+"\n");
//        }
//        bw.flush();
//        bw.close();
//
//    }
//
//    public static int stoi(String str) {
//        return Integer.parseInt(str);
//    }
//}
