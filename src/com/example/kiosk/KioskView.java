package com.example.kiosk;

import java.util.List;
import java.util.Scanner;

/**
 * 키오스크 프로그램의 view를 담당하는 클래스
 *
 * @author jiwon jung
 */
public class KioskView {
    private List<Menu> menus;

    public KioskView(List<Menu> menus) {
        this.menus = menus;
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
    public int selectCategory(Scanner sc) {

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
    public void printMenuItems(int category) {
        System.out.println();

        Menu menu = menus.get(category - 1); // 사용자가 선택한 카테고리의 Menu 객체 가져오기

        System.out.println("===================== [ " + menu.getCategory().toUpperCase() + " MENU ] =====================");
        for (MenuItem item : menu.getMenuItems()) {
            System.out.println(item.toString());
        }
        System.out.println("0. 종료         | 종료");
        System.out.println("===========================================================");
    }

    /**
     * 상세 메뉴를 선택하는 메소드
     *
     * @param category 사용자가 선택한 카테고리 번호
     * @return menuSelect 사용자가 선택한 상세 메뉴 번호
     */
    public int selectDetailMenu(Scanner sc, int category) {

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
