package module;

import java.util.Scanner;
import java.util.InputMismatchException;

/**
 * input module use to get and validate information from user
 *
 * @author Thapakorn
 */
public class Input {

    private Scanner scan;

    public Input() {
        scan = new Scanner(System.in);
    }

    public String inputString(String inputMSG, String errorMSG) {
        System.out.println(inputMSG);
        String input;
        input = scan.nextLine();
        if (input.isEmpty()) {
            System.out.println(errorMSG);
            input = inputString(inputMSG, errorMSG);
        }

        return input;
    }

    public char inputChar(String inputMSG, String errorMSG, char rule[]) {
        char input;
        System.out.println(inputMSG);
        try {
            input = scan.nextLine().charAt(0);
            boolean checkRule = false;
            for (char c : rule) {
                if (c == input) {
                    checkRule = true;
                }
            }
            if (checkRule == false) {
                System.out.println(errorMSG);
                input = inputChar(inputMSG, errorMSG, rule);
            }
        } catch (StringIndexOutOfBoundsException e) {
            System.out.println(errorMSG);
            input = inputChar(inputMSG, errorMSG, rule);
        }
        return input;
    }

    public int inputInt(String inputMSG, String errorMSG) {
        System.out.println(inputMSG);
        int input;
        try {
            input = scan.nextInt();
        } catch (InputMismatchException e) {
            scan.nextLine();
            System.out.println(errorMSG);
            input = inputInt(inputMSG, errorMSG);
        }
        return input;
    }

    public String inputName(String inputMSG, String errorMSG) {
        String input = inputString(inputMSG, errorMSG);
        if (Checker.checkAlphabet(input) == false) {
            System.out.println(errorMSG);
            input = inputName(inputMSG, errorMSG);
        } else if (input.matches(".*\\s+.*")) {//Check blank spacebar 
            System.out.println(errorMSG);
            input = inputString(inputMSG, errorMSG);
        }
        return input;
    }

    public int[] inputDate() {
        int day = inputInt("Enter day ", "Error - Invalid input.");
        int month = inputInt("Enter month", "Error - invalid input");
        int year = inputInt("Enter year", "Error - invalid input");

        while (year <= 1800) {
            System.out.println("Error - Year Incorrect.");
            year = inputInt("Enter year", "Error - invalid input");
        }

        while (month < 1 || month > 12) {
            System.out.println("Error - Month Incorrect.");
            month = inputInt("Enter month", "Error - invalid input");
        }

        while ((day < 1) || (day > Checker.endDayofMonth(month, year))) {
            System.out.println("Error : Day Incorrect.");
            day = inputInt("Enter day ", "Error - Invalid input.");
        }
        return new int[]{day, month, year};
    }

    public String inputID(String inputMSG, String errorMSG) {
        String input = inputString(inputMSG, errorMSG);
        if (Checker.checkNumber(input) == false) {
            System.out.println(errorMSG);
            input = inputID(inputMSG, errorMSG);
        }
        if (input.length() != 13) {
            System.out.println(errorMSG);
            input = inputID(inputMSG, errorMSG);
        }
        String firstDigit = input.substring(0, 1);
        if (firstDigit.equalsIgnoreCase("0")) {
            System.out.println(errorMSG);
            input = inputID(inputMSG, errorMSG);
        }
        return input;
    }

    public String inputTel(String inputMSG, String errorMSG) {
        String input = inputString(inputMSG, errorMSG);
        if (Checker.checkNumber(input) == false) {
            System.out.println(errorMSG);
            input = inputTel(inputMSG, errorMSG);
        }
        String firstNumber = input.substring(0, 1);
        if (firstNumber.equalsIgnoreCase("0")) {
            if (input.length() == 10) {
            } else {
                System.out.println(errorMSG);
                input = inputTel(inputMSG, errorMSG);
            }
        } else {
            System.out.println(errorMSG);
            input = inputTel(inputMSG, errorMSG);
        }
        return input;
    }

    public void PressEnterKey() {
        System.out.print("Press enter to continue...");
        String enter = scan.nextLine();
    }

    public void deleteToken() {
        scan.nextLine();
    }
}
