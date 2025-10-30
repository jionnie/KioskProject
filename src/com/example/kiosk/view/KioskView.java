package com.example.kiosk.view;

import com.example.kiosk.domain.Menu;
import com.example.kiosk.domain.MenuItem;
import com.example.kiosk.domain.PersonType;
import com.example.kiosk.domain.ShoppingCart;

import java.util.List;

/**
 * 키오스크 프로그램의 view를 담당하는 클래스
 *
 * @author jiwon jung
 */
public class KioskView {
    private List<Menu> menus;
    private ShoppingCart shoppingCart;

    public KioskView(List<Menu> menus, ShoppingCart shoppingCart) {
        this.menus = menus;
        this.shoppingCart = shoppingCart;
    }

    /**
     * 카테고리를 출력하는 메소드
     * 장바구니 리스트를 매개값으로 받아 empty 여부에 따라 카테고리 다르게 출력
     *
     * @param cart 장바구니에 담긴 MenuItem 리스트
     */
    public void showCategory(List<MenuItem> cart) {
        System.out.println();
        System.out.println("====================== [ MAIN MENU ] ======================");
        for (Menu menu : menus) { // 장바구니에 항목이 없을 경우 여기만 출력
            System.out.println(menu.toString());
        }

        if (!cart.isEmpty()) { // 장바구니에 항목이 있을 경우 여기까지 출력
            System.out.println("====================== [ ORDER MENU ] =====================");
            System.out.println("4. Orders");
            System.out.println("5. Cancel");
        }
        System.out.println("0. 종료");
    }

    /**
     * 상세 메뉴를 출력하는 메소드
     *
     * @param category 사용자가 선택한 카테고리 번호
     */
    public void showMenuItems(int category) {
        System.out.println();

        Menu menu = menus.get(category - 1); // 사용자가 선택한 카테고리의 Menu 객체 가져오기

        System.out.println("===================== [ " + menu.getCategory().toUpperCase() + " MENU ] =====================");

        menu.getMenuItems().stream()
                .map(MenuItem :: toString)
                .forEach(System.out :: println);

        System.out.println("0. 뒤로가기");
    }

    /**
     * 선택한 메뉴를 출력하는 메소드
     *
     * @param category 사용자가 선택한 카테고리 번호
     * @param detailMenu 사용자가 선택한 상세 메뉴 번호
     */
    public void showSelectedMenu(int category, int detailMenu) {
        Menu menu = menus.get(category - 1); // 사용자가 선택한 카테고리의 Menu 객체 가져오기

        for (MenuItem item : menu.getMenuItems()) {
            if (item.getId() == detailMenu) {
                System.out.println("선택: " + item.toString());
                break;
            }
        }
        System.out.println();
    }

    /**
     * 장바구니를 콘솔에 출력하고 사용자 입력을 받는 메소드
     *
     * @param category 사용자가 선택한 카테고리 번호
     * @param detailMenu 사용자가 선택한 상세 메뉴 번호
     */
    public void showAddToCartConfirmation(int category, int detailMenu) {
        Menu menu = menus.get(category - 1); // 사용자가 선택한 카테고리의 Menu 객체 가져오기

        for (MenuItem item : menu.getMenuItems()) {
            if (item.getId() == detailMenu) {

                System.out.println("===========================================================");
                System.out.println(item.toString());
                System.out.println("===========================================================");
                break;
            }
        }
    }

    /**
     * 장바구니를 출력하는 메소드
     */
    public void showShoppingCartList() {

        System.out.println("======================= [ ORDERS ] ========================");
        for (MenuItem menuItem : shoppingCart.getCart()) {
            System.out.printf("%d. %s | %s | %s\n", menuItem.getId(), menuItem.getName(), menuItem.getPrice(), menuItem.getDescription());
        }
    }

    /**
     * 할인 정보를 출력하는 메소드
     */
    public void showDiscountInformation() {
        System.out.println("\n====================== [ DISCOUNT ] =======================");

        int i = 1;
        for (PersonType type : PersonType.values()) {
            System.out.println(i + ". " + type.getPersonType() + ": " + type.getDiscountPercent() + "%");
            i++;
        }
    }
}
