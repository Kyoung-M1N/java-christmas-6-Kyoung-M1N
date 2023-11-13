package christmas.validator;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import christmas.validators.MenuValidator;

public class MenuValidatorTest {
    @DisplayName("메뉴 입력 시 중복된 값이 입력되면 예외가 발생한다.")
    @Test
    void duplicationValidateTest() {
        assertThatThrownBy(() -> MenuValidator.validate("초코케이크-2,초코케이크-1"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("메뉴 입력 시 주어진 메뉴에 없는 값이 입력되면 예외가 발생한다.")
    @Test
    void existanceValidateTest() {
        assertThatThrownBy(() -> MenuValidator.validate("만두전골-1,제로콜라-1"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("메뉴 입력 시 메뉴의 갯수에 정수가 아닌 값이 입력되면 예외가 발생한다.")
    @Test
    void amountValidateTest() {
        assertThatThrownBy(() -> MenuValidator.validate("제로콜라-d,초코케이크-2"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("메뉴 입력 시 음료만 입력된 경우 예외가 발생한다.")
    @Test
    void onlyBeverageeValidateTest() {
        assertThatThrownBy(() -> MenuValidator.validate("레드와인-1,제로콜라-1"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("메뉴 입력 시 총 메뉴의 갯수가 20개를 넘으면 입력되면 예외가 발생한다.")
    @Test
    void underTwentyValidateTest() {
        assertThatThrownBy(() -> MenuValidator.validate("제로콜라-5,티본스테이크-5,초코케이크-5,양송이수프-5,레드와인-2"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
