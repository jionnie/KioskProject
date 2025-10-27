package com.example.kiosk;

import java.util.List;
import java.util.Scanner;

/**
 * 키오스크 프로그램의 메뉴를 관리하고 사용자 입력을 처리하는 클래스
 *
 * @author jiwon jung
 */
public class Kiosk {
    private final Scanner sc = new Scanner(System.in);
    private List<Menu> menus; // Menu 객체를 저장하는 리스트 선언
    private final KioskView kioskView = new KioskView();

    // 생성자 주입
    public Kiosk(List<Menu> menus) {
        this.menus = menus;
    }

    /**
     * 키오스크 로직을 실행하는 메소드
     */
    public void start() {

        while (true) {
            kioskView.printCategory();    // 카테고리 출력하는 메소드 호출

            int category = 0;

            try {
                category = kioskView.selectCategory(sc);    // 카테고리 입력 받는 메소드 호출
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

            kioskView.printMenuItems(category); // 선택한 카테고리의 상세 메뉴를 출력하는 메소드 호출
            
            int detailMenu = 0;

            try {
                detailMenu = kioskView.selectDetailMenu(sc, category);
            } catch (NumberFormatException e) {
                System.out.println("알림: 메뉴는 숫자를 입력해서 선택해주세요.\n");
                continue;
            }

            if (detailMenu == 0) { // 사용자 입력이 0이면 종료
                return;
            }

            Menu selectedCategory = menus.get(category - 1);

            if (detailMenu < selectedCategory.getMenuItems().get(0).getId() || detailMenu > selectedCategory.getMenuItems().get(selectedCategory.getMenuItems().size() - 1).getId()) {
                System.out.println("알림: 메뉴판에 존재하는 메뉴를 선택해주세요.\n");
                continue;
            }

            kioskView.printSelectedMenu(category, detailMenu);
        }
    }
}