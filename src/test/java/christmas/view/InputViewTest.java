package christmas.view;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.entry;

import java.io.ByteArrayInputStream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import christmas.model.Menu;

public class InputViewTest {
    private final static String date = "25";
    private final static String order = "시저샐러드-2,제로콜라-2,티본스테이크-2";

    @DisplayName("날짜 입력시 반환값에 대한 검증")
    @Test
    void readDateTest() {
        System.setIn(new ByteArrayInputStream(date.getBytes()));
        assertThat(InputView.readDate()).isEqualTo(25);
    }

    @DisplayName("메뉴 입력시 반환값에 대한 검증")
    @Test
    void orderTest() {
        System.setIn(new ByteArrayInputStream(order.getBytes()));
        assertThat(InputView.order())
                .contains(entry(Menu.CAESAR_SALAD, 2),
                        entry(Menu.ZERO_COKE, 2),
                        entry(Menu.T_BONE_STEAK, 2));
    }
}
