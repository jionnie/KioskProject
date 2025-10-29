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
     * 지불해야할 총 금액을 계산하고 반환하는 메소드
     *
     * @return amount 지불해야할 총 금액의 합
     */
    public int getAmountToPay() {
        int amount = 0;

        for (MenuItem menuItem : cart) {
            amount += menuItem.getPrice();
        }

        return amount;
    }
}
