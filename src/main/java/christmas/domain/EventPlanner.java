package christmas.domain;

import java.util.Map;
import christmas.controller.EventController;
import christmas.model.Event;
import christmas.model.Menu;
import christmas.view.InputView;
import christmas.view.OutputView;

public class EventPlanner {
    public static void run() {
        try {
            OutputView.printIntroMessage();
            int date = InputView.readDate();
            Map<Menu, Integer> orderList = InputView.order();
            OutputView.printMenu(orderList, date);
            int price = OutputView.printPrice(orderList);
            Map<Event, Integer> benefitList = EventController.eventCount(orderList, date, price);
            printEventResult(benefitList, price);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    static void printEventResult(Map<Event, Integer> benefitList, int price) {
        OutputView.printPresentation(benefitList);
        OutputView.printBenefits(benefitList);
        int discount = OutputView.printBenefitPrice(benefitList);
        OutputView.printPayment(price, discount);
        OutputView.printBadge(discount);
    }
}
