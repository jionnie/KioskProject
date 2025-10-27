package com.example.kiosk;

import java.util.ArrayList;
import java.util.List;

/**
 * MenuItem 클래스를 관리하는 클래스
 * 예를 들어, 버거 메뉴, 음료 메뉴 등 각 카테고리 내에 여러 MenuItem을 포함한다.
 *
 * @author jiwon jung
 */
public class Menu {
    private List<MenuItem> menuItems = new ArrayList<>(); // 메뉴를 저장하는 컬렉션 필드
    private int id;
    private String category;

    /**
     * 새로운 카테고리를 생성한다.
     *
     * @param id 카테고리 번호(고유 식별자)
     * @param category 카테고리 이름
     */
    public Menu(int id, String category) {
        this.id = id;
        this.category = category;
    }

    /**
     * 해당 카테고리의 상세 메뉴를 반환한다.
     * 원본의 보호를 위해 복사본을 반환한다.
     *
     * @return menuItems 복사본을 리턴
     */
    public List<MenuItem> getMenuItems() {
        return new ArrayList<>(menuItems);
    }

    /**
     * id 값을 얻는다.
     *
     * @return id 카테고리 번호(고유 식별자)
     */
    public int getId() {
        return id;
    }

    /**
     * category 값을 얻는다.
     *
     * @return category 카테고리 이름
     */
    public String getCategory() {
        return category;
    }

    /**
     * toString() 메소드 오버라이딩
     * 
     * @return id + ". " + 카테고리가 결합된 문자열
     */
    @Override
    public String toString() {
        return id + ". " + category;
    }

    /**
     * 상세 메뉴를 menuItems에 추가하는 메소드
     * 
     * @param menuItem 상세 메뉴
     */
    public void addItem(MenuItem menuItem) {
        menuItems.add(menuItem);
    }

    /**
     * 상세 메뉴를 출력하는 메소드
     */
    public void printMenuItems() {
        System.out.println("===================== [ " + category.toUpperCase() + " MENU ] =====================");
        for (MenuItem item : menuItems) {
            System.out.println(item.toString());
        }
        System.out.println("0. 종료         | 종료");
        System.out.println("===========================================================");
    }
}
