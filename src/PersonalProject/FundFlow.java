package PersonalProject;

import Practice2.TextIO;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 *
 *<h1>FundFlow</h1>
 * The FundFlow program is ment to help with giving insight into future balance and fund movements of several accounts.
 *
 *
 * @author  Holger R
 * @version 0.1
 * @since   2017-12-10
 */

public class FundFlow {


    public static void main(String[] args) {
        // Declare basic variables
        LocalDate fromDate;
        LocalDate toDate;
        String accountName = new String();
        ArrayList<String> accountList = new ArrayList<>();

        // Call initialize to load configuration and data, do first processing
        ArrayList<Movement> fundData = Initialize();

        // Display welcome information
        printHelloText();

        // Show menu for options
        generateMenu(fundData);
        do{

            generateMenu(fundData);
        } while (true);
    }


    /**
     * This method generates options menu for the user. E.g. to invoke generate output method or to exit program.
     * @param fundData
     */
    private static void generateMenu(ArrayList<Movement> fundData) {
        System.out.println("Please insert number from list for action: ");
        System.out.println("1 - Generate detailed funds output");
        System.out.println("9 - Exit the program");

        int showMenuOptions = TextIO.getlnInt();
        switch (showMenuOptions) {
            case 1:
                clearConsole();
                detailedOutput(fundData);
                break;
            case 9:
                clearConsole();
                System.out.println("Thank you for using FundFlow");
                System.exit(0);
                break;
            default:
                System.out.println("\n\nSelected option not available, please make new selection:\n");
                break;
        }
    }


    /**
     * This method is used to get user input for generateDetailedOutput method. From and To dates and Account name are required from user.
     * After getting input the {@link #generateDetailedOutput(LocalDate, LocalDate, String, ArrayList)} is called to generate output.
     * @param fundData
     */
    private static void detailedOutput(ArrayList<Movement> fundData) {
        LocalDate fromDate;
        LocalDate toDate;
        String accountName;
        fromDate = getFromDate();
        toDate = getToDate();
        accountName = getAccount(fundData);

        generateDetailedOutput(fromDate, toDate, accountName, fundData);
    }


    /**
     * This method creates the first banner message shown on startup.
     * Displaying program name, author and version.
     */
    private static void printHelloText() {
        ArrayList<String> helloPage = new ArrayList<>();
        helloPage.add("");
        helloPage.add("Welcome to FundFlow program");
        helloPage.add("");
        helloPage.add("This program is made to allow you to get an ");
        helloPage.add("insight into your future funds by accounts.");
        helloPage.add("");
        helloPage.add("Version 0.1");
        helloPage.add("by: Holger R / horunk@github.com");
        helloPage.add("");

        int longestRow = 0;
        int countOfRows = 0;
        for (String row : helloPage
             ) {
            if (row.length() > longestRow){
                longestRow = row.length();
            }
            countOfRows = countOfRows +1;
        }

        for (int i = 0; i < longestRow + 10; i++) {
        System.out.print("#");
           }
        ;
        System.out.println("");

        for (String row : helloPage
             ) {
        System.out.print("#");
        for (int i = 0; i < ((longestRow-row.length())/2+4); i++) {
            System.out.print(" ");
        }
        System.out.print(row);
        for (int i = 0; i < (((longestRow-row.length())/2+4)+row.length()%2); i++) {
            System.out.print(" ");
        }
        System.out.print("#\n");
           }

        for (int i = 0; i < longestRow + 10; i++) {
        System.out.print("#");
           }
        ;
        System.out.println("\n\n");
        promptEnterKeyandCLR();
    }

    /**
     * This method is used to make the program pause until users presses "Enter" key.
     */
    private static void promptEnterKeyandCLR(){
        System.out.println("Press \"ENTER\" to continue...");
        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
        clearConsole();
    }

    /**
     * This method is used to "clear" console - currently by printing 50 new lines
     */
    private static void clearConsole(){
        for (int i = 0; i < 50; ++i) System.out.println();
    }

    /**
     * This method is used to generate table like formatted output for the detailed fund movement data.
     * The method uses user input from method {@link #detailedOutput(ArrayList)}
     * @param fromDate From date used for filtering movements
     * @param toDate To date used for filtering movements
     * @param accountName Account name used for filtering movements
     * @param fundData The dataset being used
     */
    private static void generateDetailedOutput(LocalDate fromDate, LocalDate toDate, String accountName, ArrayList<Movement> fundData) {
        System.out.println("");
        System.out.format("%-15s%15s%15s%15s\n",
                "Date", "Amount", "Account", "Balance");
        System.out.println("------------------------------------------------------------");

        for (Movement kirje : fundData
                ) {

            if (accountName.equalsIgnoreCase(kirje.getAccount())) {
                if (kirje.getDate().isAfter(fromDate) && kirje.getDate().isBefore(toDate)) {
                    // System.out.println(kirje.getDate() + " " + kirje.getAmount() + " " + kirje.getAccount());
                    System.out.format("%-15s%15.2f%15s%15.2f",
                            kirje.getDate(), kirje.getAmount(), kirje.getAccount(), kirje.getBalance());
                    System.out.println("");
                } else {
                    continue;
                }
            }
        }
        System.out.println("\n");
        promptEnterKeyandCLR();
    }


