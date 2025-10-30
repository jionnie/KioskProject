package com.example.kiosk.domain;

import java.util.ArrayList;
import java.util.List;

/**
 * 장바구니를 관리하는 클래스
 *
 * @author jiwon jung
 */
public class ShoppingCart {
    private List<MenuItem> cart = new ArrayList<>();

    /**
     * cart를 반환하는 메소드
     * 원본의 보호를 위해 복사본을 반환한다.
     *
     * @return cart 복사본을 리턴
     */
    public List<MenuItem> getCart() {
        return new ArrayList<>(cart);
    }

    /**
     * 장바구니에 메뉴를 추가하는 메소드
     *
     * @param menuItem 장바구니에 추가될 MenuItem
     */
    public void addToCart(MenuItem menuItem) {
        cart.add(menuItem);
    }

    /**
     * 장바구니에서 메뉴를 빼는 메소드
     *
     * @param id 사용자에게 입력받은 삭제할 메뉴 id
     */
    public void removeFromCart(int id) {
        MenuItem removed = cart.stream()
                .filter(menuItem -> menuItem.getId() == id)
                .findFirst()
                .orElse(null);

        cart.remove(removed);
    }

    /**
     * 지불해야할 총 금액을 계산하고 반환하는 메소드
     *
     * @param personType 사용자가 입력한 할인 적용 타입
     * @return amount 지불해야할 총 금액의 합
     */
    public int getAmountToPay(int personType) {
        int amount = 0;

        for (MenuItem menuItem : cart) {
            amount += menuItem.getPrice();
        }

        int discountedPrice = switch (personType) {
            case 1 -> PersonType.NORMAL.discount(amount);
            case 2 -> PersonType.STUDENT.discount(amount);
            case 3 -> PersonType.SOLDIER.discount(amount);
            default -> amount;
        };

        return amount - discountedPrice;
    }
}
