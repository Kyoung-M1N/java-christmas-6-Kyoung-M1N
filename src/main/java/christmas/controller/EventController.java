package christmas.controller;

import java.util.HashMap;
import java.util.Map;

import christmas.model.Event;
import christmas.model.Menu;

public class EventController {
    public static Map<Event, Integer> eventCount(Map<Menu, Integer> order, int date, int price) {
        Map<Event, Integer> benefit = new HashMap<Event, Integer>();
        if (DateController.isWeekend(date)) {
            weekendDiscountEvent(order, benefit);
        } else if (!DateController.isWeekend(date)) {
            weekdayDiscountEvent(order, benefit);
        }
        christmasDdayEvent(date, benefit);
        presentationEvent(price, benefit);
        specialDiscountEvent(date, benefit);
        return benefit;
    }

    public static void presentationEvent(int price, Map<Event, Integer> benefit) {
        if (price >= 120000) {
            benefit.put(Event.PRESENTATION, Menu.CHAMPAGNE.getPrice());
        }
    }

    static void christmasDdayEvent(int date, Map<Event, Integer> benefit) {
        int benefitPrice = 0;
        if (date < 25) {
            benefitPrice = date * 100;
            benefit.put(Event.D_DAY_DISCOUNT, benefitPrice);
        }
    }

    static void weekdayDiscountEvent(Map<Menu, Integer> menuList, Map<Event, Integer> benefit) {
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

    static void weekendDiscountEvent(Map<Menu, Integer> menuList, Map<Event, Integer> benefit) {
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

    static void specialDiscountEvent(int date, Map<Event, Integer> benefit) {
        int benefitPrice = 0;
        if (DateController.isChristmas(date) || DateController.isSunday(date)) {
            benefitPrice = 1000;
        }
        if (benefitPrice != 0) {
            benefit.put(Event.SPECIAL_DISCOUNT, benefitPrice);
        }
    }
}
