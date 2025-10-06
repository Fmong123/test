package Bankingsystem;

public class SavingsAccount extends Account {
    public static final double MIN_BALANCE = 5000.0;
    public static final double MAX_WITHDRAW = 10000.0;

    public SavingsAccount() {
        super();
    }

    public SavingsAccount(long accountNumber, double balance) {
        super(accountNumber, balance);
    }

    @Override
    public void deposit(double amount) {
        try {
            doDepositing(amount);
        } catch (BankException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void withdraw(double amount) {
        try {
            if (amount > MAX_WITHDRAW) {
                throw new BankException(String.format(
                        "Số tiền rút vượt quá giới hạn cho phép: $%.2f (tối đa $%.2f)",
                        amount, MAX_WITHDRAW));
            }
            if (balance - amount < MIN_BALANCE) {
                throw new BankException(String.format(
                        "Không thể rút $%.2f. Số dư phải còn tối thiểu $%.2f",
                        amount, MIN_BALANCE));
            }

            doWithdrawing(amount);
        } catch (BankException e) {
            System.out.println(e.getMessage());
        }
    }
}
