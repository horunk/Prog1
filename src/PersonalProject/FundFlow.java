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

public class FundFlow {


    public static void main(String[] args) {
        //DONE TODO: create dummy data file for developement
        //DONE TODO: create module to read data from file to arraylist(?)
        //DONE TODO: create a out module to output the funds ordered by date
        //DONE TODO: add from and to date filters to out module
        //DONE:TODO: add a key-value pair class to store account names and initial balance
        //DONE TODO: create more accounts and add method to choose account to output
        //TODO: create console interface
        //TODO Hello info at startup


        LocalDate fromDate;
        LocalDate toDate;
        String accountName = new String();
        ArrayList<String> accountList = new ArrayList<>();

        // loo uus arraylist
        ArrayList<Movement> fundData = Initialize();

        printHelloText();

        generateMenu(fundData);
        do{
            clearConsole();
            generateMenu(fundData);
        } while (true);



    }

    private static void generateMenu(ArrayList<Movement> fundData) {
        clearConsole();
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
                System.out.println("Thank you for using Fundflow");
                System.exit(0);
                break;
            default:
                System.out.println("Selected option not available, please select again");
                break;
        }
    }

    private static void detailedOutput(ArrayList<Movement> fundData) {
        LocalDate fromDate;
        LocalDate toDate;
        String accountName;
        fromDate = getFromDate();
        toDate = getToDate();
        accountName = getAccount(fundData);

        generateDetailedOutput(fromDate, toDate, accountName, fundData);
    }

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

    private static void promptEnterKeyandCLR(){
        System.out.println("Press \"ENTER\" to continue...");
        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
        clearConsole();
    }

    private static void clearConsole(){
        for (int i = 0; i < 50; ++i) System.out.println();
    }

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

    private static ArrayList Initialize() {


        // loe failist read arraylisti
        //TODO: faili asukoht conf faili
        String file = "C:\\Users\\horunk\\OneDrive - TTU\\Semester1\\Programmeerimise alused (ICS0004)\\dummydata.txt";
        ArrayList<Movement> fundDataTemp = ReadFromFileToArrayList(file);


        return fundDataTemp;
    }

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
