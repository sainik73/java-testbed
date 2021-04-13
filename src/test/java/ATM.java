import java.util.*;

import static java.lang.System.*;

/**
 * Purpose of this class is to implement ATM behavior for withdrawal and deposit of currency notes.
 * It allows customers to deposit and withdraw in the denominations: 20, 10, 5, and 1 dollar bills.
 * The program is extensible to accept $50 or $100 bills with minimal changes in configuration
 * and no code changes to deposit/withdrawal logic
 *
 * @author Kiran Saini
 */
public class ATM {

    //flag to set debug mode on/off
    private static boolean debugMode = false;

    private static final int BILL_DENOMINATIONS_COUNT = 4; // Current program handles $20, 10, 5 and 1 bills
    private static final int[] BILL_IDENTIFIER = new int[]{20,10,5,1}; // denominations to hold are 20, 10, 5 and 1
    private static final String MODE_DEPOSIT = "D"; // constant for Deposit
    private static final String MODE_WITHDRAW = "W"; // Constant for Withdrawal
    private static final String MODE_EXIT = "X";


    /**
     * Main method to test ATM operations
     * @param args  Input string arguments
     */
    public static void main(String[] args) {

        /* mode - withdraw or deposit. Set it to default mode of Deposit */
        String mode = "D";
        /* variable for amount to withdraw or deposit. Initialize it to zero */
        int amount;
        int[] billDenominations = new int[BILL_DENOMINATIONS_COUNT]; // Array to hold the count of bills
        String prefixMsg = null;
        /* Create the customer account object */
        CustomerAccount ca = new CustomerAccount();

        promptUserInputs();
        // Initialize the scanner with standard input
        Scanner scanner = new Scanner(in);

        /* process the scanner input */
        while(scanner.hasNextLine()){
            mode = scanner.next();
            // set the message according to the mode - deposit or withdraw
            if(MODE_DEPOSIT.equalsIgnoreCase(mode)) {
                prefixMsg = "Enter amount to deposit: ";
            } else if (MODE_WITHDRAW.equalsIgnoreCase(mode)) prefixMsg = "Enter amount to withdraw: ";
            Optional<String> optionalPrefixMsg = Optional.ofNullable(prefixMsg);
            int iCounter = 0;
            /* reset the amount */
            amount = 0;

            /* logic for Deposit mode */
            if(MODE_DEPOSIT.equalsIgnoreCase(mode)) {
                out.println("Enter $" + BILL_IDENTIFIER[iCounter] + " bills to deposit: ");
                while (iCounter != BILL_DENOMINATIONS_COUNT && scanner.hasNextInt()) {
                    int inputBillCount = scanner.nextInt();

                    if (inputBillCount >= 0) {
                        billDenominations[iCounter] = inputBillCount;// hold the count of bills
                        if(debugMode) out.println("Counter is : " + iCounter + " , $" + BILL_IDENTIFIER[iCounter] +" Bills Count: "+ billDenominations[iCounter]);
                        amount += BILL_IDENTIFIER[iCounter]*inputBillCount; //accumulate the amount to be deposited
                        iCounter++;//increase counter only if the inputBillCount is valid

                    } else out.println("Incorrect deposit amount.");

                    /* Get the next bill denomination to deposit */
                    if(iCounter != BILL_DENOMINATIONS_COUNT) {
                        out.println("Enter $" + BILL_IDENTIFIER[iCounter] + " bills to deposit: ");
                    }
                }// end of while

                // if validation is successful, deposit the money
                if (validateAmount(mode, amount, amount)) {
                    deposit(ca,mode, amount, billDenominations);
                }

            } /* logic for withdrawal operation */
            else if (MODE_WITHDRAW.equalsIgnoreCase(mode)){
                out.println(optionalPrefixMsg.orElse("Enter amount: "));
                if (scanner.hasNextInt()) {
                    amount = scanner.nextInt();
                }
                // if validation is successful, withdraw the money from account
                if (validateAmount(mode, amount, ca.getBalance())) {
                    withdraw(ca,mode, amount);
                }
            } else if (MODE_EXIT.equalsIgnoreCase(mode)){
               break;
            } else {
                out.println("Please enter valid input. or enter X to exit");
            }
            // prompt the user to choose ATM mode again
            promptUserInputs();
        }//end of while

        //close scanner
        scanner.close();
        if (debugMode)
            out.println("******** Closing the Scanner *************");

        out.println("********  Thank you for using the ATM  **********");
    }//end of Main method

