package com.example.kiosk.service;

import com.example.kiosk.domain.Menu;
import com.example.kiosk.domain.MenuItem;
import com.example.kiosk.domain.ShoppingCart;
import com.example.kiosk.repository.MenuRepository;
import com.example.kiosk.view.KioskView;

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

        ShoppingCart shoppingCart = new ShoppingCart();
        KioskView kioskView = new KioskView(menus, shoppingCart);

        Kiosk kiosk = new Kiosk(menus, shoppingCart, kioskView);
        kiosk.start();
    }
}