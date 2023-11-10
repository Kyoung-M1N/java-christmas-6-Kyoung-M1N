package christmas.validators;

public class DateValidator {
    private static final String INVALID_DATE = "[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.";

    public static int validate(String input) {
        int date = validateType(input);
        validateRange(date);
        return date;
    }

    private static int validateType(String input) {
        int date;
        try {
            date = Integer.parseInt(input);
        } catch (Exception e) {
            throw new IllegalArgumentException(INVALID_DATE);
        }
        return date;
    }

    private static void validateRange(int input) {
        if (input < 1 || input > 31) {
            throw new IllegalArgumentException(INVALID_DATE);
        }
    }
}
