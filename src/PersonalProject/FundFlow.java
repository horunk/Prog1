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

public class FundFlow {
    public static void main(String[] args) {
        //DONE TODO: create dummy data file for developement
        //DONE TODO: create module to read data from file to arraylist(?)
        //DONE TODO: create a out module to output the funds ordered by date
        //TODO: add from and to date filters to out module
        //TODO: add a key-value pair class to store account names and initial balance (read from conf file) ((read file name for fundData from conf too?))
        //TODO: add data add and data remove functionality
        //TODO: add recurring fund movements
        //TODO: create more accounts and add method to choose account to output
        //TODO: create console interface

        double balance = 0.0;
        LocalDate fromDate;
        LocalDate toDate = LocalDate.parse("2017-10-15"); //TODO: add get input

        // loo uus arraylist
        ArrayList<Movement> fundData = new ArrayList<>();

        // loe failist ridu,
        String file = "C:\\Users\\horunk\\OneDrive - TTU\\Semester1\\Programmeerimise alused (ICS0004)\\dummydata.txt";
        ReadFromFileToArrayList(fundData, file);

        // Comparator kuupäeva järgi sorteerimiseks  //TODO: tõsta sobivamasse kohta
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

        //Muuda all olevat väljastust ja lisa kuupäevafilter (seejärel refactori funktsiooniks)




        while(true) {


            try {
                System.out.println("Insert from date (YYYY-MM-DD) or empty line for today's date: ");
                String fromDateInput = TextIO.getlnString();
                if (fromDateInput == "" || fromDateInput.isEmpty()){
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



        for (Movement kirje : fundData
                ) {
            balance = balance + kirje.getAmount();

            if (kirje.getDate().isAfter(fromDate) && kirje.getDate().isBefore(toDate)) {
                // System.out.println(kirje.getDate() + " " + kirje.getAmount() + " " + kirje.getAccount());
                System.out.format("%-15s%15.2f%15s%15.2f",
                        kirje.getDate(), kirje.getAmount(), kirje.getAccount(), balance);
                System.out.println("");
            }else{
                continue;
            }
        }


        //testväljastus
/*
        double balance = 0.0;
        for (Movement kirje : fundData
                ) {
            // System.out.println(kirje.getDate() + " " + kirje.getAmount() + " " + kirje.getAccount());
            balance = balance + kirje.getAmount();
            System.out.format("%-15s%15.2f%15s%15.2f",
                    kirje.getDate(), kirje.getAmount(), kirje.getAccount(), balance);
            System.out.println("");
        }
*/


    }

    private static void ReadFromFileToArrayList(ArrayList<Movement> fundData, String file) {
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {

            String line;
            while ((line = br.readLine()) != null) {
                String[] splitData = line.split(",");

                int instance = Integer.parseInt(splitData[0]);
                String date = splitData[1];
                Double amount = Double.parseDouble(splitData[2]);
                String account = splitData[3];

                fundData.add(new Movement(date, amount, account));

            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
