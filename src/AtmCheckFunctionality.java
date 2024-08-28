package ATMCheck;

import java.util.Scanner;

public class AtmCheckFunctionality extends BaseFile {

    /*
     * 
     * 
     * ATM Check Functionality
     * Used to calculate:-
     * 1. Current Balance
     * 2. Deposit amount
     * 3. Withdrawl amount
     * 4. Pin Change
     * 
     * ## Code is build dynamically considering the negative scenarios
     * 
     * 
     * 
     */

    public static void main(String[] args) {

        // Creating the object for scanner class
        Scanner sc = new Scanner(System.in);

        /*
         * 
         * Pin Entered should be:-
         * 1. Number only
         * 2. Consists of 4 digits
         * 
         */

        // Taking the input from user regarding his/her basic details
        System.out.println("Please fill the below details:-");
        System.out.print("Name: ");
        String name = sc.nextLine();

        // Using try-catch block to perform the actions
        try {

            String regex = "\\d+";
            System.out.println("Please enter your 4 digit pin");
            int numberOfAttempts = 0;
            String currentPinCode = "";

            while (numberOfAttempts < 3) {

                currentPinCode = sc.nextLine();
                if (currentPinCode.length() == 4 && currentPinCode.matches(regex)) {
                    break;
                } else {
                    System.out.println();
                    if (numberOfAttempts <= 1) {
                        System.out.println("Please re-enter your valid 4 digit pin");
                    }

                }

                numberOfAttempts++;

            }

            if (numberOfAttempts == 3 && !(currentPinCode.length() == 4 && currentPinCode.matches(regex))) {
                throw new Exception("");
            }

            /*
             * 
             * Once valid pin is entered from the user then the ATM menu will be opened and
             * further operations can be performed
             * 
             */

            // Assuming user has 0$ as current/initial balance
            double currentBalance = 0;

            // Creating a loop to perform ATM operations
            while (true) {

                System.out.println();
                System.out.println("Please check from the below operations:-");
                System.out.println("1 - Balance Check");
                System.out.println("2 - Amount Deposit");
                System.out.println("3 - Amount Withdrawl");
                System.out.println("4 - Pin Change");
                System.out.println("5 - Exit");

                int atmOption = sc.nextInt();

                if (atmOption == 1) {

                    balanceCheck(currentBalance);

                } else if (atmOption == 2) {

                    currentBalance = depositAmount(currentBalance, name, sc);

                } else if (atmOption == 3) {

                    currentBalance = withdrawlAmount(currentBalance, name, sc);

                } else if (atmOption == 4) {

                    currentPinCode = pinChange(currentPinCode, sc, name);

                } else if (atmOption == 5) {

                    exitApplication(name);
                    break;

                } else {

                    System.out.println("Please try again later and select the valid operation.");
                    System.out.println("Thank you for banking with us " + name);
                    System.out.println("Hope you have a great day!!");
                    break;

                }
            }

        } catch (Exception e) {

            System.out.println();
            System.out.println("Please enter valid pin and try again later");
            System.out.println("Thank you for banking with us " + name);
            System.out.println("Hope you have a great day!!");

        } finally {

            // Closing the scanner class
            sc.close();
        }

    }

}
