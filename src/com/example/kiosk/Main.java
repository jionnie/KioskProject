package com.example.kiosk;

import java.util.List;

/**
 * 프로그램을 실행하는 Main 클래스
 * Kiosk 객체를 생성하고 start() 메소드 실행
 *
 * @author jiwon jung
 */
public class Main {
    public static void main(String[] args) {
        MenuRepository menuRepository = new MenuRepository();
        List<Menu> menus = menuRepository.getMenus();

        Kiosk kiosk = new Kiosk(menus);
        kiosk.start();
    }
}