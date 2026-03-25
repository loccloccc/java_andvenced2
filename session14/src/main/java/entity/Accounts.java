package entity;

public class Accounts {
    private String Accountid;
    private String Fullname;
    private Double Balance;

    public Accounts() {}

    public Accounts(String accounts, String fullname, Double balance) {
        Accountid = accounts;
        Fullname = fullname;
        Balance = balance;
    }

    public String getAccounts() {
        return Accountid;
    }

    public void setAccounts(String accounts) {
        Accountid = accounts;
    }

    public String getFullname() {
        return Fullname;
    }

    public void setFullname(String fullname) {
        Fullname = fullname;
    }

    public Double getBalance() {
        return Balance;
    }

    public void setBalance(Double balance) {
        Balance = balance;
    }

    @Override
    public String toString() {
        return "Accounts{" +
                "Accounts='" + Accountid + '\'' +
                ", Fullname='" + Fullname + '\'' +
                ", Balance=" + Balance +
                '}';
    }
}