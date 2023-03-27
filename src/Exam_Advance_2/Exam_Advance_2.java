package Exam_Advance_2;

import java.util.Scanner;
import java.util.Stack;

public class Exam_Advance_2 {

    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String sentence = "";
        while (true) {
            System.out.println("****************JAVA-HACKATHON-05-ADVANCE-1-MENU***************\n" +
                    "1. Nhập câu\n" +
                    "2. Đảo ngược câu\n" +
                    "3. Thoát");
            System.out.println("Nhập vào lựa chọn: ");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    System.out.println("Nhập câu: ");
                    sentence = scanner.nextLine();
                    System.out.println("Câu ban đầu ---> " + sentence);
                    break;
                case 2:
                    if (sentence.length() == 0) {
                        System.out.println("Chưa có câu! Hãy nhập câu!");
                    } else {
                        reverseString(sentence);
                    }
                    break;
                case 3:
                    System.exit(0);
                    break;
                default:
                    break;
            }
        }
    }
    public static void reverseString(String string) {
        String[] stringArr = string.split(" ");
        Stack<String> wStack = new Stack<>();
        for (int i = 0; i < stringArr.length; i++) {
            wStack.push(stringArr[i]);
        }
        for (int i = 0; i < stringArr.length; i++) {
            stringArr[i] = wStack.pop();
        }
        String result = "";
        for (int i = 0; i < stringArr.length; i++) {
            result += " " + stringArr[i];
        }
        System.out.println("Câu đảo ngược ---> " + result);
    }
}
