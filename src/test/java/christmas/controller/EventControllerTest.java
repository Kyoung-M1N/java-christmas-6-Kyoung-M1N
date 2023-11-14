package christmas.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.entry;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import christmas.model.Event;
import christmas.model.Menu;

import java.util.Map;

public class EventControllerTest {
    private final static Map<Menu, Integer> order = Map.ofEntries(
            entry(Menu.CAESAR_SALAD, 2),
            entry(Menu.ZERO_COKE, 2),
            entry(Menu.T_BONE_STEAK, 2));
    private final static Map<Menu, Integer> noEventOrder = Map.ofEntries(
            entry(Menu.TAPAS, 1),
            entry(Menu.ZERO_COKE, 1));

    @DisplayName("입력받은 날짜와 메뉴에 따라 적용되는 이벤트에 대한 판별기능 테스트")
    @Test
    void eventDetermineTest() {
        assertThat(EventController.eventCount(order, 25))
                .contains(
                        entry(Event.D_DAY_DISCOUNT, 3400),
                        entry(Event.SPECIAL_DISCOUNT, 1000),
                        entry(Event.PRESENTATION, 25000));
    }

    @DisplayName("적용되는 이벤트가 없을 경우에 대한 판별기능 테스트")
    @Test
    void noEventTest() {
        assertThat(EventController.eventCount(noEventOrder, 26)).isEmpty();
    }
}
