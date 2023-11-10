package christmas.domain;

import java.util.Map;

import christmas.controller.EventController;
import christmas.model.Menu;
import christmas.view.InputView;
import christmas.view.OutputView;

public class EventPlanner {
    public static void run() {
        try {
            int date = InputView.readDate();
            Map<Menu, Integer> orderList = InputView.order();
            OutputView.printMenu(orderList, date);
            int price = OutputView.printPrice(orderList);
            OutputView.printPresentation(EventController.presentationEvent(price));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
