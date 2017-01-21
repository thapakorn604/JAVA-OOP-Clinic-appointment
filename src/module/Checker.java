package module;

/**
 * Checker module use for validate input information
 *
 * @author Thapakorn
 */
public class Checker {

    public static boolean isLeapYear(int year) {
        if ((((year % 4) == 0) && ((year % 100) != 0)) || ((year % 400) == 0)) {
            return true;
        } else {
            return false;
        }
    }

    public static int endDayofMonth(int month, int year) {
        if (month == 2) {
            if (isLeapYear(year)) {
                return 29;
            } else {
                return 28;
            }
        } else if ((month == 1) || (month == 3) || (month == 5) || (month == 7) || (month == 8) || (month == 10) || (month == 12)) {
            return 31;
        } else {
            return 30;
        }
    }

    public static boolean checkAlphabet(String text) {
        for (int i = 0; i < text.length(); i++) {
            if (((text.charAt(i) < 'A') || (text.charAt(i) > 'Z')) && ((text.charAt(i) < 'a') || (text.charAt(i) > 'z'))) {
                return false;
            }
        }
        return true;
    }

    public static boolean checkNumber(String text) {
        for (int i = 0; i < text.length(); i++) {
            if ((text.charAt(i) < '0') || (text.charAt(i) > '9')) {
                return false;
            }
        }
        return true;
    }
}
