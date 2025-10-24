package com.example.kiosk;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 키오스크 프로그램의 메뉴를 관리하고 사용자 입력을 처리하는 클래스
 *
 * @author jiwon jung
 */
public class Kiosk {
    List<MenuItem> menuItems = new ArrayList<>(); // 메뉴 아이템을 관리하는 컬렉션 필드 선언

    /**
     * Kiosk 객체 생성 시 menuItems에 항목들을 추가
     */
    public Kiosk() {
        menuItems.add(new MenuItem(1, "ShackBurger", 6900, "토마토, 양상추, 쉑소스가 토핑된 치즈버거"));
        menuItems.add(new MenuItem(2, "ShackBurger", 8900, "베이컨, 체리 페어에 쉑소스가 토핑된 치즈버거"));
        menuItems.add(new MenuItem(3, "ShackBurger", 6900, "포테이토 번과 비프패티, 치즈가 토핑된 치즈버거"));
        menuItems.add(new MenuItem(4, "ShackBurger", 5400, "비프패티를 기반으로 야채가 들어간 기본버거"));
    }

    /**
     * 사용자의 입력과 처리를 반복하는 메소드
     * selectMenu()와 printSelectedMenu()를 호출한다.
     */
    public void start() {

        printMenu(); // 메뉴 출력 메소드 호출(책임 분리)

        while (true) {
            int menuSelect = 0;
            try {
                menuSelect = selectMenu(); // 메뉴 선택 메소드 호출
                printSelectedMenu(menuSelect); // 선택한 메뉴 출력하는 메소드 호출
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    /**
     * 콘솔에 메뉴를 출력하는 메소드
     */
    public void printMenu() {
        System.out.println("==================== [ SHAKESHACK MENU ] ====================");
        for (MenuItem menuItem : menuItems) {
            System.out.println(menuItem.getId() + ". " + menuItem.getName() + " | " + menuItem.getPrice() + " | " + menuItem.getDescription());
        }
        System.out.println("0. 종료         | 종료");
        System.out.println("=============================================================");
    }

    /**
     * 메뉴를 선택하는 메소드
     *
     * @return menuSelect 선택한 메뉴 번호 반환
     */
    public int selectMenu() {
        Scanner sc = new Scanner(System.in);

        System.out.println();
        System.out.print("메뉴를 보고 번호를 선택하세요: ");

        int menuSelect = 0;
        try {
            menuSelect = Integer.parseInt(sc.nextLine());

            // 입력값이 0부터 menuItems에 저장된 메뉴 개수 - 1 사이의 숫자가 아니면 예외 터뜨리기
            if ((menuSelect < menuItems.get(0).getId()) || (menuSelect > menuItems.get(menuItems.size() - 1).getId())) {
                throw new IllegalArgumentException("메뉴판에 존재하는 메뉴를 선택해주세요.");
            }
        } catch (NumberFormatException e) {
            System.out.println("메뉴는 숫자를 입력해서 주문해주세요.");
        }
        return menuSelect;
    }

    /**
     * 선택한 메뉴를 출력하는 메소드
     *
     * @param menuSelect 사용자가 선택한 메뉴 번호
     */
    public void printSelectedMenu(int menuSelect) {
        switch (menuSelect) {
            case 1 -> System.out.println(menuItems.get(0).getId() + ". " + menuItems.get(0).getName() + " | " + menuItems.get(0).getPrice() + " | " + menuItems.get(0).getDescription());
            case 2 -> System.out.println(menuItems.get(1).getId() + ". " + menuItems.get(1).getName() + " | " + menuItems.get(1).getPrice() + " | " + menuItems.get(1).getDescription());
            case 3 -> System.out.println(menuItems.get(2).getId() + ". " + menuItems.get(2).getName() + " | " + menuItems.get(2).getPrice() + " | " + menuItems.get(2).getDescription());
            case 4 -> System.out.println(menuItems.get(3).getId() + ". " + menuItems.get(3).getName() + " | " + menuItems.get(3).getPrice() + " | " + menuItems.get(3).getDescription());
            case 0 -> System.exit(0);
        }
    }
}