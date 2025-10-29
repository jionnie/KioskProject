package com.example.kiosk.controller;

import com.example.kiosk.domain.Menu;
import com.example.kiosk.domain.MenuItem;
import com.example.kiosk.domain.PersonType;
import com.example.kiosk.domain.ShoppingCart;
import com.example.kiosk.view.KioskView;

import java.util.List;
import java.util.Scanner;

/**
 * 키오스크 프로그램의 핵심 로직을 관리하는 클래스
 *
 * @author jiwon jung
 */
public class Kiosk {
    private final Scanner sc = new Scanner(System.in);
    private List<Menu> menus; // Menu 객체를 저장하는 리스트 선언
    private ShoppingCart shoppingCart;
    private KioskView kioskView;

    // 생성자 주입
    public Kiosk(List<Menu> menus, ShoppingCart shoppingCart, KioskView kioskView) {
        this.menus = menus;
        this.shoppingCart = shoppingCart;
        this.kioskView = kioskView;
    }

    /**
     * 키오스크 로직을 실행하는 메소드
     */
    public void start() {

        while (true) {
            kioskView.showCategory(shoppingCart.getCart());    // 카테고리 출력하는 메소드 호출

            int category = 0; // 카테고리 선택을 입력받을 변수

            try {
                category = kioskView.getUserInput(sc);    // 사용자 입력 받는 메소드 호출
            } catch (NumberFormatException e) {
                System.out.println("알림: 카테고리는 숫자를 입력해서 선택해주세요.\n");
                continue;
            }

            if (category == 0) { // 사용자 입력이 0이면 종료
                sc.close();
                return;
            }
            
            if (shoppingCart.getCart().isEmpty()) { // 장바구니가 비어있으면
                if (!handleEmptyCart(category)) {
                    continue;
                }
            } else { // 장바구니에 항목이 존재한다면
                if (!handleNonEmptyCart(category)) {
                    continue;
                }
            }

            int detailMenu = 0; // 상세 메뉴 선택을 입력받을 변수

            try {
                detailMenu = kioskView.getUserInput(sc);
            } catch (NumberFormatException e) {
                System.out.println("알림: 메뉴는 숫자를 입력해서 선택해주세요.\n");
                continue;
            }

            if (detailMenu == 0) { // 사용자 입력이 0이면 뒤로가기
                System.out.println();
                continue;
            }

            Menu selectedCategory = menus.get(category - 1); // 사용자가 선택한 메뉴 카테고리 얻기
            List<MenuItem> menuItems = selectedCategory.getMenuItems(); // 사용자가 선택한 카테고리의 MenuItems 얻기

            if (detailMenu < 1 || detailMenu > menuItems.get(menuItems.size() - 1).getId()) {
                System.out.println("알림: 메뉴판에 존재하는 메뉴를 선택해주세요.\n");
                continue;
            }

            kioskView.showSelectedMenu(category, detailMenu); // 선택한 메뉴 출력하는 메소드 호출

            kioskView.showAddToCartConfirmation(category, detailMenu); // 장바구니에 추가할지 묻는 메소드 호출

            int isAdded = 0;

            try {
                isAdded = kioskView.getUserInput(sc);
            } catch (NumberFormatException e) {
                System.out.println("알림: 메뉴는 숫자를 입력해서 선택해주세요.\n");
                continue;
            }

            if (isAdded == 1) { // 1번 선택 시
                shoppingCart.addToCart(menuItems.get(detailMenu - 1)); // 장바구니에 추가
                System.out.println(menuItems.get(detailMenu - 1).getName() + "이(가) 장바구니에 추가되었습니다.");
                System.out.println();
            } else if (isAdded == 2) {
                System.out.println();
            } else {
                System.out.println("알림: 메뉴판에 존재하는 메뉴를 선택해주세요.\n");
            }
        }
    }

    /**
     * 장바구니가 비었을 때 분기 처리하는 메소드
     * 
     * @param category 사용자가 선택한 카테고리 번호
     * @return false 반환 시 start()에서 continue를 만나고, true 반환 시 정상 실행 흐름
     */
    public boolean handleEmptyCart(int category) {
        int lastCategory = menus.get(menus.size() - 1).getId(); // 마지막 카테고리 번호

        if (category < 1 || category > lastCategory) { // 첫 번째 카테고리 번호와 마지막 카테고리 번호 사이의 값이 아닐 경우
            System.out.println("알림: 메뉴판에 존재하는 카테고리를 선택해주세요.\n");
            return false;
        }
        kioskView.showMenuItems(category);
        return true;
    }

    /**
     * 장바구니가 비어있지 않을 때 분기 처리하는 메소드
     *
     * @param category 사용자가 선택한 카테고리 번호
     * @return false 반환 시 start()에서 continue를 만나고, true 반환 시 정상 실행 흐름
     */
    public boolean handleNonEmptyCart(int category) {
        int lastCategory = menus.get(menus.size() - 1).getId(); // 마지막 카테고리 번호

        if (category >= 1 && category <= lastCategory) { // 첫 번째 카테고리 번호와 마지막 카테고리 번호 사이의 값일 경우
            kioskView.showMenuItems(category);
        } else if (category == lastCategory + 1) { // 마지막 카테고리 다음 번호(Orders) 입력 시
            kioskView.showShoppingCartList(); // 장바구니 리스트 출력

            int order = 0;

            try {
                order = kioskView.getUserInput(sc); // 주문할지 말지 입력 받기
            } catch (NumberFormatException e) {
                System.out.println("알림: 메뉴는 숫자를 입력해서 선택해주세요.\n");
                return false;
            }

            if (order == 1) { // 1을 입력받으면 주문 완료

                kioskView.showDiscountInformation();

                int personType = 0;

                try {
                    personType = kioskView.getUserInput(sc);
                } catch (NumberFormatException e) {
                    System.out.println("알림: 메뉴는 숫자를 입력해서 선택해주세요.\n");
                }

                int discountedPrice = switch (personType) {
                   case 1 -> PersonType.NORMAL.discount(shoppingCart.getAmountToPay());
                   case 2 -> PersonType.STUDENT.discount(shoppingCart.getAmountToPay());
                   case 3 -> PersonType.SOLDIER.discount(shoppingCart.getAmountToPay());
                   default -> shoppingCart.getAmountToPay();
                };

                System.out.printf("주문이 완료되었습니다. 금액은 %d원입니다.", shoppingCart.getAmountToPay() - discountedPrice);
                System.out.println("\n");
                return false;
            } else if (order == 2) { // 2를 입력 받으면 메뉴판으로 돌아감
                System.out.println();
                return false;
            } else { // 그 외 숫자 입력 시 메인 메뉴로 돌아감
                System.out.println("알림: 메뉴판에 존재하는 번호를 선택해주세요.\n");
                return false;
            }
        } else if (category == lastCategory + 2) {
            return false;
        } else if (category == 0) { // 사용자 입력이 0이면 종료
            sc.close();
            System.exit(0);
        } else {
            System.out.println("알림: 메뉴판에 존재하는 카테고리를 선택해주세요.\n");
            return false;
        }

        return true;
    }
}