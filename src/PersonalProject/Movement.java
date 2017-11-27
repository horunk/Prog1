package PersonalProject;

import java.time.LocalDate;

public class Movement {
    private LocalDate date = LocalDate.parse("2017-01-01");
    private double amount = 0.0;
    private String account = "Not set";

    public Movement(LocalDate date, double amount, String account) {
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
