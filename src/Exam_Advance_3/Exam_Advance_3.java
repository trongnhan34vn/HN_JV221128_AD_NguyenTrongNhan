package Exam_Advance_3;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Exam_Advance_3 {
    public static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        Queue<String> listParentNames = new LinkedList<>();
        while(true) {
            System.out.println("****************JAVA-HACKATHON-05-ADVANCE-1-MENU***************\n" +
                    "1. Nhập tên phụ huynh nộp hồ sơ\n" +
                    "2. Phụ huynh tiếp theo\n" +
                    "3. Thoát");
            System.out.println("Nhập lựa chọn: ");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    System.out.println("Nhập tên phụ huynh nộp hồ sơ: ");
                    String parentName = scanner.nextLine();
                    listParentNames.add(parentName);
                    System.out.println("Lưu vào danh sách thành công!");
                    break;
                case 2:
                    if (listParentNames.isEmpty()) {
                        System.out.println("Hết danh sách!");
                    } else {
                        System.out.println(listParentNames.poll());
                    }
                    break;
                case 3:
                    System.exit(0);
                    break;
            }
        }
    }
}
