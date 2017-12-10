package PersonalProject;

import java.time.LocalDate;

/**
 * Class used for ArrayLists to store initial and processed data.
 * Initial data is stored with the constructor with 3 variables.
 * Processed data is used with constructor where balance is added.
 */
public class Movement {
    private LocalDate date = LocalDate.parse("2017-01-01");
    private double amount = 0.0;
    private String account = "Not set";


    private double balance;

    public Movement(String date, double amount, String account) {
        this.date = LocalDate.parse(date);
        this.amount = amount;
        this.account = account;
    }

    public Movement(LocalDate date, double amount, String account, double balance) {
        this.balance = balance;
        this.date = date;
        this.amount = amount;
        this.account = account;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void setBalance(double balance) { this.balance = balance; }

    public double getBalance() { return balance; }

    public double getAmount() {
        return amount;
    }

    public LocalDate getDate() {
        return date;
    }

    public String getAccount() {
        return account;
    }
}
