package christmas.view;

import christmas.model.Event;
import christmas.model.Menu;

import java.text.DecimalFormat;
import java.util.Map;

public class OutputView {
    private static final String INTRO_MESSAGE = "안녕하세요! 우테코 식당 12월 이벤트 플래너입니다.";
    private static final String PREVIEW_MESSAGE = "12월 %d일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!\n\n";
    private static final String MENU_PRINT = "%s %d개\n";
    private static final String PRICE = "%s원\n";
    private static final DecimalFormat formatter = new DecimalFormat("#,###,###");

    public static void printIntroMessage() {
        System.out.println(INTRO_MESSAGE);
    }

    public static void printMenu(Map<Menu, Integer> order, int date) {
        System.out.printf(PREVIEW_MESSAGE, date);
        System.out.println("<주문 메뉴>");

        for (Menu menu : order.keySet()) {
            System.out.printf(MENU_PRINT, menu.getName(), order.get(menu));
        }
    }

    public static int printPrice(Map<Menu, Integer> order) {
        System.out.println("\n<할인 전 총주문 금액>");
        int price = 0;
        for (Menu menu : order.keySet()) {
            price += (menu.getPrice() * order.get(menu));
        }
        System.out.println(formatter.format(price));
        return price;
    }

    public static void printPresentation(Map<Event, Integer> benefit) {
        String presentation = "없음";
        System.out.println("\n<증정 메뉴>");
        if (benefit.containsKey(Event.PRESENTATION)) {
            presentation = Menu.CHAMPAGNE.getName();
        }
        System.out.println(presentation);
    }

    public static void printBenefits(Map<Event, Integer> benefit) {
        System.out.println("\n<혜택 내역>");
        if (benefit.isEmpty()) {
            System.out.println("없음");
        } else if (!benefit.isEmpty()) {
            for (Event event : benefit.keySet()) {
                System.out.printf("%s: -" + PRICE, event.getName(), formatter.format(benefit.get(event)));
            }
        }

    }

    public static int printBenefitPrice(Map<Event, Integer> benefit) {
        int benefitPrice = 0;
        System.out.println("\n<총혜택 금액>");
        for (Event event : benefit.keySet()) {
            benefitPrice += benefit.get(event);
        }
        System.out.printf(PRICE, formatter.format(benefitPrice));
        return benefitPrice;
    }

    public static void printPayment(int price, int discount) {
        System.out.println("\n<할인 후 예상 결제 금액>");
        System.out.printf(PRICE, formatter.format(price - discount));
    }

    public static void printBadge(int discount) {
        String badge = "없음";
        if (discount >= 5000 && discount < 10000) {
            badge = "별";
        } else if (discount >= 10000 && discount < 20000) {
            badge = "트리";
        } else if (discount >= 20000) {
            badge = "산타";
        }
        System.out.println("\n<12월 이벤트 배지>");
        System.out.println(badge);
    }
}
