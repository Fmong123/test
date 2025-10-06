import java.util.ArrayList;

public class Account {
    private double balance;
    private ArrayList<Transaction> transitionList;

    public Account() {
        this.balance = 0.0;
        this.transitionList = new ArrayList<>();
    }

    private void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            transitionList.add(new Transaction(Transaction.DEPOSIT, amount, balance));
        } else {
            System.out.println("So tien ban nap vao khong hop le!");
        }
    }

    private void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            transitionList.add(new Transaction(Transaction.WITHDRAW, amount, balance));
        } else if (amount <= 0) {
            System.out.println("So tien ban rut ra khong hop le!");
        } else {
            System.out.println("So tien ban rut vuot qua so du!");
        }
    }

    /**
     * cmt.
     */
    public void addTransaction(double amount, String operation) {
        if (Transaction.DEPOSIT.equalsIgnoreCase(operation)) {
            deposit(amount);
        } else if (Transaction.WITHDRAW.equalsIgnoreCase(operation)) {
            withdraw(amount);
        } else {
            System.out.println("Yeu cau khong hop le!");
        }
    }

    /**
     * cmt.
     */
    public void printTransaction() {
        int count = 1;
        for (Transaction t : transitionList) {
            if (Transaction.DEPOSIT.equals(t.getOperation())) {
                System.out.println("Giao dich " + count + ": Nap tien $"
                        + String.format("%.2f", t.getAmount()) + ". So du luc nay: $"
                        + String.format("%.2f", t.getBalance()) + ".");
            } else if (Transaction.WITHDRAW.equals(t.getOperation())) {
                System.out.println("Giao dich " + count + ": Rut tien $"
                        + String.format("%.2f", t.getAmount()) + ". So du luc nay: $"
                        + String.format("%.2f", t.getBalance()) + ".");
            }
            count++;
        }
    }
}
