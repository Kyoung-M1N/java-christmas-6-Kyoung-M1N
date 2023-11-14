package christmas.controller;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class DateControllerTest {
    @DisplayName("입력받은 날짜가 크리스마스 당일인지에 대한 판별기능 테스트")
    @Test
    void isChristmasTest() {
        assertThat(DateController.isChristmas(25)).isEqualTo(true);
    }

    @DisplayName("입력받은 날짜가 일요일인지에 대한 판별기능 테스트")
    @Test
    void isSundayTest() {
        assertThat(DateController.isSunday(25)).isEqualTo(false);
    }

    @DisplayName("입력받은 날짜가 주말인지에 대한 판별기능 테스트")
    @Test
    void isWeekendTest() {
        assertThat(DateController.isWeekend(25)).isEqualTo(false);
    }
}
