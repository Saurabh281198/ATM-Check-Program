package ATMCheck;

import java.util.Scanner;

public class BaseFile {

    /*
     * 
     * Base File which contains all the methods like
     * 1. Checking balance
     * 2. Depositing amount
     * 3. Withdrawing amount
     * 4. Changing pin
     * 5. Exit the application
     * 
     * 
     */

    // Method for checking the balances
    public static void balanceCheck(double currentBalance) {

        System.out.println();
        System.out.println("The current balance is " + currentBalance + "$");

    }

    // Method for deposting the amount
    public static double depositAmount(double currentBalance, String name, Scanner sc) {

        System.out.println();
        System.out.print("Please enter the amount which needs to be deposited!!");
        double depositAmount = sc.nextDouble();
        currentBalance = currentBalance + depositAmount;
        System.out.println(
                "Thanks for depositing the amount " + name + " and your current balance is " + currentBalance
                        + "$");

        return currentBalance;
    }

    // Method for withdrawing the amount
    public static double withdrawlAmount(double currentBalance, String name, Scanner sc) {

        System.out.println();
        System.out.print("Please enter the amount which needs to be withdrawl!!");
        double withdrawlAmount = sc.nextDouble();

        if (currentBalance >= withdrawlAmount) {

            currentBalance = currentBalance - withdrawlAmount;
            System.out.println(
                    "Thanks for withdrawing the amount " + name + " and your current balance is "
                            + currentBalance + "$");
            return currentBalance;

        } else {

            System.out.println("Insufficent funds ! Please enter the correct amount to be withdrawl");
            System.out.println("The current balance is " + currentBalance + "$");
            return currentBalance;

        }

    }

    // Method for changing the pin
    public static String pinChange(String currentPinCode, Scanner sc, String name) {

        String regex = "\\d+";
        System.out.println();

        System.out.println("Please enter the new pin and it should be of 4 digits");
        sc.nextLine();

        int i = 0;

        while (i < 1) {

            String updatedPinCodeFirstTime = sc.nextLine();

            if (updatedPinCodeFirstTime.equals(currentPinCode)) {
                System.out
                        .println("Please enter new pin as currently entered pin is same as older one and retry later");
                System.out.println("Thank you for banking with us " + name);
                System.out.println("Hope you have a great day!!");
                break;
            }

            if (!(updatedPinCodeFirstTime.length() == 4 && updatedPinCodeFirstTime.matches(regex))) {
                System.out.println("Please try again later and enter valid 4 digit Pin");
                break;
            }

            System.out.println();
            System.out.println("Please re-enter the new pin");
            String updatedPinCodeSecondTime = sc.nextLine();

            if (!(updatedPinCodeSecondTime.length() == 4 && updatedPinCodeSecondTime.matches(regex))) {
                System.out.println("Please try again later and enter valid 4 digit Pin");
                break;
            }

            if (updatedPinCodeFirstTime.equals(updatedPinCodeSecondTime)) {

                System.out.println("Pin have been changed successfully");
                currentPinCode = updatedPinCodeFirstTime;

            } else {

                System.out.println("Please try again later and enter the same pin both times");
                System.out.println("Thank you for banking with us " + name);
                System.out.println("Hope you have a great day!!");

            }

            i++;
        }

        return currentPinCode;

    }

    // Method for exit from the application
    public static void exitApplication(String name) {

        System.out.println();
        System.out.println("Thank you for banking with us " + name);
        System.out.println("Hope you have a great day!!");

    }

}
