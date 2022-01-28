package aop;

public class Account {
    private String accountNo;
    private int balance;

    public Account(String accountNo) {
        this.accountNo = accountNo;
    }

    public Account() {
    }

    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public boolean deposit(int amount) {
        balance += amount;
        return true;
    }
}
