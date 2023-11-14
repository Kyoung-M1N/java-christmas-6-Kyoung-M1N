package christmas.controller;

import java.util.HashMap;
import java.util.Map;
import christmas.model.Event;
import christmas.model.Menu;

public class EventController {
    public static Map<Event, Integer> eventCount(Map<Menu, Integer> order, int date) {
        Map<Event, Integer> benefit = new HashMap<Event, Integer>();
        if (DateController.isWeekend(date)) {
            weekendDiscountEvent(order, benefit);
        } else if (!DateController.isWeekend(date)) {
            weekdayDiscountEvent(order, benefit);
        }
        christmasDdayEvent(date, benefit);
        presentationEvent(order, benefit);
        specialDiscountEvent(date, benefit);
        return benefit;
    }

    private static void presentationEvent(Map<Menu, Integer> order, Map<Event, Integer> benefit) {
        int price = 0;
        for (Menu menu : order.keySet()) {
            price += menu.getPrice() * order.get(menu);
        }
        if (price >= 120000) {
            benefit.put(Event.PRESENTATION, Menu.CHAMPAGNE.getPrice());
        }
    }

    private static void christmasDdayEvent(int date, Map<Event, Integer> benefit) {
        int benefitPrice = 0;
        if (date <= 25) {
            benefitPrice = 1000 + (date - 1) * 100;
            benefit.put(Event.D_DAY_DISCOUNT, benefitPrice);
        }
    }

    private static void weekdayDiscountEvent(Map<Menu, Integer> menuList, Map<Event, Integer> benefit) {
        int benefitPrice = 0;
        for (Menu menu : menuList.keySet()) {
            if (Menu.isDessert(menu)) {
                benefitPrice += menuList.get(menu) * 2023;
            }
        }
        if (benefitPrice != 0) {
            benefit.put(Event.WEEKDAY_DISCOUNT, benefitPrice);
        }
    }

    private static void weekendDiscountEvent(Map<Menu, Integer> menuList, Map<Event, Integer> benefit) {
        int benefitPrice = 0;
        for (Menu menu : menuList.keySet()) {
            if (Menu.isMainDish(menu)) {
                benefitPrice += menuList.get(menu) * 2023;
            }
        }
        if (benefitPrice != 0) {
            benefit.put(Event.WEEKEND_DISCOUNT, benefitPrice);
        }
    }

    private static void specialDiscountEvent(int date, Map<Event, Integer> benefit) {
        int benefitPrice = 0;
        if (DateController.isChristmas(date) || DateController.isSunday(date)) {
            benefitPrice = 1000;
        }
        if (benefitPrice != 0) {
            benefit.put(Event.SPECIAL_DISCOUNT, benefitPrice);
        }
    }
}
