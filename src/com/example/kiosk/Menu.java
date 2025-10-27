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
     * MenuItem를 저장하는 리스트를 설정한다.
     * 
     * @param menuItems MenuItem을 요소로 갖는 리스트
     */
    public void setMenuItems(List<MenuItem> menuItems) {
        this.menuItems = menuItems;
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
     * id 값을 설정한다.
     *
     * @param id 카테고리 번호(고유 식별자)
     */
    public void setId(int id) {
        this.id = id;
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
     * category 값을 설정한다.
     *
     * @param category 카테고리 이름
     */
    public void setCategory(String category) {
        this.category = category;
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
}