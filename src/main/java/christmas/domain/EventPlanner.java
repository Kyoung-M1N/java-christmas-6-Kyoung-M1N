package christmas.domain;

import java.util.Map;
import christmas.controller.EventController;
import christmas.view.OutputView;
import christmas.view.InputView;
import christmas.model.Event;
import christmas.model.Menu;

public class EventPlanner {
    public static void run() {
        try {
            OutputView.printIntroMessage();
            int date = InputView.readDate();
            Map<Menu, Integer> orderList = InputView.order();
            int price = calculatePrice(orderList);
            Map<Event, Integer> benefitList = EventController.eventCount(orderList, date);
            OutputView.printMenu(orderList, date);
            printEventResult(benefitList, price);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static int calculatePrice(Map<Menu, Integer> orderList) {
        int price = 0;
        for (Menu menu : orderList.keySet()) {
            price += menu.getPrice() * orderList.get(menu);
        }
        return price;
    }

    private static int calculateDiscount(Map<Event, Integer> benefitList) {
        int discount = 0;
        for (Event event : benefitList.keySet()) {
            discount += benefitList.get(event);
        }
        return discount;
    }

    private static void printEventResult(Map<Event, Integer> benefitList, int price) {
        int discount = calculateDiscount(benefitList);
        OutputView.printPrice(price);
        OutputView.printPresentation(benefitList);
        OutputView.printBenefits(benefitList);
        OutputView.printBenefitPrice(discount);
        OutputView.printPayment(price, discount);
        OutputView.printBadge(discount);
    }
}
