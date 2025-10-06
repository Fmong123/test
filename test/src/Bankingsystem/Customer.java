package Bankingsystem;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    private List<Account> accountList;
    private String fullName;
    private long idNumber;

    public Customer() {
        this.accountList = new ArrayList<>();
        this.fullName = "";
        this.idNumber = 0;
    }

    public Customer(long idNumber, String fullName) {
        this.fullName = fullName;
        this.idNumber = idNumber;
    }

    public String getCustomerInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Số CMND: %d. Họ tên: %s.", idNumber, fullName));
        return sb.toString();
    }

    public void addAccount (Account account) {
        if (account != null) {
            this.accountList.add(account);
        }
    }

    public void removeAccount (Account account) {
        if (account != null) {
            this.accountList.remove(account);
        }
    }

    public List<Account> getAccountList() {
        return accountList;
    }

    public String getFullName() {
        return fullName;
    }

    public long getIdNumber() {
        return idNumber;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setIdNumber(long idNumber) {
        this.idNumber = idNumber;
    }
}
