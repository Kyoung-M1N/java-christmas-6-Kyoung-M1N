package christmas.view;

import static java.lang.System.out;

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
        out.println(INTRO_MESSAGE);
    }

    public static void printMenu(Map<Menu, Integer> order, int date) {
        out.printf(PREVIEW_MESSAGE, date);
        out.println("<주문 메뉴>");

        for (Menu menu : order.keySet()) {
            out.printf(MENU_PRINT, menu.getName(), order.get(menu));
        }
    }

    public static void printPrice(int price) {
        out.println("\n<할인 전 총주문 금액>");
        out.println(formatter.format(price));
    }

    public static void printPresentation(Map<Event, Integer> benefit) {
        String presentation = "없음";
        out.println("\n<증정 메뉴>");
        if (benefit.containsKey(Event.PRESENTATION)) {
            presentation = Menu.CHAMPAGNE.getName();
        }
        out.println(presentation);
    }

    public static void printBenefits(Map<Event, Integer> benefit) {
        out.println("\n<혜택 내역>");
        if (benefit.isEmpty()) {
            out.println("없음");
        } else if (!benefit.isEmpty()) {
            for (Event event : benefit.keySet()) {
                out.printf("%s: -" + PRICE, event.getName(), formatter.format(benefit.get(event)));
            }
        }
    }

    public static void printBenefitPrice(int discount) {
        out.println("\n<총혜택 금액>");
        out.printf(PRICE, formatter.format(discount));
    }

    public static void printPayment(int price, int discount) {
        out.println("\n<할인 후 예상 결제 금액>");
        out.printf(PRICE, formatter.format(price - discount));
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
        out.println("\n<12월 이벤트 배지>");
        out.println(badge);
    }
}
