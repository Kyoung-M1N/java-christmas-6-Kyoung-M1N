package christmas.validator;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import christmas.validators.DateValidator;

public class DateValidatorTest {
    @DisplayName("방문 날짜에 정수가 아닌 값이 입력되면 예외가 발생한다.")
    @Test
    void typeValidateTest() {
        assertThatThrownBy(() -> DateValidator.validate("d"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("방문 날짜에 1에서 31사이의 수가 아닌 값이 입력되면 예외가 발생한다.")
    @Test
    void rangeValidateTest() {
        assertThatThrownBy(() -> DateValidator.validate("35"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