    /**
     * Purpose of the method is to validate the amount entered by user.
     * // Ref: D.1) If any input values are negative, print "Incorrect deposit amount".
     * // D.2) If all the input values are zero, print "Deposit amount cannot be zero".
     * // W.1) If the input amount is zero, negative, or over the current balance,
     *         print "Incorrect or insufficient funds".
     *
     * @param mode              valid values are W and D
     * @param amountToValidate  amount to deposit or withdraw from account
     * @param balanceInAccount  total current balance in account
     * @return validationStatus boolean object stating of the validation operation is success or failure
     */
    private static boolean validateAmount(String mode, int amountToValidate, int balanceInAccount) {
        if (debugMode)
            out.println("********** Inside validate amount ******");
        //flag to hold the validation status. Initially it will be set to false
        boolean validationStatus = false;
        String prefix = null;
        if(mode.equalsIgnoreCase("D")) prefix = "Invalid Input: Deposit ";
        else if (mode.equalsIgnoreCase("W")) prefix = "Incorrect or insufficient funds.";
        Optional<String> optionalS = Optional.ofNullable(prefix);

        if (mode.equalsIgnoreCase("W") && ( amountToValidate > balanceInAccount) && amountToValidate >=0){
            out.println(optionalS.orElse("Invalid withdraw amount"));
            validationStatus = false;
        }else {
            if (amountToValidate == 0) {
                out.println(optionalS.orElse("") + "amount can't be zero");
            } else if (amountToValidate < 0) {
                out.println(optionalS.orElse("") + "amount is incorrect");
            } else validationStatus = true;
        }
        if (debugMode)
            out.println("********** Inside validate amount: Validation Status: "+ validationStatus);

        return validationStatus;
    }

    /**
     * Method to deposit money
     * It will update account balance, set the correct bill denominations
     * and print the account status
     */
    private static void deposit(CustomerAccount ca, String mode, int amount, int[] billDenomination) {
        if(debugMode) out.println("****** inside deposit()");
        ca.addBalance(amount);
        ca.setBillDenominations(mode,billDenomination);
        ca.printAccountDetails();
    }

    /**
     * Method to withdraw money
     * It will set the balance, try to dispense highest denomination bills first before going to next denomination.
     * Also it will print the Account status.
     * In case there is residue amount left to dispense (after going through all bill denominations, it will fail the
     * withdraw operation with a error message to indicate the failure.
     * All the recursion logic to dispense bills is present in calculateBillDenominationsToWithdraw method.
     */
    private static void withdraw(CustomerAccount ca,String mode, int amount) {
        if(debugMode) out.println("****** inside withdraw()");

        Map<Integer,Integer> billsMap = ca.getBillDenominations();
        int[] billDenominations = new int[BILL_DENOMINATIONS_COUNT]; // Array to hold the count of bills

        int withdrawResult = calculateBillDenominationsToWithdraw(amount,0, billDenominations, billsMap);

        if(withdrawResult == 0) {
            ca.setBillDenominations(mode, billDenominations);
            ca.withdrawBalance(amount);
        }else {
            out.println("Not sufficient bill denominations available in account for withdraw");
        }
        // print current denominations available with balance
        ca.printAccountDetails();
    }

