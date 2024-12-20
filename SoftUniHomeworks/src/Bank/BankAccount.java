package Bank;

public class BankAccount {
    private static final double INTEREST_RATE = 0.02;
    private static int bankAccountCount = 1;
    private int id;
    private double balance;
    private static double interestRate = INTEREST_RATE;

    public BankAccount () {
        this.id = bankAccountCount++;
    }

    public static void setInterestRate (Double interestRate) {
        BankAccount.interestRate = interestRate;
    }

    public void deposit (double amount) {
        this.balance += amount;
    }

    public double getInterest (int years) {
        return interestRate * this.balance * years;
    }

    public int getId() {
        return id;
    }
}
