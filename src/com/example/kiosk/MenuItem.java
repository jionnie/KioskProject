package com.example.kiosk;

/**
 * 개별 음식 항목을 관리하는 클래스
 * @author jiwon jung
 */
public class MenuItem {
    private int id;
    private String name;
    private int price;
    private String description;

    /**
     * 새로운 메뉴를 생성한다.
     *
     * @param id 메뉴 번호(고유 식별자)
     * @param name 메뉴 이름
     * @param price 메뉴 가격(단위: 원)
     * @param description 메뉴 설명
     */
    public MenuItem(int id, String name, int price, String description) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.description = description;
    }

    /**
     * id 값을 얻는다.
     *
     * @return id 메뉴 번호(고유 식별자)
     */
    public int getId() {
        return id;
    }

    /**
     * name 값을 얻는다.
     *
     * @return name 메뉴 이름
     */
    public String getName() {
        return name;
    }

    /**
     * price 값을 얻는다.
     *
     * @return price 메뉴 가격
     */
    public int getPrice() {
        return price;
    }

    /**
     * description 값을 얻는다.
     *
     * @return description 메뉴 설명
     */
    public String getDescription() {
        return description;
    }

    /**
     * toString() 메소드 오버라이딩
     * "1. ShackBurger | 6900 | 토마토, 양상추, 쉑소스가 토핑된 치즈버거"와 같은 형식으로 리턴
     *
     * @return 번호 + ". " + 메뉴명 + " | " + 가격 + " | " + 설명을 결합한 문자열
     */
    @Override
    public String toString() {
        return getId() + ". " + getName() + " | " + getPrice() + " | " + getDescription();
    }
}
