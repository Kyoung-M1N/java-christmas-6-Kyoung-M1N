package christmas.validators;

import christmas.model.Menu;
import java.util.HashMap;
import java.util.Map;
import java.util.List;

public class MenuValidator {
    private static final String INVALID_ORDER = "[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.";

    public static Map<Menu, Integer> validate(String input) {
        Map<Menu, Integer> order = validateDuplication(input.split(","));
        validateUnderTwenty(order);
        validateOnlyBeverage(order);
        return order;
    }

    static Map<Menu, Integer> validateDuplication(String[] input) {
        Map<Menu, Integer> orders = new HashMap<Menu, Integer>();
        for (String str : input) {
            String[] menu = str.split("-");
            if (orders.containsKey(Menu.getMenu(menu[0]))) {
                throw new IllegalArgumentException(INVALID_ORDER);
            }
            orders.put(validateExistance(Menu.getMenu(menu[0])), validateAmount(menu[1]));
        }
        return orders;

    }

    static Menu validateExistance(Menu menu) {
        List<Menu> menus = List.of(Menu.values());
        if (!menus.contains(menu) || menu.equals(Menu.NONE)) {
            throw new IllegalArgumentException(INVALID_ORDER);
        }
        return menu;
    }

    static int validateAmount(String input) {
        int amount;
        try {
            amount = Integer.parseInt(input);
        } catch (Exception e) {
            throw new IllegalArgumentException(INVALID_ORDER);
        }
        if (amount < 1) {
            throw new IllegalArgumentException(INVALID_ORDER);
        }
        return amount;
    }

    static void validateOnlyBeverage(Map<Menu, Integer> order) {
        boolean onlyBeverage = true;
        for (Menu menu : order.keySet()) {
            if (!Menu.isBeverage(menu)) {
                onlyBeverage = false;
            }
        }
        if (onlyBeverage) {
            throw new IllegalArgumentException(INVALID_ORDER);
        }
    }

    static void validateUnderTwenty(Map<Menu, Integer> order) {
        int totalAmount = 0;
        for (Integer amount : order.values()) {
            totalAmount += amount;
        }
        if (totalAmount > 20) {
            throw new IllegalArgumentException(INVALID_ORDER);
        }
    }
}
