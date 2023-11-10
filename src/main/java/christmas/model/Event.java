package christmas.model;

import java.util.Arrays;

public enum Event {
    D_DAY_DISCOUNT("크리스마스 디데이 할인"),
    WEEKDAY_DISCOUNT("평일 할인"),
    WEEKEND_DISCOUNT("주말 할인"),
    SPECIAL_DISCOUNT("특별 할인"),
    PRESENTATION("증정 이벤트"),
    NONE("없음");

    private final String name;

    Event(final String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static Event getEvent(String name) {
        return Arrays.stream(values())
                .filter(event -> event.name.equals(name))
                .findAny()
                .orElse(NONE);
    }
}