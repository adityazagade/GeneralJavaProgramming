package aop;

import com.sun.javaws.exceptions.InvalidArgumentException;

import java.util.ArrayList;

public class Bank {
    private String name;
    private ArrayList<Account> accounts;

    public Bank() {
    }

    public Bank(String name) {
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAccounts(ArrayList<Account> accounts) {
        this.accounts = accounts;
    }

    private Account getAccountByNumber(String accountNo) throws AccountNotFoundException {
        for (Account account : accounts) {
            if (account.getAccountNo().equals(accountNo)) {
                return account;
            }
        }
        throw new AccountNotFoundException("Account with account no " + accountNo + " not found");
    }

    public boolean deposit(String accountNo, int amount) {
        System.out.println("Running deposit");
        try {
            if (amount <= 0) {
                throw new InvalidArgumentException(new String[]{"Amount cannot be less than 0"});
            }
            Account ac = getAccountByNumber(accountNo);
            ac.deposit(amount);
            return true;
        } catch (AccountNotFoundException e) {
            // Do nothing here
        } catch (InvalidArgumentException iae) {
            // Do nothing here
        }
        return false;
    }

    public int getBalance(String accountNo) throws AccountNotFoundException {
        System.out.println("Running getBalance");
        return getAccountByNumber(accountNo).getBalance();
    }
}
