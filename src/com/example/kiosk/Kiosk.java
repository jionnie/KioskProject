package com.example.kiosk;

import java.util.List;
import java.util.Scanner;

/**
 * 키오스크 프로그램의 메뉴를 관리하고 사용자 입력을 처리하는 클래스
 *
 * @author jiwon jung
 */
public class Kiosk {
    private List<Menu> menus; // Menu 객체를 저장하는 리스트 선언

    // 생성자 주입
    public Kiosk(List<Menu> menus) {
        this.menus = menus;
    }

    /**
     * 키오스크 로직을 실행하는 메소드
     */
    public void start() {

        while (true) {
            printCategory();    // 카테고리 출력하는 메소드 호출

            int category = 0;

            try {
                category = selectCategory();    // 카테고리 입력 받는 메소드 호출
            } catch (NumberFormatException e) {
                System.out.println("알림: 카테고리는 숫자를 입력해서 선택해주세요.\n");
                continue;
            }

            if (category == 0) { // 사용자 입력이 0이면 종료
                return;
            }

            if (category < menus.get(0).getId() || category > menus.get((menus.size() - 1)).getId()) {
                System.out.println("알림: 메뉴판에 존재하는 카테고리를 선택해주세요.\n");
                continue;
            }

            printDetailMenu(category); // 선택한 카테고리의 상세 메뉴를 출력하는 메소드 호출
            
            int detailMenu = 0;

            try {
                detailMenu = selectDetailMenu(category);
            } catch (NumberFormatException e) {
                System.out.println("알림: 메뉴는 숫자를 입력해서 선택해주세요.\n");
                continue;
            }

            if (detailMenu == 0) {
                return;
            }

            if (detailMenu < menus.get(category - 1).getMenuItems().get(0).getId() || detailMenu > menus.get(category - 1).getMenuItems().get(menus.get(category - 1).getMenuItems().size() - 1).getId()) {
                System.out.println("알림: 메뉴판에 존재하는 메뉴를 선택해주세요.\n");
                continue;
            }

            printSelectedMenu(category, detailMenu);
        }
    }

    /**
     * 카테고리를 출력하는 메소드
     */
    public void printCategory() {
        System.out.println("====================== [ MAIN MENU ] ======================");
        for (Menu menu : menus) {
            System.out.println(menu.toString());
        }
        System.out.println("0. 종료");
        System.out.println("===========================================================");
    }

    /**
     * 카테고리를 선택하는 메소드
     *
     * @return 사용자가 선택한 카테고리 번호
     */
    public int selectCategory() {
        Scanner sc = new Scanner(System.in);

        System.out.print("카테고리를 보고 번호를 선택하세요: ");
        int category = 0;
        category = Integer.parseInt(sc.nextLine());

        return category;
    }

    /**
     * 상세 메뉴를 출력하는 메소드
     * 
     * @param category 사용자가 선택한 카테고리 번호
     */
    public void printDetailMenu(int category) {
        System.out.println();
        menus.get(category - 1).printMenuItems();
    }

    /**
     * 상세 메뉴를 선택하는 메소드
     *
     * @param category 사용자가 선택한 카테고리 번호
     * @return menuSelect 사용자가 선택한 상세 메뉴 번호
     */
    public int selectDetailMenu(int category) {
        Scanner sc = new Scanner(System.in);

        System.out.print("메뉴를 보고 번호를 선택하세요: ");
        int menuSelect = 0;
        menuSelect = Integer.parseInt(sc.nextLine());

        return menuSelect;
    }

    /**
     * 선택한 메뉴를 출력하는 메소드
     *
     * @param category 사용자가 선택한 카테고리 번호
     * @param detailMenu 사용자가 선택한 상세 메뉴 번호
     */
    public void printSelectedMenu(int category, int detailMenu) {
        Menu menu = menus.get(category - 1);

        for (MenuItem item : menu.getMenuItems()) {
            if (item.getId() == detailMenu) {
                System.out.println("선택: " + item.toString());
            }
        }
        System.out.println();
    }
}