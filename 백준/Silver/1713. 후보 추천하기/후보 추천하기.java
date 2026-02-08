import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Student implements Comparable<Student> {
    int num;   //학생번호
    int cnt;  //추천 수
    int timestamp;

    public Student(int num, int cnt, int timeStamp) {
        this.num = num;
        this.cnt = cnt;
        this.timestamp = timeStamp;
    }

    //추천 수, 기록 시간 정렬
    @Override
    public int compareTo(Student s) {
        int result = s.cnt - cnt;
        if (result == 0) {
            return s.timestamp - timestamp;
        }
        return result;
    }
}

public class Main {

    private static int N, total;
    private static List<Student> photo;
    private static Student[] students;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());  //사진 틀 개수
        total = Integer.parseInt(br.readLine());  //전체 학생 수

        students = new Student[101]; //학생 번호 100까지
        photo = new ArrayList<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < total; i++) {
            int s = Integer.parseInt(st.nextToken());

            if (students[s] != null) {
                //이미 사진이 있음
                students[s].cnt++;
            } else {
                //사진이 없음
                Collections.sort(photo);

                if (photo.size() == N) {
                    Student remove = photo.remove(N - 1);
                    students[remove.num] = null;  //지운 사진 null 처리
                }

                //새로운 학생 추가
                students[s] = new Student(s, 1, i);
                photo.add(students[s]);
            }
        }

        //출력
        StringBuilder sb = new StringBuilder();
        photo.sort((o1, o2) -> o1.num - o2.num);
        for (Student student : photo) {
            sb.append(student.num + " ");
        }
        System.out.println(sb);

    }
}
