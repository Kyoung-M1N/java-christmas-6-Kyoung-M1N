package christmas.view;

import christmas.model.Menu;
import java.util.Map;

public class OutputView {
    private static final String MENU_PRINT = "%s %d개\n";

    public static void printMenu(Map<Menu, Integer> order) {
        System.out.println("<주문 메뉴>");

        for (Menu menu : order.keySet()) {
            System.out.printf(MENU_PRINT, menu.getName(), order.get(menu));
        }
    }
}
