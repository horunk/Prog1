# Documentation

## `public class FundFlow`

The FundFlow program is ment to help with giving insight into future balance and fund movements of several accounts.

 * **Author:** Holger R
 * **Version:** 0.1
 * **Since:** 2017-12-10

## `private static void generateMenu(ArrayList<Movement> fundData)`

This method generates options menu for the user. E.g. to invoke generate output method or to exit program.

 * **Parameters:** `fundData` — 

## `private static void detailedOutput(ArrayList<Movement> fundData)`

This method is used to get user input for generateDetailedOutput method. From and To dates and Account name are required from user. After getting input the {@link #generateDetailedOutput(LocalDate, LocalDate, String, ArrayList)} is called to generate output.

 * **Parameters:** `fundData` — 

## `private static void printHelloText()`

This method creates the first banner message shown on startup. Displaying program name, author and version.

## `private static void promptEnterKeyandCLR()`

This method is used to make the program pause until users presses "Enter" key.

## `private static void clearConsole()`

This method is used to "clear" console - currently by printing 50 new lines

## `private static void generateDetailedOutput(LocalDate fromDate, LocalDate toDate, String accountName, ArrayList<Movement> fundData)`

This method is used to generate table like formatted output for the detailed fund movement data. The method uses user input from method {@link #detailedOutput(ArrayList)}

 * **Parameters:**
   * `fromDate` — From date used for filtering movements
   * `toDate` — To date used for filtering movements
   * `accountName` — Account name used for filtering movements
   * `fundData` — The dataset being used

## `private static String getAccount(ArrayList<Movement> fundData)`

Method used to get user input for account name. Used in method {@link #detailedOutput(ArrayList)}

 * **Parameters:** `fundData` — 
 * **Returns:** returns value from user input

## `private static LocalDate getToDate()`

Method used to get user input for To date. Used in method {@link #detailedOutput(ArrayList)}

 * **Returns:** returns value from user input

## `private static LocalDate getFromDate()`

Method used to get user input for From date. Used in method {@link #detailedOutput(ArrayList)}

 * **Returns:** returns value from user input

## `private static ArrayList Initialize()`

Method used to load configuration from config file. Invoking method {@link #ReadFromFileToArrayList(String)} to read data from datafile and doing first processing.

 * **Returns:** returns temp dataset as ArrayList

## `private static ArrayList<Movement> ReadFromFileToArrayList(String file)`

Method invoked by {@link #Initialize()}. This method reads fund movement data from file and do first processing. Sorting data from input and calculating balances. The balance data is saved in the hashmap.

 * **Parameters:** `file` — The file path read from config file and used to load data for processing.
 * **Returns:** returns data as new ArrayList which also includes calculated balance values.
