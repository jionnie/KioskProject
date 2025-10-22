package com.example.kiosk;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("==================== [ SHAKESHACK MENU ] ====================");
            System.out.println("1. ShackBurger  | W 6.9 | 토마토, 양상추, 쉑소스가 토핑된 치즈버거");
            System.out.println("2. ShackBurger  | W 8.9 | 베이컨, 체리 페어에 쉑소스가 토핑된 치즈버거");
            System.out.println("3. ShackBurger  | W 6.9 | 포테이토 번과 비프패티, 치즈가 토핑된 치즈버거");
            System.out.println("4. ShackBurger  | W 5.4 | 비프패티를 기반으로 야채가 들어간 기본버거");
            System.out.println("0. 종료          | 종료");
            System.out.println("=============================================================");

            System.out.println();
            System.out.print("메뉴를 보고 번호를 선택하세요: ");

            try {
                int menuSelect = sc.nextInt();

                switch (menuSelect) {
                    case 1 -> System.out.println("1. ShackBurger  | W 6.9 | 토마토, 양상추, 쉑소스가 토핑된 치즈버거");
                    case 2 -> System.out.println("2. ShackBurger  | W 8.9 | 베이컨, 체리 페어에 쉑소스가 토핑된 치즈버거");
                    case 3 -> System.out.println("3. ShackBurger  | W 6.9 | 포테이토 번과 비프패티, 치즈가 토핑된 치즈버거");
                    case 4 -> System.out.println("4. ShackBurger  | W 5.4 | 비프패티를 기반으로 야채가 들어간 기본버거");
                    case 0 -> {
                        sc.close();
                        System.exit(0);
                    }
                    default -> System.out.println("존재하지 않는 메뉴입니다.");
                }
                System.out.println();
            } catch (InputMismatchException e) {
                System.out.println("올바른 메뉴를 선택해주세요.");
                System.out.println();
                sc.nextLine(); // 버퍼 비우기
            }
        }

    }
}
