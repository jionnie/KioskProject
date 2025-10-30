package com.example.kiosk.domain;

public enum PersonType implements DiscountPolicy {
    NORMAL("일반", 0) {
        @Override
        public int discount(int price) {
            return 0;
        }
    },
    STUDENT("학생", 3) {
        @Override
        public int discount(int price) {
            return (int) Math.round(price * 0.03);
        }
    },
    SOLDIER("군인", 5) {
        @Override
        public int discount(int price) {
            return (int) Math.round(price * 0.05);
        }
    };

    private final int discountPercent;
    private final String personType;

    PersonType(String personType, int discountPercent) {
        this.discountPercent = discountPercent;
        this.personType = personType;
    }

    public String getPersonType() {
        return personType;
    }

    public int getDiscountPercent() {
        return discountPercent;
    }
}
