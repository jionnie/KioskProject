package com.example.kiosk;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<MenuItem> menuItems = new ArrayList<>();

        menuItems.add(new MenuItem(1, "ShackBurger", 6900, "토마토, 양상추, 쉑소스가 토핑된 치즈버거"));
        menuItems.add(new MenuItem(2, "ShackBurger", 8900, "베이컨, 체리 페어에 쉑소스가 토핑된 치즈버거"));
        menuItems.add(new MenuItem(3, "ShackBurger", 6900, "포테이토 번과 비프패티, 치즈가 토핑된 치즈버거"));
        menuItems.add(new MenuItem(4, "ShackBurger", 5400, "비프패티를 기반으로 야채가 들어간 기본버거"));

        System.out.println("==================== [ SHAKESHACK MENU ] ====================");
        for (MenuItem menuItem : menuItems) {
            System.out.println(menuItem.id + ". " + menuItem.name + " | " + menuItem.price + " | " + menuItem.description);
        }
        System.out.println("0. 종료         | 종료");
        System.out.println("=============================================================");

        while (true) {

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
            } catch (InputMismatchException e) {
                System.out.println("올바른 메뉴를 선택해주세요.");
                sc.nextLine(); // 버퍼 비우기
            }
        }

    }
}