    /**
     * Method to calculate bill denominations needed for withdrawal.
     * It will run recursively until amountToWithdraw ==0 and BILL_DENOMINATIONS_COUNT is exhausted
     * @param amountToWithdraw  amount to withdraw
     * @param counter           counter to keep track of iterations
     * @param billDenominations array to hold all possible bill denominations allowed in the operations
     * @param billsMap          map of bill denominations currently available in customer account
     * @return residueAmount    amount left out for withdrawal and no equivalent bill denomination is
     *                          available in the account
     */
    private static int calculateBillDenominationsToWithdraw(int amountToWithdraw, int counter,
                                                                int[] billDenominations, Map<Integer,Integer> billsMap){
        int remainingAmount; // amount left after each iteration to continue the bill dispense logic
        // This variable will hold the residue amount left after dispensing all the bills needed for withdrawal
        int residueAmount;
        if(counter != BILL_DENOMINATIONS_COUNT && (amountToWithdraw > 0)) {
            int billsNeededToWithdraw = amountToWithdraw / BILL_IDENTIFIER[counter];
            int currentBillsInAccount = (int) billsMap.get(BILL_IDENTIFIER[counter]);
            /*
             * if account has sufficient number of bills to withdraw, then proceed with withdrawal
             */
            if (currentBillsInAccount >= billsNeededToWithdraw) {
                remainingAmount = amountToWithdraw - (billsNeededToWithdraw * BILL_IDENTIFIER[counter]);
                billDenominations[counter] = billsNeededToWithdraw;

            } else {
                remainingAmount = amountToWithdraw - (currentBillsInAccount * BILL_IDENTIFIER[counter]);
                //use all bills of this denomination currently in the account for withdrawal
                billDenominations[counter] = currentBillsInAccount;
            }
            if (debugMode)
                out.println(" Counter: " + counter + ", $" +
                        BILL_IDENTIFIER[counter] + " = " + billDenominations[counter] +
                        ", Remaining amount: " + remainingAmount);

             residueAmount = calculateBillDenominationsToWithdraw(remainingAmount, ++counter, billDenominations, billsMap);
        }else{
            residueAmount = amountToWithdraw;
        }

        return residueAmount;
    }


    private static void promptUserInputs() {
        //Get user input from ATM keypad - "W" for Withdraw and "D" for Deposit
        String spacer = "************************************************";
        out.println();
        out.println(spacer);
        out.println("****         Welcome to ATM                 ****");
        out.println(spacer);
        out.println("You can enter X to exit anytime during the program.");
        out.println("Please enter 'W' to Withdraw or 'D' to Deposit: ");
    }

    /**
     * Customer account class holding the balance and bill denominations
     */
    static class CustomerAccount{
        private int iCounter = 0;
        private int balance = 0;
        /* this map variable will hold all the bill denominations in account */
        //private Map<String, Integer> billDenominations = new TreeMap<>();
        private final Map<Integer, Integer> billDenominations =
                        new TreeMap<>(Comparator.comparingInt(Integer::intValue));

        /**
         * Default constructor
         */
        CustomerAccount(){
            // initialize the treemap with zero bills
            for (int i: BILL_IDENTIFIER) {
                billDenominations.put(i, 0);
            }
        }

        public int getBalance() {
            return balance;
        }

        public void addBalance(int balance) {
            this.balance += balance;
        }

        public void withdrawBalance(int balance) {
            this.balance -= balance;
        }

        public Map<Integer, Integer> getBillDenominations() {

            return Collections.unmodifiableMap(billDenominations);
        }

        /**
         * This method is to update bill denominations based on
         * the input mode - deposit or withdrawal
         * @param mode  String object - deposit or withdrawal
         * @param bills object of int array holding the bill counts for each bill denominations
         */
        public void setBillDenominations(String mode, int[] bills) {
            Mode depositMode = Integer::sum;
            Mode withdrawMode = (x,y) -> (x-y);

            for (int i: bills) {
                int temp = this.billDenominations.get(BILL_IDENTIFIER[iCounter]);
                if("D".equalsIgnoreCase(mode)) {
                    this.billDenominations.put(BILL_IDENTIFIER[iCounter], depositMode.operation(temp,i));
                } else if ("W".equalsIgnoreCase(mode)){
                    this.billDenominations.put(BILL_IDENTIFIER[iCounter], withdrawMode.operation(temp,i));
                }
                iCounter++;
            }
            iCounter = 0; //reset the counter
        }

        /**
         * Method to print account details with each bill denominations and account balance
         */
        public void printAccountDetails(){
            out.print("Account[ ");
            billDenominations.forEach((k, v) -> out.print( "$"+ k + "= " + v + ", "));
            out.println("Account Balance: "+ balance +"]");
        }
    }// end of customer class

    /**
     * operation is implemented using lambda expression
     * It is used for define logic for deposit or withdraw
     * while setting the bill denominations in customer account object.
     */
    @FunctionalInterface
    interface Mode {
        int operation (int x1, int x2);
    }
}// end of ATM class
