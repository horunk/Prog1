package PersonalProject;

import Practice2.TextIO;
import com.sun.org.apache.bcel.internal.generic.MONITORENTER;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

public class FundFlow {

    public static void main(String[] args) {
        //DONE TODO: create dummy data file for developement
        //DONE TODO: create module to read data from file to arraylist(?)
        //DONE TODO: create a out module to output the funds ordered by date
        //DONE TODO: add from and to date filters to out module
        //DONE:TODO: add a key-value pair class to store account names and initial balance
        //TODO: create more accounts and add method to choose account to output
        //TODO: create console interface


        double balance = 0.0;
        LocalDate fromDate;
        LocalDate toDate;

        // loo uus arraylist
        ArrayList<Movement> fundData2 = Initialize();


        // loo uus arraylist
        //  ArrayList<Movement> fundData = new ArrayList<>();

        // loe failist ridu,
        // String file = "C:\\Users\\horunk\\OneDrive - TTU\\Semester1\\Programmeerimise alused (ICS0004)\\dummydata.txt";
        // ReadFromFileToArrayList(fundData, file);


        fromDate = getFromDate();
        toDate = getToDate();


        //TODO: refactor

        for (Movement kirje : fundData2
                ) {
            //balance = balance + kirje.getAmount();

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

    private static LocalDate getToDate() {
        LocalDate toDate;
        while (true) {
            try {
                System.out.println("Insert TO date (YYYY-MM-DD) or empty line for today's date + 6 months: ");
                String toDateInput = TextIO.getlnString();
                if (toDateInput.equals("") || toDateInput.isEmpty()) {
                    toDate = LocalDate.now().plusMonths(3);
                    break;
                } else {
                    toDate = LocalDate.parse(toDateInput);
                    break;
                }
            } catch (DateTimeParseException e) {
                // Throw invalid date message
                System.out.println("Invalid date format, use YYYY-MM-DD");
            }
        }
        return toDate;
    }

    private static LocalDate getFromDate() {
        LocalDate fromDate;
        while (true) {

            try {
                System.out.println("Insert FROM date (YYYY-MM-DD) or empty line for today's date: ");
                String fromDateInput = TextIO.getlnString();
                if (fromDateInput.equals("") || fromDateInput.isEmpty()) {
                    fromDate = LocalDate.now();
                    break;
                } else {
                    fromDate = LocalDate.parse(fromDateInput);
                    break;
                }
            } catch (DateTimeParseException e) {
                // Throw invalid date message
                System.out.println("Invalid date format, use YYYY-MM-DD");
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
                String account = splitData[3].replaceAll("\\s","");

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
            if (Balances.containsKey(transaction.getAccount())){
                double curBalance = Balances.get(transaction.getAccount());
                Balances.replace(transaction.getAccount(),curBalance += transaction.getAmount());
            }else{
                Balances.put(transaction.getAccount(),transaction.getAmount());
            }

            FundDataWBalance.add(new Movement(transaction.getDate(),transaction.getAmount(),transaction.getAccount(), Balances.get(transaction.getAccount())));
        }


        return FundDataWBalance;

    }

}