    /**
     * Method used to get user input for account name. Used in method {@link #detailedOutput(ArrayList)}
     * @param fundData
     * @return returns value from user input
     */
    private static String getAccount(ArrayList<Movement> fundData) {
        String getAccount = "";


        Set<String> uniqueAccounts = new HashSet<>();
        for (Movement kirje : fundData
                ) {
            if(uniqueAccounts.contains(kirje.getAccount())){
                continue;
            }else{
                uniqueAccounts.add(kirje.getAccount());
            }
        }

        while (true) {

            System.out.print("\nFollowing accounts were found in data file: ");

            for (String kirje : uniqueAccounts
                 ) {
                System.out.print(kirje + ", ");
            }
            System.out.println("");
            System.out.println("Insert the account name for fund flow output:");

            String getAccountInput = TextIO.getlnString();

            if(uniqueAccounts.contains(getAccountInput)){
                getAccount = getAccountInput;
                break;
            }else {
                System.out.println("Inserted account was not found.\n");
                continue;
            }


        }
        return getAccount;
    }


    /**
     * Method used to get user input for To date. Used in method {@link #detailedOutput(ArrayList)}
     * @return returns value from user input
     */
    private static LocalDate getToDate() {
        LocalDate toDate;
        while (true) {
            try {
                System.out.println("\nInsert TO date (YYYY-MM-DD) or empty line for today's date + 6 months: ");
                String toDateInput = TextIO.getlnString();
                if (toDateInput.equals("") || toDateInput.isEmpty()) {
                    toDate = LocalDate.now().plusMonths(3);
                    System.out.println("Using date: " + toDate + "\n");
                    break;
                } else {
                    toDate = LocalDate.parse(toDateInput);
                    break;
                }
            } catch (DateTimeParseException e) {
                // Throw invalid date message
                System.out.println("\nInvalid date format, use YYYY-MM-DD");
            }
        }
        return toDate;
    }


    /**
     * Method used to get user input for From date. Used in method {@link #detailedOutput(ArrayList)}
     * @return returns value from user input
     */
    private static LocalDate getFromDate() {
        LocalDate fromDate;
        while (true) {

            try {
                System.out.println("\nInsert FROM date (YYYY-MM-DD) or empty line for today's date: ");
                String fromDateInput = TextIO.getlnString();
                if (fromDateInput.equals("") || fromDateInput.isEmpty()) {
                    fromDate = LocalDate.now();
                    System.out.println("Using date: " + fromDate + "\n");
                    break;
                } else {
                    fromDate = LocalDate.parse(fromDateInput);
                    break;
                }
            } catch (DateTimeParseException e) {
                // Throw invalid date message
                System.out.println("\nInvalid date format, use YYYY-MM-DD");
            }
        }
        return fromDate;
    }

    /**
     * Method used to load configuration from config file.
     * Invoking method {@link #ReadFromFileToArrayList(String)} to read data from datafile and doing first processing.
     * @return returns temp dataset as ArrayList
     */
    private static ArrayList Initialize() {

        String file = "";
        //String config = "C:\\Users\\horunk\\OneDrive - TTU\\Semester1\\Programmeerimise alused (ICS0004)\\Prog1\\src\\PersonalProject\\conf.txt";
        String config = ".\\src\\PersonalProject\\conf.txt";

        try (BufferedReader br = new BufferedReader(new FileReader(config))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.startsWith("#")){
                }else{
                    String[] splitData = line.split("=");

                    String key = splitData[0];
                    String value = splitData[1];
                    if (key.equalsIgnoreCase("datapath")){
                        file = value;
                    }
                }
            }
            br.close();

        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Configuration file not found. Check if you have config file (conf.txt) at: ");
            System.out.println(config);
            System.exit(1);
        }

        ArrayList<Movement> fundDataTemp = ReadFromFileToArrayList(file);

        return fundDataTemp;
    }

    /**
     * Method invoked by {@link #Initialize()}. This method reads fund movement data from file and do first processing.
     * Sorting data from input and calculating balances. The balance data is saved in the hashmap.
     *
     * @param file The file path read from config file and used to load data for processing.
     * @return returns data as new ArrayList which also includes calculated balance values.
     */
    private static ArrayList<Movement> ReadFromFileToArrayList(String file) {

        ArrayList<Movement> fundData = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {

            String line;
            while ((line = br.readLine()) != null) {
                String[] splitData = line.split(",");

                int instance = Integer.parseInt(splitData[0]);
                String date = splitData[1];
                Double amount = Double.parseDouble(splitData[2]);
                String account = splitData[3].replaceAll("\\s", "");

                fundData.add(new Movement(date, amount, account));

            }
            br.close();

        } catch (IOException e) {
            System.out.println("Input file not found.");
            System.out.println("Check data file location configuration from config file (conf.txt)");
            System.exit(1);
        }


        // Comparator kuupäeva järgi sorteerimiseks
        Comparator<Movement> byDate = new Comparator<Movement>() {
            public int compare(Movement left, Movement right) {
                if (left.getDate().isBefore(right.getDate())) {
                    return -1;
                } else {
                    return 1;
                }
            }
        };

        //sorteeri fundData arraylisti objektid kuupäeva järgi
        Collections.sort(fundData, byDate);

        ArrayList<Movement> FundDataWBalance = new ArrayList<>();

        HashMap<String, Double> Balances = new HashMap<String, Double>();

        for (Movement transaction : fundData
                ) {
            if (Balances.containsKey(transaction.getAccount())) {
                double curBalance = Balances.get(transaction.getAccount());
                Balances.replace(transaction.getAccount(), curBalance += transaction.getAmount());
            } else {
                Balances.put(transaction.getAccount(), transaction.getAmount());
            }

            FundDataWBalance.add(new Movement(transaction.getDate(), transaction.getAmount(), transaction.getAccount(), Balances.get(transaction.getAccount())));
        }


        return FundDataWBalance;

    }

}
