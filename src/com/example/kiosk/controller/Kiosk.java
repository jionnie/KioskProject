package com.example.kiosk.controller;

import com.example.kiosk.domain.Menu;
import com.example.kiosk.domain.MenuItem;
import com.example.kiosk.domain.PersonType;
import com.example.kiosk.domain.ShoppingCart;
import com.example.kiosk.view.InputHandler;
import com.example.kiosk.view.KioskView;

import java.util.List;

/**
 * 키오스크 프로그램의 핵심 로직을 관리하는 클래스
 *
 * @author jiwon jung
 */
public class Kiosk {
    private List<Menu> menus; // Menu 객체를 저장하는 리스트 선언
    private ShoppingCart shoppingCart;
    private KioskView kioskView;
    private InputHandler inputHandler;

    // 생성자 주입
    public Kiosk(List<Menu> menus, ShoppingCart shoppingCart, KioskView kioskView, InputHandler inputHandler) {
        this.menus = menus;
        this.shoppingCart = shoppingCart;
        this.kioskView = kioskView;
        this.inputHandler = inputHandler;
    }

    /**
     * 키오스크 로직을 실행하는 메소드
     */
    public void start() {

        while (true) {
            kioskView.showCategory(shoppingCart.getCart());    // 카테고리 출력하는 메소드 호출

            int category = inputHandler.getUserInput("카테고리 번호를 선택해주세요: ");    // 사용자 입력 받는 메소드 호출

            if (category == 0) { // 사용자 입력이 0이면 종료
                inputHandler.close();
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

            Menu selectedCategory = menus.get(category - 1); // 사용자가 선택한 메뉴 카테고리 얻기
            List<MenuItem> menuItems = selectedCategory.getMenuItems(); // 사용자가 선택한 카테고리의 MenuItems 얻기

            int detailMenu = inputHandler.getUserInput("메뉴를 담아주세요: ");

            if (detailMenu == 0) { // 사용자 입력이 0이면 뒤로가기
                continue;
            }

            if (detailMenu < 1 || detailMenu > menuItems.get(menuItems.size() - 1).getId()) {
                System.out.println("알림: 메뉴판에 존재하는 메뉴를 선택해주세요.");
                continue;
            }

            kioskView.showSelectedMenu(category, detailMenu); // 선택한 메뉴 출력하는 메소드 호출

            kioskView.showAddToCartConfirmation(category, detailMenu); // 장바구니에 추가할지 묻는 메소드 호출

            int isAdded = inputHandler.getUserInput("장바구니에 추가하시겠습니까? (1. 확인 | 2. 취소): ");

            if (isAdded == 1) { // 1번 선택 시
                shoppingCart.addToCart(menuItems.get(detailMenu - 1)); // 장바구니에 추가
                System.out.println(menuItems.get(detailMenu - 1).getName() + "이(가) 장바구니에 추가되었습니다.");
            } else if (isAdded == 2) {
                continue;
            } else {
                System.out.println("알림: 메뉴판에 존재하는 메뉴를 선택해주세요.");
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
            System.out.println("알림: 메뉴판에 존재하는 카테고리를 선택해주세요.");
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

            int order = inputHandler.getUserInput("이대로 주문하시겠습니까? (1. 주문 | 2. 메뉴판 | 3. 장바구니에서 삭제): ");

            if (order == 1) { // 1을 입력받으면 주문 완료

                kioskView.showDiscountInformation();

                int personType =  inputHandler.getUserInput("해당하는 할인 유형을 선택해주세요: ");

                if (personType < 1 || personType > PersonType.values().length - 1) {
                    System.out.println("알림: 메뉴판에 존재하는 번호를 선택해주세요.");
                    return false;
                }
                System.out.printf("주문이 완료되었습니다. 금액은 %d원입니다.", shoppingCart.getAmountToPay(personType));
                return false;
            } else if (order == 2) { // 2를 입력 받으면 메뉴판으로 돌아감
                return false;
            } else if (order == 3) { // 3을 입력받으면 장바구니에서 선택한 메뉴 삭제
                int removed = inputHandler.getUserInput("어떤 메뉴를 삭제하시겠습니까? ");
                shoppingCart.removeFromCart(removed); // 장바구니에서 삭제
                return false;
            } else { // 그 외 숫자 입력 시 메인 메뉴로 돌아감
                System.out.println("알림: 메뉴판에 존재하는 번호를 선택해주세요.");
                return false;
            }
        } else if (category == lastCategory + 2) {
            return false;
        } else if (category == 0) { // 사용자 입력이 0이면 종료
            inputHandler.close();
            System.exit(0);
        } else {
            System.out.println("알림: 메뉴판에 존재하는 카테고리를 선택해주세요.");
            return false;
        }

        return true;
    }
}