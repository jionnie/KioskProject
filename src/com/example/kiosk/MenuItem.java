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
     * getter 메소드
     * id 값을 얻는다.
     */
    public int getId() {
        return id;
    }

    /**
     * getter 메소드
     * name 값을 얻는다.
     */
    public String getName() {
        return name;
    }

    /**
     * getter 메소드
     * price 값을 얻는다.
     */
    public int getPrice() {
        return price;
    }

    /**
     * getter 메소드
     * description 값을 얻는다.
     */
    public String getDescription() {
        return description;
    }

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
}
