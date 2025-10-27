package com.example.kiosk;

import java.util.ArrayList;
import java.util.List;

/**
 * 메뉴 데이터를 초기화 하고 제공하는 클래스
 *
 * @author jiwon jung
 */
public class MenuRepository {
    private List<Menu> menus = new ArrayList<>();

    /**
     * 메뉴 데이터 생성 및 초기화
     */
    public MenuRepository() {
        Menu burgers = new Menu(1, "Burgers");
        Menu drinks = new Menu(2, "Drinks");
        Menu desserts = new Menu(3, "Desserts");

        burgers.addItem(new MenuItem(1, "ShackBurger", 6900, "토마토, 양상추, 쉑소스가 토핑된 치즈버거"));
        burgers.addItem(new MenuItem(2, "SmokeShack", 8900, "베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거"));
        burgers.addItem(new MenuItem(3, "Cheeseburger", 6900, "포테이토 번과 비프패티, 치즈가 토핑된 치즈버거"));
        burgers.addItem(new MenuItem(4, "Hamburger", 5400, "비프패티를 기반으로 야채가 들어간 기본버거"));

        drinks.addItem(new MenuItem(1, "Coke", 6900, "시원한 탄산이 터지는 코카콜라"));
        drinks.addItem(new MenuItem(2, "Sprite", 8900, "청량한 맛이 일품인 사이다"));
        drinks.addItem(new MenuItem(3, "Lemonade", 6900, "상큼한 자연의 맛을 담은 레모네이드"));
        drinks.addItem(new MenuItem(4, "Water", 5400, "담백하고 깔끔한 물"));

        desserts.addItem(new MenuItem(1, "Cookie", 6900, "바삭하게 구운 정통 쿠키"));
        desserts.addItem(new MenuItem(2, "Jelly", 8900, "식감이 매우 중독적인 젤리"));
        desserts.addItem(new MenuItem(3, "Bread", 6900, "고소하고 쫄깃한 빵"));
        desserts.addItem(new MenuItem(4, "Chocolate", 5400, "떨어진 당을 바로 채워주는 초콜릿"));

        menus.add(burgers);
        menus.add(drinks);
        menus.add(desserts);
    }

    /**
     * 상세 메뉴(MenuItem) 목록을 저장하는 리스트를 필드로 갖는 Menu를 요소로 갖는 리스트를 반환한다.
     * 원본의 보호를 위해 복사본을 반환한다.
     *
     * @return menus 메뉴 리스트 리턴
     */
    public List<Menu> getMenus() {
        return new ArrayList<>(menus);
    }
}
