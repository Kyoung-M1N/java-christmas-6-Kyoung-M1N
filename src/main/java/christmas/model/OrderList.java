package christmas.model;

import java.util.Map;

public class OrderList {
    Map<Menu, Integer> orders;

    OrderList(Map<Menu, Integer> orders) {
        this.orders = orders;
    }

}
