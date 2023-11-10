package christmas.controller;

public class EventController {
    public static boolean presentationEvent(int price) {
        if (price >= 120000) {
            return true;
        }
        return false;
    }
}
