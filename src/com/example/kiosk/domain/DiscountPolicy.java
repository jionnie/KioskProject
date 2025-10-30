package com.example.kiosk.domain;

/**
 * 할인 정책 인터페이스
 *
 * @author jiwon jung
 */
public interface DiscountPolicy {
    int discount(int price);
}