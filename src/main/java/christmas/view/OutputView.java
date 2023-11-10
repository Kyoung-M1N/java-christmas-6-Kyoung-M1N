package christmas.view;

import christmas.model.Menu;

import java.text.DecimalFormat;
import java.util.Map;

public class OutputView {
    private static final String MENU_PRINT = "%s %d개\n";

    public static void printMenu(Map<Menu, Integer> order, int date) {
        System.out.printf("12월 %d일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!\n\n", date);
        System.out.println("<주문 메뉴>");

        for (Menu menu : order.keySet()) {
            System.out.printf(MENU_PRINT, menu.getName(), order.get(menu));
        }
    }

    public static int printPrice(Map<Menu, Integer> order) {
        System.out.println("\n<할인 전 총주문 금액>");
        DecimalFormat formatter = new DecimalFormat("#,###,###");
        int price = 0;
        for (Menu menu : order.keySet()) {
            price += (menu.getPrice() * order.get(menu));
        }
        System.out.println(formatter.format(price));
        return price;
    }

    public static void printPresentation(boolean isBenefited) {
        String presentation = "없음";
        System.out.println("\n<증정 메뉴>");
        if (isBenefited) {
            presentation = Menu.CHAMPAGNE.getName();
        }
        System.out.println(presentation);
    }
}
