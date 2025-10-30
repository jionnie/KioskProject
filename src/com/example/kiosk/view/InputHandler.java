package com.example.kiosk.view;

import java.util.Scanner;

/**
 * 사용자 입력을 관리하는 클래스
 *
 * @author jiwon jung
 */
public class InputHandler {
    private final Scanner sc = new Scanner(System.in);

    /**
     * 사용자 입력을 받는 메소드
     *
     * @param message 입력 받기 전에 출력할 입력 유도 메세지
     * @return 사용자에게 입력받은 int 값
     */
    public int getUserInput(String message) {
        System.out.print(message);

        try {
            return Integer.parseInt(sc.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("알림: 메뉴는 숫자를 입력해서 선택해주세요.");
            return -1;
        }
    }

    /**
     * Scanner 자원을 닫는 메소드
     */
    public void close() {
        sc.close();
    }
}
