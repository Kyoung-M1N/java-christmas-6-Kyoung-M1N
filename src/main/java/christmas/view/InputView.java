package christmas.view;

import camp.nextstep.edu.missionutils.Console;
import christmas.validators.DateValidator;
import christmas.validators.MenuValidator;
import christmas.model.Menu;
import java.util.Map;

public class InputView {
    private static final String INPUT_DATE_MESSAGE = "12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)";
    private static final String INPUT_MENU_MESSAGE = "주문하실 메뉴를 메뉴와 개수를 알려 주세요. (e.g. 해산물파스타-2,레드와인-1,초코케이크-1)";

    public static int readDate() {
        System.out.println(INPUT_DATE_MESSAGE);
        return DateValidator.validate(Console.readLine());
    }

    public static Map<Menu, Integer> order() {
        System.out.println(INPUT_MENU_MESSAGE);
        return MenuValidator.validate(Console.readLine());
    }
}
