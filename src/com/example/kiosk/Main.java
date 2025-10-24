package com.example.kiosk;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * 프로그램을 실행하는 Main 클래스
 * @author jiwon jung
 */
public class Main {

    public static void main(String[] args) {
        Kiosk kiosk = new Kiosk();

        kiosk.start();
    }
}
