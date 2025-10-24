package com.example.kiosk;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

/**
 * 프로그램을 실행하는 Main 클래스
 * @author jiwon jung
 */
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<MenuItem> menuItems = new ArrayList<>(); // 컬렉션 필드 선언

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

            int menuSelect = 0;
            try {
                menuSelect = sc.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("올바른 메뉴를 선택해주세요.");
                sc.nextLine(); // 버퍼 비우기
                continue; // 실행 흐름 이어가기
            }

            switch (menuSelect) {
                case 1 -> System.out.println(menuItems.get(0).id + ". " + menuItems.get(0).name + " | " + menuItems.get(0).price + " | " + menuItems.get(0).description);
                case 2 -> System.out.println(menuItems.get(1).id + ". " + menuItems.get(1).name + " | " + menuItems.get(1).price + " | " + menuItems.get(1).description);
                case 3 -> System.out.println(menuItems.get(2).id + ". " + menuItems.get(2).name + " | " + menuItems.get(2).price + " | " + menuItems.get(2).description);
                case 4 -> System.out.println(menuItems.get(3).id + ". " + menuItems.get(3).name + " | " + menuItems.get(3).price + " | " + menuItems.get(3).description);
                case 0 -> {
                    // 사용자가 0을 입력할 경우 리소스를 닫고 프로그램 종료
                    sc.close();
                    System.exit(0);
                }
                default -> System.out.println("존재하지 않는 메뉴입니다.");
            }
        }
    }
}
